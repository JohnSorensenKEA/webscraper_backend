package com.example.webscraper.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime timestamp;

    private String link;

    private String parameter;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "request")
    private Collection<Data> data;

    public Request() {
    }

    public Request(String link, String parameter) {
        this.link = link;
        this.parameter = parameter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public Collection<Data> getData() {
        return data;
    }

    public void setData(Collection<Data> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", link='" + link + '\'' +
                ", parameter='" + parameter + '\'' +
                ", data=" + data +
                '}';
    }
}
