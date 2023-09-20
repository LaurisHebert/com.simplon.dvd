package com.simplon.dvd.entitys;

import com.simplon.dvd.Enum.Genre;
import com.simplon.dvd.Enum.Type;
import com.simplon.dvd.services.DvdServiceModel;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "dvd")
@NoArgsConstructor
public class DvdEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "isan", unique = true, nullable = false)
    private String isan;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "release_date", nullable = false)
    private Integer releaseDate;
    // à mettre en milliSecondes dans service

    @Column(name = "directed_by", nullable = false)
    private String directedBy;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Enumerated(EnumType.ORDINAL)
    private Genre genre;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "resume", nullable = false, columnDefinition = "TEXT")
    private String resume;

    @Column(name = "film_cover")
    private String filmCover;

    @Enumerated(EnumType.ORDINAL)
    private Type type;

    public DvdEntity(DvdServiceModel dvd) {
        this.id = dvd.getId();
        this.isan = dvd.getIsan();
        this.title = dvd.getTitle();
        this.releaseDate = dvd.getReleaseDate();
        this.directedBy = dvd.getDirectedBy();
        this.duration = dvd.getDuration();
        this.genre = dvd.getGenre();
        this.quantity = dvd.getQuantity();
        this.resume = dvd.getResume();
        this.filmCover = dvd.getFilmCover();
        this.type = dvd.getType();
    }

}
