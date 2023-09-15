package com.yejun.app.aop;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.yejun.app.dto.ResponseDTO;

@Component
@Aspect
public class ValidCheckAOP {
	@Around(value = "execution(* com.yejun.app.controller.*Controller.*(..))")
	public Object validCheck(ProceedingJoinPoint joinPoint) throws Throwable {
		Object[] args = joinPoint.getArgs();
		
		for (Object arg : args) {
			if (arg instanceof BindingResult) {
				BindingResult bindingResult = (BindingResult) arg;
				if (bindingResult.hasErrors()) {
					Map<String, String> errorMap = new HashMap<>();
					for (FieldError error : bindingResult.getFieldErrors()) {
						errorMap.put(error.getField(), error.getDefaultMessage());
					}
					return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), errorMap);
				}
			}
		}
		
		return joinPoint.proceed();
	}
}
