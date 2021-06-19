package com.imnotdb.imnotdb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

@Table("ratings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
    @Name
    private String tconst;
    @Column("averageRating")
    private Double averageRating;
    @Column("numVotes")
    private Integer numVotes;
}

