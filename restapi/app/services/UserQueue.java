package services;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.eclipse.jetty.util.ConcurrentHashSet;

import transferDTOs.UserDTO;

public class UserQueue  {
	private final ConcurrentLinkedQueue<UserDTO> waitingQueue;
	private final ConcurrentHashMap<String, UserDTO> inCall;
	
	private static volatile UserQueue INSTANCE =null;
	
	private UserQueue() {
		waitingQueue = new ConcurrentLinkedQueue<>();
		inCall = new ConcurrentHashMap<>();
	}
	
	public static UserQueue getInstance(){
		UserQueue q = INSTANCE;
		if(q == null){
			synchronized (INSTANCE) {
				q = INSTANCE;
				if(q==null){
					INSTANCE = q = new UserQueue();
				}
			}
		}
		return q;
	}
	
	public UserDTO getUser(){
		return waitingQueue.poll();
	}
	public boolean addUser(UserDTO user){
		return waitingQueue.add(user);
	}
	public boolean removeUser(UserDTO user){
		return waitingQueue.remove(user);
	}
	
	public UserDTO getCall(String callID){
		return inCall.get(callID);
	}
	
	public UserDTO startCall(String callID, UserDTO userDTO){
		return inCall.put(callID, userDTO);
	}
	
	public UserDTO endCall(String callID){
		return inCall.remove(callID);
	}
	
}
