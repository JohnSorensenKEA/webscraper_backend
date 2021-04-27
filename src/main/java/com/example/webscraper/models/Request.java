package com.example.webscraper.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime timestamp;

    private String link;

    private String parameter;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "request")
    private List<Data> data;
}
