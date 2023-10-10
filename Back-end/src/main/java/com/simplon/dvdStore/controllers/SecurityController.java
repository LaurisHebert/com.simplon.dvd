package com.simplon.dvdStore.controllers;

import com.simplon.dvdStore.dto.AuthRequestDTO;
import com.simplon.dvdStore.dto.AuthResponseDTO;
import com.simplon.dvdStore.exeception.AccountExistsException;
import com.simplon.dvdStore.exeception.UnauthorizedException;
import com.simplon.dvdStore.services.JwtUserService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @Autowired
    private JwtUserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(@RequestBody AuthRequestDTO dto) throws AccountExistsException {
        UserDetails user = userService.save(dto.getUsername(), dto.getPassword());
        String token = userService.generateJwtForUser(user);
        return ResponseEntity.ok(new AuthResponseDTO(user,token));
    }

    @PostMapping("/authorize")
    public ResponseEntity<AuthResponseDTO> authorize(@RequestBody AuthRequestDTO requestDTO) throws UnauthorizedException {
        Authentication authentication = null;
        try {
            authentication = userService.authenticate(requestDTO.getUsername(), requestDTO.getPassword());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails user = (UserDetails) authentication.getPrincipal();
            String token = userService.generateJwtForUser(user);
            return ResponseEntity.ok(new AuthResponseDTO(user, token));
        } catch (AuthenticationException e) {
            throw new UnauthorizedException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
