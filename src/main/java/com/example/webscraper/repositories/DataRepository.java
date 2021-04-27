package com.example.webscraper.repositories;

import com.example.webscraper.models.Data;
import com.example.webscraper.models.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface DataRepository extends JpaRepository<Data, Long> {

    @Transactional
    void deleteByRequest(Request request);
}
