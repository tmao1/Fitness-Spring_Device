package com.chyld.controllers;

import com.chyld.entities.Device;
import com.chyld.entities.Position;
import com.chyld.entities.User;
import com.chyld.security.JwtToken;
import com.chyld.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/positions")
public class PositionController {

    private PositionService positionService;

    @Autowired
    public void setPositionService(PositionService positionService) {
        this.positionService = positionService;
    }

    @RequestMapping(path = "/{sn}", method = RequestMethod.POST)
    public void addPosition(@PathVariable String sn, @RequestBody Position position) {

        positionService.savePosition(position, sn);

    }
}
