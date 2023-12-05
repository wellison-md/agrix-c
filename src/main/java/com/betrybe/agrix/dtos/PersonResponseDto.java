package com.betrybe.agrix.dtos;

import com.betrybe.agrix.ebytr.staff.security.Role;

/**
 * Person Response DTO.
 *
 * @param id the person id
 * @param username the username
 * @param role the role
 */
public record PersonResponseDto(Long id, String username, Role role) {
}
