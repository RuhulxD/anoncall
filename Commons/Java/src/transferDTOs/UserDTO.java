package transferDTOs;

public class UserDTO {
	private String userId;
	static public enum GenderType{
		male,
		female,
		other
	};
	private String info;
	private String gender;
	
	public UserDTO(String userId, String info, GenderType gender) {
		super();
		this.userId = userId;
		this.info = info;
		this.gender = gender.name();
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}


	public String getGender() {
		return gender;
	}

	public void setGender(GenderType gender) {
		this.gender = gender.name();
	}
	
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", info=" + info + ", gender=" + gender + "]";
	}
	
	public static void main(String... args) {
		UserDTO user = new UserDTO("afasdfa", "info", GenderType.male);
		System.out.println(""+ user.toString());
	}
}
