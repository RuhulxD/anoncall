package controllers;

import play.mvc.*;
import play.libs.Json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import views.html.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import java.security.SecureRandom;

import models.User;

public class RegisterController extends Controller 
{
    static final String alphaNumeric = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();





    public Result register(String DeviceID) 
    {
        System.out.println("TheKing--> register function");

        if(HomeController.g_UserMap.containsKey(DeviceID) == true)
        {
            //User user = HomeController.g_UserMap.getValue(DeviceID);
            User user = HomeController.g_UserMap.get(DeviceID);
            System.out.println("UserID = " + user.getUserID());

            JsonNode userJson = Json.toJson(user); 

            return ok(userJson.toString());

        }
        else
        {
            String userID = generateUserID();
            String passWord = generatePassWord();
            User newUser = new User(userID, passWord, DeviceID);
            HomeController.g_UserMap.put(DeviceID, newUser);

            JsonNode userJson = Json.toJson(newUser); 
            return ok(userJson.toString());   
        }



    }

    private String generateUserID()
    {
        while(true)
        {
            System.out.println("TheKing--> Trying to generate new User ID");
            String newUserID = randomString(6);
            Set set = HomeController.g_UserMap.entrySet();
            Iterator iterator = set.iterator();
            boolean matchFound = false;
            while(iterator.hasNext()) 
            {

                Map.Entry mentry = (Map.Entry)iterator.next();
                User user = (User)mentry.getValue();
                if(newUserID.compareTo(user.getUserID()) == 0)
                {
                    matchFound = true;
                    break;
                }

                
            }
            if(matchFound == false)
            {
                return newUserID;
            }
        }
    }

    private String generatePassWord()
    {
        return randomString(8);
    }

    private String randomString( int len)
    {
       StringBuilder sb = new StringBuilder( len );
       for( int i = 0; i < len; i++ ) 
          sb.append( alphaNumeric.charAt( rnd.nextInt(alphaNumeric.length()) ) );
       return sb.toString();
    }


}