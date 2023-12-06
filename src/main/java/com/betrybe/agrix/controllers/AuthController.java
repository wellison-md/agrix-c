package com.betrybe.agrix.controllers;

import com.betrybe.agrix.dtos.AuthDto;
import com.betrybe.agrix.dtos.TokenDto;
import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import com.betrybe.agrix.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Auth controller.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
  private final AuthenticationManager authenticationManager;
  private final PersonService personService;
  private final TokenService tokenService;

  /**
   * Instantiates a new Auth controller.
   *
   * @param authenticationManager the authentication manager
   * @param personService         the person service
   * @param tokenService          the token service
   */
  @Autowired
  public AuthController(
      AuthenticationManager authenticationManager,
      PersonService personService,
      TokenService tokenService
  ) {
    this.authenticationManager = authenticationManager;
    this.personService = personService;
    this.tokenService = tokenService;
  }

  /**
   * Login response entity.
   *
   * @param authDto the auth dto
   * @return the response entity
   */
  @PostMapping("/login")
  public ResponseEntity<TokenDto> login(@RequestBody AuthDto authDto) {

    UsernamePasswordAuthenticationToken usernamePassword =
        new UsernamePasswordAuthenticationToken(authDto.username(), authDto.password());
    Authentication auth = authenticationManager.authenticate(usernamePassword);

    UserDetails person = (UserDetails) auth.getPrincipal();
    String token = tokenService.generateToken((Person) person);

    return ResponseEntity.status(HttpStatus.OK).body(new TokenDto(token));
  }
}
