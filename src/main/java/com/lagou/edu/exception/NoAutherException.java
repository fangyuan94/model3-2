package com.lagou.edu.exception;

/**
 * 定义
 */
public class NoAutherException extends RuntimeException{

    public NoAutherException() {

    }

    public NoAutherException(String message) {
        super(message);
    }

}
