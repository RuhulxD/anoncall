package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import javafx.util.Pair;
import models.*;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.QueueManager;
import services.TopicManager;

import java.util.List;

public class ApplicationController extends Controller{
    private final QueueManager manager;
    private final TopicManager topicManager;

    public  ApplicationController(){
        manager = QueueManager.getInstance();
        topicManager = TopicManager.getInstance();
    }

    public Result addUser(){
        try {
            JsonNode node = request().body().asJson();
            Users user = Json.fromJson(node, Users.class);
            boolean b = manager.updateUser(user);
            return asJson(new BaseResponse(0, "success"));
        }catch (Exception ex){
            Logger.debug(request().body().asRaw().size()+"");
            return badRequest(Json.toJson(new BaseResponse(500,ex.getMessage())));
        }
    }

    public Result makeCall(){
        ResponseDTO<Users> responseDTO = new ResponseDTO<>();
        try{
            JsonNode node = request().body().asJson();
            Users users = Json.fromJson(node, Users.class);

            Users caller = manager.getNextCaller(users.getLevel(), users.getId());
            if(caller != null){
                responseDTO.setReasonCode(0);
                responseDTO.setT(caller);
            }else{
                responseDTO.setReasonCode(404);
                responseDTO.setMessage("No user found.");
            }
            return asJson(responseDTO);
        }catch (Exception ex){
            Logger.debug(request().body().asText());
            ex.printStackTrace();
            responseDTO.setReasonCode(500);
            responseDTO.setMessage(ex.getMessage());
            return asJson(responseDTO);
        }
    }

    public Result endCall(){
        BaseResponse baseResponse = new BaseResponse();
        try{
            JsonNode node = request().body().asJson();
            if(node !=null) {
                CallInformation info = Json.fromJson(node, CallInformation.class);
                Pair<Users, Users> users = info.getUsers();
                boolean b = manager.removeFromInCall(users.getKey().getId(), users.getValue().getId());
                return toStatus(0, "success");
            }else{
                return toStatus(500, "unable to parse body"+node.asText());
            }
        }catch (Exception e){
            Logger.debug(request().body().asText());
            Logger.error(e.getMessage(), e);
            return toStatus(500, e.getMessage()+request().body().asText());
        }
    }

    public Result inCall(String caller, String callee){
        try {
            manager.removeFromInCall(caller, callee);
            return toStatus(0, "success");
        }catch (Exception e){
            Logger.debug("caller and callee: = "+ caller+" "+callee);
            Logger.error(e.getMessage(), e);
            return toStatus(0, e.getMessage());
        }
    }
    public Result getTopics(){
        try{
            return asJson(topicManager.getTopics());
        }catch (Exception ex){
            Logger.error(ex.getMessage(), ex);
        }
        return badRequest();
    }

    private static Result toStatus(int code, String message){
        BaseResponse baseResponse = new BaseResponse(code, message);
        return ok(Json.toJson(baseResponse));
    }

    private static Result asJson(BaseResponse obj){
        return ok(Json.toJson(obj));
    }

    private static Result asJson(ResponseDTO obj){
        return ok(Json.toJson(obj));
    }

    private static Result asJson(List obj){
        ListResponseDTO responseDTO = new ListResponseDTO();
        responseDTO.setT(obj);
        return ok(Json.toJson(obj));
    }

}
