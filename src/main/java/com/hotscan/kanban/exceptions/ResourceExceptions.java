package com.hotscan.kanban.exceptions;

import org.springframework.stereotype.Component;

@Component
public class ResourceExceptions extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8278654877917701415L;

	public void serviceException(Exception e) {
		System.out.println(e.toString());
	}
}
