package com.tutorial.jwtauthentication.controller;

import com.tutorial.jwtauthentication.dto.ServiceRequestDto;
import com.tutorial.jwtauthentication.service.ServiceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    ServiceServices serviceServices;
    @PostMapping("")
    public ResponseEntity<Object> store(@Valid @RequestBody ServiceRequestDto serviceRequestDto)
    {
        return serviceServices.store(serviceRequestDto);
    }

    @GetMapping("")
    public ResponseEntity<Object> getAll(@RequestParam(value = "status", required = true) String status)
    {
        return serviceServices.getAll(status);
    }

    @PutMapping("/{id}/update-status")
    public ResponseEntity<Object> updateStatus(@PathVariable("id") long id, @RequestParam(value = "status") String status)
    {
        return  serviceServices.updateStatus(id, status);
    }
}
