package services;

import models.Users;
import net.jodah.expiringmap.ExpiringMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;

public class QueueManager {

    private Map<Integer, Queue<String>> queueMap;
    private Map<String, String> callMap;
    private Map<String, Users> usersMap;

    private static class Holder {
        public static QueueManager queueManager = new QueueManager();
    }

    private QueueManager() {
        this.queueMap = new HashMap<>();
        callMap = ExpiringMap.builder().maxSize(1024).expiration(2, TimeUnit.MINUTES).build();
        usersMap = ExpiringMap.builder().maxSize(4096).expiration(1, TimeUnit.DAYS).build();
    }

    public static QueueManager getInstance() {
        return Holder.queueManager;
    }

    public synchronized Users getNextCaller(int level, String caller) {
        Users callee = null;
        try {
            callee = IsInCall(caller);
            if (callee != null) {
                return callee;
            }
            return addOrGetFromCallQueue(level, caller);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return callee;
    }

    private Users addOrGetFromCallQueue(int level, String caller) {
        Users callee = null;
        try {
            if (queueMap.containsKey(level)) {
                Queue<String> strings = queueMap.get(level);
                if (strings == null || strings.isEmpty()) {
                    addToCallQueue(level, caller);
                    return callee;
                }
                callee = usersMap.get(strings.poll());
                if (callee != null) {
                    if (callee.getId().equals(caller)) {
                        addToCallQueue(level, caller);
                        return null;
                    } else {
                        addInCall(caller, callee.getId());
                    }
                } else {
                    addToCallQueue(level, caller);
                }
            } else {
                addToCallQueue(level, caller);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return callee;
    }

    private void addToCallQueue(int level, String caller) {
        Queue<String> strings = queueMap.get(level);
        if (strings == null) {
            strings = new ConcurrentLinkedDeque<>();
        }
        if(!strings.contains(caller))
            strings.add(caller);
        queueMap.putIfAbsent(level, strings);
    }


    public synchronized boolean updateUser(Users users) {
        try {
            System.out.println(users.getId()+" "+ users.getLevel());
            usersMap.putIfAbsent(users.getId(), users);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;
    }

    public Users getCachedUsers(String id) throws Exception {
        return usersMap.get(id);
    }

    public synchronized boolean addInCall(String caller, String callee) {
        callMap.put(callee, caller);
        callMap.put(caller, callee);
        return true;
    }

    public synchronized boolean removeFromInCall(String caller) {
        try {
            removeFromInCall(caller, callMap.get(caller));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public synchronized boolean removeFromInCall(String caller, String callee) {
        if (isValid(callee)) {
            callMap.remove(callee);
        }
        if (isValid(caller)) {
            callMap.remove(caller);
        }
        return true;
    }

    public synchronized Users IsInCall(String caller) {
        try {
            String callee = callMap.get(caller);
            if (isValid(callee)) {
                return getCachedUsers(callee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static boolean isValid(String value) {
        return value != null && !value.isEmpty();
    }





}
