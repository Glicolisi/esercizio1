package co.develhope.bugtracker.controller;

import co.develhope.bugtracker.controller.dto.BaseResponse;
import co.develhope.bugtracker.controller.dto.DeleteUserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.develhope.bugtracker.controller.dto.CreateUserRequestDto;
import co.develhope.bugtracker.controller.dto.CreateUserResponseDto;
import co.develhope.bugtracker.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/user/create")
	public CreateUserResponseDto createUser(@RequestBody CreateUserRequestDto request) {
		return userService.createUser(request);
	}

	@DeleteMapping("user/delete")
	public BaseResponse deleteUser(@RequestBody DeleteUserRequestDto delete) {

		return userService.deleteUser(delete);

	}
	
}
