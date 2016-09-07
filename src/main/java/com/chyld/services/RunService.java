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

    public void StartRun(int deviceId) {

        Device thisDevice = this.deviceRepository.findOne(deviceId);

        if (thisDevice != null) {

            List<Run> activeRuns = this.findActiveRunsByDeviceId(deviceId);

            if (activeRuns != null &&
                    activeRuns.size() == 0) {
                Run thisRun = new Run();
                thisRun.setDevice(thisDevice);
                thisRun.setStarttime(new Date());

                this.repository.save(thisRun);
            }
        }

    }

    public void StopRun(int deviceId) {
         List<Run> activeRuns = this.findActiveRunsByDeviceId(deviceId);

         if (activeRuns != null &&
                    activeRuns.size() == 1) {

                Run thisRun = activeRuns.get(0);
                thisRun.setEndtime(new Date());

                this.repository.save(thisRun);
        }

    }

    public List<Run> findActiveRunsByDeviceId(int deviceId)
    {
        return this.repository.findActiveRunsByDeviceId(deviceId);
    }

}
