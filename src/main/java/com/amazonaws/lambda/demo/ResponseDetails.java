package com.amazonaws.lambda.demo;

public class ResponseDetails {
	
	private String messageId;
	private String messageReason;
	
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getMessageReason() {
		return messageReason;
	}
	public void setMessageReason(String messageReason) {
		this.messageReason = messageReason;
	}
	
	@Override
	public String toString() {
		return "ResponseDetails [messageId=" + messageId + ", messageReason=" + messageReason + "]";
	}
	
	
	

}
