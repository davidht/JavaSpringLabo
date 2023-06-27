package com.javaspringlabo.monproject.exception;

public class BadDateException extends RuntimeException {

	public BadDateException() {

		super("Please to use the format 'yyyy-MM-dd hh.mm'");
	}
}