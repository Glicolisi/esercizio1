package co.develhope.bugtracker.controller;

import co.develhope.bugtracker.controller.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import co.develhope.bugtracker.service.UserService;

import java.util.List;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/user/create")
	@Operation(description = "questo metodo crea un nuovo utente")
	@ApiResponse()
	public CreateUserResponseDto createUser(@RequestBody CreateUserRequestDto request) {
		return userService.createUser(request);
	}

	@DeleteMapping("/user/delete")
	public BaseResponse deleteUser(@RequestBody DeleteUserRequestDto delete) {

		return userService.deleteUser(delete);

	}

	@PutMapping("/user/change-password")
	public BaseResponse changePassword(@RequestBody ChangePasswordRequestDto request){
		return userService.changePassword(request);
	}

	@GetMapping("/user/aspirapolvere")
	public List<UserAspirapolvereResponseDto> getAspirapolvere (){
		return userService.getAspirapolvere();
	}
	
}
