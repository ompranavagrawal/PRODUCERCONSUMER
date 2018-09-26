package com.example.MessageProducer;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {
	@ExceptionHandler(Exception.class)
	public void handler(HttpServletResponse res){
		try{
			res.sendRedirect("http://google.com");
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

}
