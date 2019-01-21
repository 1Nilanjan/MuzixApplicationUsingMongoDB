package com.stackroute.MuzixApplication.domain;

import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Muzixs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Muzix
{
    @Id
    private int songid;
    private String songname;
    private String comment;

    public Muzix(String songname, String comment) {
        this.songname = songname;
        this.comment = comment;
    }
}
