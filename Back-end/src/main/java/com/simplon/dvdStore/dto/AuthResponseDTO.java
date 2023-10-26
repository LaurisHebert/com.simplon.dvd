package com.simplon.dvdStore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * The type Auth response dto.
 */
@Data
@AllArgsConstructor
public class AuthResponseDTO {
    private UserDetails username;
    private String password;
}
