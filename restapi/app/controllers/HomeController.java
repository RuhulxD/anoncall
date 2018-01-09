package controllers;

import play.mvc.*;

import views.html.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import org.json.*;
import models.User;

public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public static HashMap<String/*DevicID*/, User/*User Information*/> g_UserMap = new HashMap<String, User>();
    //public static HashMap<String/*DevicID*/, String/*User Information*/> g_UserMap = new HashMap<String, String>();

    public Result index() {
        //response().setHeader(CACHE_CONTROL, "max-age=3600");
    	//response().setHeader(ETAG, "xxx");
        return ok("Owner: sustpioneers<br/>Project name: RestAPI").as("text/html");
    }

    public Result users()
    {
        JSONObject jsonData = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        try{
            Set set = HomeController.g_UserMap.entrySet();
            Iterator iterator = set.iterator();
            while(iterator.hasNext()) 
            {

                Map.Entry mentry = (Map.Entry)iterator.next();
                User user = (User)mentry.getValue();
                JSONObject detailJson = new JSONObject();
                detailJson.put("userID", user.getUserID());
                detailJson.put("passWord", user.getPassWord());
                detailJson.put("deviceID", user.getDeviceID());


                jsonArray.put(detailJson);
                
            }

            System.out.println("TheKing--> number of users: " + jsonArray.length());
            jsonData.put("users", jsonArray);
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return ok(jsonData.toString());

    }

}
