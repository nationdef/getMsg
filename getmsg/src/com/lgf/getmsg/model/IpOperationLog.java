package com.lgf.getmsg.model;

public class IpOperationLog {

	private String requestIP;
	private String requestTime;
	private String requestNode;
	private String requestValue;
	public String getRequestIP() {
		return requestIP;
	}
	public void setRequestIP(String requestIP) {
		this.requestIP = requestIP;
	}
	public String getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}
	public String getRequestNode() {
		return requestNode;
	}
	public void setRequestNode(String requestNode) {
		this.requestNode = requestNode;
	}
	public String getRequestValue() {
		return requestValue;
	}
	public void setRequestValue(String requestValue) {
		this.requestValue = requestValue;
	}
	
	
	public String toString(){
		return "请求IP："+this.requestIP+"   ---请求时间："+this.requestTime+"   ---请求节点："+this.requestNode+"   ---请求内容："+this.requestValue;
		
		//""++""+""++""+""++""+""++""
		
	}
	
}
