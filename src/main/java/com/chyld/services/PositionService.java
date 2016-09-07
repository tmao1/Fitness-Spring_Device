package com.chyld.services;

import com.chyld.entities.Position;
import com.chyld.entities.Run;
import com.chyld.repositories.IPositionRepository;
import com.chyld.repositories.IRunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {

    private IPositionRepository repository;
    private IRunRepository runRepository;

    @Autowired
    public void setRunRepository(IRunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @Autowired
    public void setRepository(IPositionRepository repository) {
        this.repository = repository;
    }

    public void savePosition(Position position, String serialnumber){

        List<Run> activeRuns =  this.runRepository.findActiveRunsByDeviceSerialNumber(serialnumber);

        if( activeRuns != null &&
                activeRuns.size()==1) {
            Run thisRun = activeRuns.get(0);
            position.setRun(thisRun);
            this.repository.save(position);
        }
    }
}
