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
import co.develhope.bugtracker.entity.Utente;
import co.develhope.bugtracker.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Value("${userphisicaldelete}")//CREATA PROPRIETIES PER SCEGLIERE CANCELLAZIONE LOGICA O FISICA
	private Boolean userPhisicaldelete;
	public CreateUserResponseDto createUser(CreateUserRequestDto request) {

		Optional<Utente> oUser = userRepository.findByUsername(request.getUsername());
		if(oUser.isPresent()){
		oUser.orElseThrow(() -> new ConflictException());}
		Utente user = new Utente();
		user.setUsername("Aldo Baglio");
		user.setPassword("Password");
		user.setDeleted(false);
		user=userRepository.save(user);// Ora l'ID non è null

		CreateUserResponseDto createUserResponseDto = new CreateUserResponseDto();
		createUserResponseDto.setId(user.getId());
		return createUserResponseDto ;
	}

	
	private Utente fromRequestToEntity(CreateUserRequestDto request) {
		Utente utente = new Utente();
		utente.setPassword(request.getPassword());
		utente.setUsername(request.getUsername());
		return utente;
	}
	
	private CreateUserResponseDto fromEntityToResponse(Utente utente) {
		CreateUserResponseDto createUserResponseDto = new CreateUserResponseDto();
		createUserResponseDto.setId(utente.getId());
		return createUserResponseDto;
	}

    public BaseResponse deleteUser(DeleteUserRequestDto delete) {

		Optional<Utente> user = userRepository.findById(delete.getId());
		if(user.isEmpty()) {
			throw new RuntimeException(); //NIENTE ELSE PERCHé TANTO ESCE CON L'ECCEZIONE
		}
			Utente useru = user.get();

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
