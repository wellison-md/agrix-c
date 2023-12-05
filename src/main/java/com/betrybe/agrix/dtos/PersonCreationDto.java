package com.betrybe.agrix.dtos;

/**
 * Person creation DTO.
 *
 * @param username the username
 * @param password the password
 * @param role the role
 */
public record PersonCreationDto(String username, String password, String role) {
}
