package com.postgresexample.postgresample.ExceptionEmployee;

public class EmpNotFoundException extends Exception{
    public EmpNotFoundException(String message){
        super(message);
    }

}
