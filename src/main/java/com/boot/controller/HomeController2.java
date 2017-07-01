package com.boot.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Shipwreck;

@RestController
@RequestMapping(value = "/api/v2")
public class HomeController2 {

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
    public Shipwreck getAll(@PathVariable Long id) {
        return ShipwreckStub.get(id);
    }
    
    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
    public Shipwreck delete(@PathVariable Long id) {
        return ShipwreckStub.delete(id);
    }
    
    @RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
    public Shipwreck create(@RequestBody Shipwreck shipwreck) {
        return ShipwreckStub.create(shipwreck);
    }
    
    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
    public Shipwreck update(@RequestParam Long id, @RequestBody Shipwreck shipwreck) {
        return ShipwreckStub.update(id, shipwreck);
    }
}
