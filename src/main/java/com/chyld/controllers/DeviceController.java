package com.chyld.controllers;


import com.chyld.entities.Device;
import com.chyld.entities.Profile;
import com.chyld.entities.User;
import com.chyld.security.JwtToken;
import com.chyld.services.DeviceService;
import com.chyld.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceController {

    private DeviceService deviceService;
    private UserService userService;

    @Autowired
    public void setDeviceService(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public ResponseEntity<?> addDevice(@RequestBody Device device, Principal user) {

        int uid = ((JwtToken)user).getUserId();
        User u = userService.findUserById(uid);

        device.setUser(u);

        deviceService.saveDevice(device);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);

    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Page<Device> getDevicesForUser(@RequestParam(name = "page", required = false, defaultValue = "0") int page, Principal user)
    {
        int uid = ((JwtToken)user).getUserId();
        User u = userService.findUserById(uid);

        if( user != null) {
            return deviceService.getAllDevicesForUser(u.getId(),page);
        }

        return null;

    }

}
