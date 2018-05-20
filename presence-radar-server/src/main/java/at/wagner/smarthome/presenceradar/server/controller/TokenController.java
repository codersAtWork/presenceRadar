package at.wagner.smarthome.presenceradar.server.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import at.wagner.smarthome.presenceradar.server.entity.Token;
import at.wagner.smarthome.presenceradar.server.repository.TokenRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TokenController {

	private final TokenRepository repository;

	@GetMapping("/tokens-list")
	public Collection<Token> persons() {
		return repository.findAll();
	}

}
