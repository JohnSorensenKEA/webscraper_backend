package com.example.webscraper.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Request {

    @Id
    private Long id;

    private LocalDateTime timestamp;

    private String link;

    private String parameter;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "request")
    private List<Data> data;
}
