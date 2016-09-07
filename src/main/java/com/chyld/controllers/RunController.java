package com.chyld.controllers;

import com.chyld.services.RunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/runs")
public class RunController {

    private RunService runService;

    @Autowired
    public void setRunService(RunService runService) {
        this.runService = runService;
    }


    @RequestMapping( path = "/{id}/start", method = RequestMethod.POST)
    public void startRun(@PathVariable int id)
    {
        this.runService.StartRun(id);
    }

    //Start

    //Stop

    @RequestMapping(path = "/{id}/stop", method = RequestMethod.POST)
    public void stopRun(@PathVariable int id){
        this.runService.StopRun(id);
    }
}
