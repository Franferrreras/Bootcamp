package com.nttdata.bootcamp.productservice.dto;

import java.util.Enumeration;

public class ProductDTO {

	private Long id;
	
	private String channel;
	
	private String serverPort;

	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getServerPort() {
		return serverPort;
	}

	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}

	

}
