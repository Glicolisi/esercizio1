package co.develhope.bugtracker.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.develhope.bugtracker.controller.dto.CreateUserRequestDto;
import co.develhope.bugtracker.controller.dto.CreateUserResponseDto;
import co.develhope.bugtracker.entity.User;
import co.develhope.bugtracker.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public CreateUserResponseDto createUser(CreateUserRequestDto request) {
		Optional<User> oUser = userRepository.findByUsername(request.getUsername());
		oUser.orElseThrow(() -> new ConflictException());
		request.getUsername();
	}

	
	private User fromRequestToEntity(CreateUserRequestDto request) {
		User user = new User();
		user.setPassword(request.getPassword());
		user.setUsername(request.getUsername());
		return user;
	}
	
	private CreateUserResponseDto fromEntityToResponse(User user) {
		CreateUserResponseDto createUserResponseDto = new CreateUserResponseDto();
		createUserResponseDto.setId(user.getId());
		return createUserResponseDto;
	}
}
