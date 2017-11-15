package transferDTOs;

public class ServerDTO {
	private String IPaddress;
	private int port;
	
	public ServerDTO(String iPaddress, int port) {
		super();
		IPaddress = iPaddress;
		this.port = port;
	}
	public String getIPaddress() {
		return IPaddress;
	}
	public void setIPaddress(String iPaddress) {
		IPaddress = iPaddress;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
}
