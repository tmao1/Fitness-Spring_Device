package com.chyld.services;


import com.chyld.entities.Device;
import com.chyld.entities.Run;
import com.chyld.repositories.IDeviceRepository;
import com.chyld.repositories.IRunRepository;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class RunService {

    private IRunRepository repository;

    private IDeviceRepository deviceRepository;

    @Autowired
    public void setDeviceRepository(IDeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Autowired
    public void setRepository(IRunRepository repository) {
        this.repository = repository;
    }

    public void StartRun(String serialnumber) {

        Device thisDevice = this.deviceRepository.findDeviceBySerialNumber(serialnumber);

        if (thisDevice != null) {

            List<Run> activeRuns = this.findActiveRunsByDeviceSerialNumber(serialnumber);

            if (activeRuns != null &&
                    activeRuns.size() == 0) {
                Run thisRun = new Run();
                thisRun.setDevice(thisDevice);
                thisRun.setStarttime(new Date());

                this.repository.save(thisRun);
            }
        }

    }

    public void StopRun(String serialnumber) {
         List<Run> activeRuns = this.findActiveRunsByDeviceSerialNumber(serialnumber);

         if (activeRuns != null &&
                    activeRuns.size() == 1) {

                Run thisRun = activeRuns.get(0);
                thisRun.setEndtime(new Date());

                this.repository.save(thisRun);
        }

    }

    public List<Run> findActiveRunsByDeviceSerialNumber(String serialnumber)
    {
        return this.repository.findActiveRunsByDeviceSerialNumber(serialnumber);
    }

}
