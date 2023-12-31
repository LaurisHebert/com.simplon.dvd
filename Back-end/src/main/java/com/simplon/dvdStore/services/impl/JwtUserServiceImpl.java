package com.simplon.dvdStore.services.impl;

import com.simplon.dvdStore.domain.OwnerRepositoryModelSQL;
import com.simplon.dvdStore.domain.RoleRepositoryModelSQL;
import com.simplon.dvdStore.exeception.AccountExistsException;
import com.simplon.dvdStore.repositories.OwnerRepository;
import com.simplon.dvdStore.services.JwtUserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * The type Jwt user service.
 */
@Service
public class JwtUserServiceImpl implements JwtUserService {

    private final String signingKey;
    /**
     * The Authentication configuration.
     */
    @Autowired
    AuthenticationConfiguration authenticationConfiguration;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Instantiates a new Jwt user service.
     *
     * @param signingKey the signing key
     */
    public JwtUserServiceImpl(@Value("${jwt.signing.key}") String signingKey) {
        this.signingKey = signingKey;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        OwnerRepositoryModelSQL owner = ownerRepository.findByLogin(username);
        if (owner == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return owner;
    }

    @Override
    public Authentication authenticate(String username, String password) throws Exception {
        Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
        return authenticationConfiguration
                .getAuthenticationManager()
                .authenticate(authentication);
    }

    @Override
    public UserDetails save(String username, String password) throws AccountExistsException {
        UserDetails existingUser = ownerRepository.findByLogin(username);
        if (existingUser != null) {
            throw new AccountExistsException();
        }
        OwnerRepositoryModelSQL owner = new OwnerRepositoryModelSQL();
        owner.setLogin(username);
        owner.setPassword(passwordEncoder.encode(password));
        owner.setRoles(List.of(new RoleRepositoryModelSQL(1, "1")));
        ownerRepository.save(owner);
        return owner;
    }

    @Override
    public UserDetails getUserFromJwt(String jwt) {
        String username = getUsernameFromToken(jwt);
        return loadUserByUsername(username);
    }

    private String getUsernameFromToken(String token) {
        System.out.println(signingKey);
        Claims claims = Jwts
                .parser()
                .setSigningKey(signingKey)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    @Override
    public String generateJwtForUser(UserDetails user) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 1000 * 60 * 60);
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, signingKey)

                .compact();
    }

}
