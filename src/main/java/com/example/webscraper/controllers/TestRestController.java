package com.example.webscraper.controllers;

import com.example.webscraper.models.Request;
import com.example.webscraper.repositories.DataRepository;
import com.example.webscraper.repositories.RequestRepository;
import com.example.webscraper.services.JsoupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
public class TestRestController {

    @Autowired
    RequestRepository requestRepository;

    @Autowired
    DataRepository dataRepository;

    @Autowired
    JsoupService jsoupService;

    @GetMapping("/request/all")
    public List<Request> getAllRequests(){
        return requestRepository.findAll();
    }

    @GetMapping("/request/{id}")
    public Request getRequestById(@PathVariable Long id){
        return requestRepository.getOne(id);
    }

    @PostMapping(value = "/request/new", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Request newRequest(@RequestBody Request request){
        return jsoupService.getData(request);
    }

    @DeleteMapping(value = "/request/delete", consumes = "application/json")
    public ResponseEntity<Long> deleteRequest(@RequestBody Request request){
        Long id = request.getId();
        dataRepository.deleteByRequest(requestRepository.getOne(id));
        requestRepository.delete(requestRepository.getOne(id));

        if (!requestRepository.existsById(id)){
            return new ResponseEntity<>(id, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(0L, HttpStatus.NO_CONTENT);
        }
    }

}
