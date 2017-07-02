package com.boot.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Shipwreck;
import com.boot.repository.ShipwrackRepository;

@RestController
@RequestMapping("api/v1/")
public class HomeController {

    @Autowired
    ShipwrackRepository repository;
    
    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "This is Spring boot application.";
    }
    
    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
    public Shipwreck get(@PathVariable long id) {
        return repository.findOne(id);
    }
    
    @RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
    public List<Shipwreck> get() {
        return repository.findAll();
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
    public Shipwreck Shipwreck(@PathVariable long id) {
        Shipwreck existingOne = repository.findOne(id);
        repository.delete(id);
        return existingOne;
    }

    @RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
    public Shipwreck post(@RequestBody Shipwreck shipwreck) {
        return repository.save(shipwreck);
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
    public Shipwreck update(@RequestBody Shipwreck shipwreck, @PathVariable long id) {
        Shipwreck existingOne = repository.findOne(id);
        BeanUtils.copyProperties(shipwreck, existingOne);
        return repository.saveAndFlush(existingOne);
    }
}
