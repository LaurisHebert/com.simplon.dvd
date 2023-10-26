package com.simplon.dvdStore.dto;


import lombok.Data;

/**
 * The type Auth request dto.
 */
@Data
public class AuthRequestDTO {
    private String username;
    private String password;
}
