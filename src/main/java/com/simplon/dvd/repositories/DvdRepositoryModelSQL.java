package com.simplon.dvd.repositories;

import com.simplon.dvd.Enum.Genre;
import com.simplon.dvd.Enum.Type;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "dvd")
@NoArgsConstructor
public class DvdRepositoryModelSQL {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "isan", unique = true, nullable = false)
    private String isan;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "directed_by", nullable = false)
    private String directedBy;
    @Column(name = "duration", nullable = false)
    private Integer duration;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
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
