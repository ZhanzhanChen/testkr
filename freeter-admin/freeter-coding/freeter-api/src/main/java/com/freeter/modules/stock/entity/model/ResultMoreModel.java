package com.freeter.modules.stock.entity.model;

import java.io.Serializable;
import java.util.List;

public class ResultMoreModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean success;

    private String[] messages;
    
    private boolean hasErrors;
    
    private String allMessages;

    private List<LatlngModel> data;

    public ResultMoreModel() {
    }

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String[] getMessages() {
		return messages;
	}

	public void setMessages(String[] messages) {
		this.messages = messages;
	}

	public boolean isHasErrors() {
		return hasErrors;
	}

	public void setHasErrors(boolean hasErrors) {
		this.hasErrors = hasErrors;
	}

	public String getAllMessages() {
		return allMessages;
	}

	public void setAllMessages(String allMessages) {
		this.allMessages = allMessages;
	}

	public List<LatlngModel> getData() {
		return data;
	}

	public void setData(List<LatlngModel> data) {
		this.data = data;
	}
	

//    public ResultModel(Boolean success, String messages, Boolean hasErrors, String allMessage) {
//        this.success = success;
//        this.messages = messages;
//        this.hasErrors = hasErrors;
//        this.allMessage = allMessage;
//    }
//
//    public ResultModel(Boolean success, String messages, Boolean hasErrors, String allMessage, T data) {
//        this.success = success;
//        this.messages = messages;
//        this.hasErrors = hasErrors;
//        this.allMessage = allMessage;
//        this.data = data;
//    }
    
    

}
