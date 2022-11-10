package com.ayushkaam.exception;

public class MemberNotFoundException extends RuntimeException{

public MemberNotFoundException() {
		
	}
	
public MemberNotFoundException(String Message) {
		super(Message);
	}
	
}
