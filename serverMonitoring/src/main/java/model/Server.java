package model;

public class Server {
	private String name;
	private String ipAddress;
	
	public Server() {
		
	}
	
	public Server(String name, String ipAddress) {
		super();
		this.name = name;
		this.ipAddress = ipAddress;
	}
	@Override
	public String toString() {
		return "Server [name=" + name + ", ipAddress=" + ipAddress + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
}
