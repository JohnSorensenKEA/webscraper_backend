package com.example.webscraper.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @JsonIgnore
    @NotNull
    @JoinColumn(name = "request_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_data_request"))
    @ManyToOne(fetch = FetchType.LAZY)
    private Request request;

    public Data() {
    }

    public Data(String content, Request request) {
        this.content = content;
        this.request = request;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
