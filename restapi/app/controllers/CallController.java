/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;
import models.User;
import models.UserStatus;
import play.libs.Json;
import play.mvc.*;
import static play.mvc.Results.ok;

/**
 *
 * @author RajibTheKing
 */
public class CallController extends Controller {
    public static Queue<User> queue = new LinkedList<User>();
    
    public Result call(String DeviceID) {
        User user = HomeController.g_UserMap.get(DeviceID);
        if(user == null)
        {
            return ok("Device ID = \"" + DeviceID + "\" is not registered");
        }
        System.out.println("UserStatus = " + HomeController.g_UserMap.get(DeviceID).getStatus());
        
        
        
        if(queue.isEmpty())
        {
            user.setStatus(UserStatus.WAITING_FOR_CALL);
            queue.add(user);
            return ok("Device ID = \"" + DeviceID + "\" is Added for Call");
        }
        else
        {
            
            User opponentSelectedUser = queue.poll();
            if(opponentSelectedUser.getDeviceID().compareTo(user.getDeviceID()) == 0)
            {
                user.setStatus(UserStatus.WAITING_FOR_CALL);
                queue.add(user);
                return ok("Device ID = \"" + DeviceID + "\" is added Previously");
            }
            else
            {
                return ok("Current DeviceID = \"" + DeviceID + "\" and Opponent DeviceID = \"" + opponentSelectedUser.getDeviceID());
            }
            
            /*
            for (User item : queue) 
            {
                if(item.getDeviceID().compareTo(user.getDeviceID()) == 0 || item.getStatus() != UserStatus.WAITING_FOR_CALL)
                {
                    continue;
                }
                
                opponentSelectedUser = item;
                break;
                
            }
            
            if(opponentSelectedUser == null)
            {
                return ok("Opponent User Not Found in Queue");
            }
            */
        }
        
        
        
    }
    boolean isUserAvailableOnQueue(User user)
    {
        if(queue.isEmpty()) return false;
        
        for (User item : queue) 
        {
            if(item.getDeviceID().compareTo(user.getDeviceID()) == 0)
            {
                return true;
            }

        }
        
        return false;
        
    }
    public Result tahmid() {
        return ok("I am inside tahmid");
    }

}
