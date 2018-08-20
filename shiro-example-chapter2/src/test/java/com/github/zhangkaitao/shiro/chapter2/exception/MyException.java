package com.github.zhangkaitao.shiro.chapter2.exception;

import org.apache.shiro.authc.AccountException;

public class MyException extends AccountException {
	
	public MyException(String message) {
        super(message);
    }
}
