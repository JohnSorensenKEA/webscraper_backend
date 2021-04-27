package com.example.webscraper.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @NotNull
    @JoinColumn(name = "request_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_data_request"))
    @ManyToOne(fetch = FetchType.LAZY)
    private Request request;
}
