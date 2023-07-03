package co.develhope.bugtracker.service;

import java.util.Optional;

import co.develhope.bugtracker.controller.dto.BaseResponse;
import co.develhope.bugtracker.controller.dto.DeleteUserRequestDto;
import co.develhope.bugtracker.exception.ConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import co.develhope.bugtracker.controller.dto.CreateUserRequestDto;
import co.develhope.bugtracker.controller.dto.CreateUserResponseDto;
import co.develhope.bugtracker.entity.User;
import co.develhope.bugtracker.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	//@Value("${phisicaldelete}")//CREATA PROPRIETIES PER SCEGLIERE CANCELLAZIONE LOGICA O FISICA
	private Boolean userPhisicaldelete=true;
	public CreateUserResponseDto createUser(CreateUserRequestDto request) {
		Optional<User> oUser = userRepository.findByUsername(request.getUsername());
		 oUser.orElseThrow(() -> new ConflictException());
		User user = new User();
		user.setUsername("Aldo Baglio");
		user.setPassword("Password");
		user.setDeleted(false);
		user=userRepository.save(user);// Ora l'ID non è null
		CreateUserResponseDto createUserResponseDto = new CreateUserResponseDto();
		createUserResponseDto.setId(user.getId());
		return createUserResponseDto ;
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

    public BaseResponse deleteUser(DeleteUserRequestDto delete) {

		Optional<User> user = userRepository.findById(delete.getId());
		if(user.isEmpty()) {
			throw new RuntimeException(); //NIENTE ELSE PERCHé TANTO ESCE CON L'ECCEZIONE
		}
			User useru = user.get();

		if(userPhisicaldelete){
			userRepository.delete(useru);
		}
		else{
			useru.setDeleted(true);
			userRepository.save(useru);
		}
		return new BaseResponse();
    }
}
