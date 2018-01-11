package com.ec.demo.exception;

/**
 * @author 张昊
 */
public class UserExistException extends Exception
{
    public UserExistException(String errorMsg)
    {
        super(errorMsg);
    }
}
