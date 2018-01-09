import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Gender;
import models.Users;
import services.QueueManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;

public class QueueManagerTest {

    private static Random rand = new Random(System.currentTimeMillis());
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private static List<Users> getRandomUsers(int x){
        List<Users> users = new ArrayList<>();
        for(int i=0;i<x; i++){
            users.add(getRandomUser());
        }
        return users;
    }
    private static Users getRandomUser(){
        Users  u = new Users();
        u.setId(rand.nextInt()+"");
        u.setLevel(rand.nextInt(3));
        u.setGender(Gender.MALE);
        u.setName(rand.nextFloat()+"");
        return  u;
    }

    public static void main(String... args) throws ExecutionException {
        List<Users> users = getRandomUsers(rand.nextInt(20));
        QueueManager manager = QueueManager.getInstance();
        for(Users usr: users) {
            manager.updateUser(usr);
        }
        for(int i=0; i<100; i++){
            Users x = users.get(rand.nextInt(users.size()));
            print("selected users: "+ x.getId());
            Users nextCaller = manager.getNextCaller(x.getLevel(), x.getId());
//            if(nextCaller == null){
//                System.out.println("not found... q map size() ->"+ manager.queueMap.size());
//            }else{
//                print("next caller: "+ nextCaller.getId());
//                print("incall :" ,nextCaller.getId()+" <> "+ manager.callMap.get(nextCaller.getId()), manager.callMap.size());
//            }
//            if(rand.nextInt(100)%5==0){
//                System.out.println("ending calls->"+ x.getId());
//                manager.removeFromInCall(x.getId());
//            }
        }
    }

    public static void print(Object... obj){
        System.out.println(gson.toJson(obj));
    }
}
