package controllers;

import javax.inject.Singleton;

import play.mvc.Controller;
import services.UserHandler;


@Singleton
public class CallController  extends Controller{
	static UserHandler handler = new UserHandler();
	
	public CallController() {
	}
	
	
	
	
	
}
