package com.creditsuisse.entity;

/**
 * @author 007
 *
 */
public class Logger {

	private String id;
	private String state;
	private Long timestamp;
	private String type;
	private String host;
	private String alert;
	
	public String getAlert() {
		return alert;
	}
	public void setAlert(String alert) {
		this.alert = alert;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	@Override
	public String toString() {
		return "Logger [id=" + id + ", duration=" + timestamp + ", type=" + type + ", host="
				+ host + ", alert=" + alert + "]";
	}
	
}
