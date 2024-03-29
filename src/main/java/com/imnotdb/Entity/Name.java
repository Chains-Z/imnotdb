package com.imnotdb.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

import java.util.Date;

@Table("name")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Name {
    @org.nutz.dao.entity.annotation.Name
    private String nconst;
    @Column("primaryName")
    private String primaryName;
    @Column("birthYear")
    private Date birthYear;
    @Column("deathYear")
    private Date deathYear;
    @Column("primaryProfession")
    private String primaryProfession;
    @Column("knownForTitles")
    private String knownForTitles;
}
