package com.example.webscraper.repositories;

import com.example.webscraper.models.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<Data, Long> {
}
