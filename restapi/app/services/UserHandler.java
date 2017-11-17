package services;

import transferDTOs.UserDTO;

public class UserHandler {
	private UserQueue queue;

	public UserHandler() {
		this.queue = UserQueue.getInstance();
	}
	
	public UserDTO makeCall(UserDTO user){
		UserDTO callerDTO =queue.getCall(user.getUserId());
		if( callerDTO!= null){
			return callerDTO;
		}
		return queue.getUser();
	}
	
	public boolean endCall(UserDTO user){
		queue.endCall(user.getUserId());
		queue.removeUser(user);
		return true;
	}
	
	
	
}
