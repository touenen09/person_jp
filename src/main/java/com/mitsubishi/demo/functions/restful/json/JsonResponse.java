package com.mitsubishi.demo.functions.restful.json;

import java.util.ArrayList;
import java.util.List;

public class JsonResponse<T> {

	private T data;

	private boolean success = true;

	private List<String> messages = new ArrayList<String>();

	private String msgLevel;

	public JsonResponse(T data) {
		this.data = data;
	}

	public JsonResponse(T data, boolean success) {
		this.data = data;
		this.success = success;
	}

	public JsonResponse(boolean success, String message, String msgLevel) {
		this.success = success;
		this.messages.add(message);
		this.msgLevel = msgLevel;
	}

	public JsonResponse(T data, boolean success, String message, String msgLevel) {
		this.data = data;
		this.success = success;
		this.msgLevel = msgLevel;
		this.messages.add(message);
	}

	public T getData() {
		return this.data;
	}

	public boolean isSuccess() {
		return this.success;
	}

	public void addMessage(String message) {
		this.messages.add(message);
	}

	public List<String> getMessages() {
		return this.messages;
	}

	public String getMsgLevel() {
		if (this.msgLevel == null) {
			return "";
		} else {
			return this.msgLevel;
		}
	}
}