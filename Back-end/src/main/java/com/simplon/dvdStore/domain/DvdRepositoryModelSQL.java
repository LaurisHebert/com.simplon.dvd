package com.simplon.dvdStore.domain;


import com.simplon.dvdStore.enums.Genre;
import com.simplon.dvdStore.enums.Type;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * The type Dvd repository model sql.
 */
@Entity
@Data
@Table(name = "dvd")
@NoArgsConstructor
public class DvdRepositoryModelSQL {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "isan", unique = true, nullable = false)
    private String isan;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "directed_by", nullable = false)
    private String directedBy;
    @Column(name = "duration", nullable = false)
    private int duration;
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @Column(name = "resume", nullable = false, columnDefinition = "TEXT")
    private String resume;
    @Column(name = "film_cover")
    private String filmCover;
    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;
    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;
    @Column(name = "genre", nullable = false)
    @Enumerated(EnumType.STRING)
    private Genre genre;
}
