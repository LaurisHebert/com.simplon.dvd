package com.simplon.dvdStore.domain;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Data
@Table(name = "role")
public class RoleRepositoryModelSQL implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Override
    public String getAuthority() {
        return name;
    }

}