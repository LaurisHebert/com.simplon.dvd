package com.simplon.dvdStore.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

/**
 * The type Role repository model sql.
 */
@Entity
@Data
@Table(name = "role")
@AllArgsConstructor
@NoArgsConstructor
public class RoleRepositoryModelSQL implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }

}