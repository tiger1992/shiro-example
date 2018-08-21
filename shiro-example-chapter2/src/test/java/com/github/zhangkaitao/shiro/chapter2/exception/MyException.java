package com.github.zhangkaitao.shiro.chapter2.exception;

import org.apache.shiro.authc.AccountException;

public class MyException extends AccountException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyException(String message) {
        super(message);
    }
}
