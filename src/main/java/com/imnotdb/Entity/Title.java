package com.imnotdb.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nutz.dao.entity.annotation.*;
import org.nutz.dao.entity.annotation.Name;

import java.sql.Date;
import java.util.List;

@Table("title_basics")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Title {
    @Name
    private String tconst;
    @Column("titleType")
    private String titleType;
    @Column("primaryTitle")
    private String primaryTitle;
    @Column("originalTitle")
    private String originalTitle;
    @Column("isAdult")
    private boolean isAdult;
    @Column("startYear")
    private Integer startYear;
    @Column("endYear")
    private Integer endYear;
    @Column("runtimeMinutes")
    private Integer runtimeMinutes;
    @Column("genres")
    private String genres;
    @Many(field = "tconst")
    List<Principals> principals;
    @Many(field = "tconst")
    List<Akas> akas;
    @One(field = "tconst")
    Crew crew;
    @One(target = Ratings.class,field = "tconst", key = "tconst")
    Ratings ratings;
}