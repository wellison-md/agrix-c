package com.betrybe.agrix.controllers;

import com.betrybe.agrix.dtos.PersonResponseDto;
import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Javadoc.
 */
@RestController
@RequestMapping(value = "/persons")
public class PersonController {

  private final PersonService personService;
  private final AuthenticationManager authenticationManager;

  @Autowired
  public PersonController(
      PersonService personService,
      AuthenticationManager authenticationManager
  ) {
    this.personService = personService;
    this.authenticationManager = authenticationManager;
  }

  /**
   * Create a person.
   *
   * @param person the person
   * @return person Response dto
   */
  @PostMapping
  public ResponseEntity<PersonResponseDto> createPerson(@RequestBody Person person) {
    Person newPerson = personService.create(person);

    PersonResponseDto personResponseDto = new PersonResponseDto(
        newPerson.getId(),
        newPerson.getUsername(),
        newPerson.getRole()
    );

    return ResponseEntity.status(HttpStatus.CREATED).body(personResponseDto);
  }
}
