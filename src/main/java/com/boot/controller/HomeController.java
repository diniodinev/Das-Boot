package com.boot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Shipwreck;

@RestController
@RequestMapping("api/v1/")
public class HomeController {

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
    public Shipwreck get(@PathVariable long id) {
        return ShipwreckStub.get(id);
    }
    
    @RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
    public List<Shipwreck> get() {
        return ShipwreckStub.list();
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
    public Shipwreck delete(@PathVariable long id) {
        return ShipwreckStub.delete(id);
    }

    @RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
    public Shipwreck post(@RequestBody Shipwreck shipwreck) {
        return ShipwreckStub.create(shipwreck);
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
    public Shipwreck update(@RequestBody Shipwreck shipwreck, @PathVariable long id) {
        return ShipwreckStub.update(id, shipwreck);
    }
}
