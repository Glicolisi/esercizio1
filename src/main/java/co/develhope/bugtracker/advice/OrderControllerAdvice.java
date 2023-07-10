package co.develhope.bugtracker.advice;

import co.develhope.bugtracker.exception.ForbiddenException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import co.develhope.bugtracker.controller.dto.BaseResponse;
import co.develhope.bugtracker.controller.dto.GetOrderDto;
import co.develhope.bugtracker.controller.dto.BaseResponse.Status;
import co.develhope.bugtracker.exception.ConflictException;
import co.develhope.bugtracker.exception.NotFoundException;

@RestControllerAdvice
public class OrderControllerAdvice {

	@ExceptionHandler(value = {NotFoundException.class})
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public BaseResponse handlingNotFound(NotFoundException e) {
		BaseResponse br = new BaseResponse();
		br.setStatus(Status.KO);
		br.setErrorMessage("RESOURCE_NOT_FOUND");
		return br;
	}
	
	@ExceptionHandler(value = {ConflictException.class})
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public BaseResponse handlingConflict(ConflictException e) {
		BaseResponse br = new BaseResponse();
		br.setStatus(Status.KO);
		br.setErrorMessage("RESOURCE_CONFLICT");
		return br;
	}

	@ExceptionHandler(value = {ForbiddenException.class})
	@ResponseStatus(value = HttpStatus.FORBIDDEN)
	public BaseResponse handlingForbidden(ForbiddenException e){
		BaseResponse br = new BaseResponse();
		br.setStatus(Status.KO);
		br.setErrorMessage(e.getMessage());
		return br;
	}

	
	
}
