package com.vendorapp.controller;

import com.vendorapp.entity.ServiceEntity;
import com.vendorapp.service.ServiceService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/services")
@RequiredArgsConstructor
public class ServiceController {
    private final ServiceService serviceService;
    
    @Autowired
    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @PostMapping("/{vendorId}")
    public ResponseEntity<ServiceEntity> addService(@PathVariable Long vendorId, @RequestBody ServiceEntity service) {
        return ResponseEntity.ok(serviceService.addService(vendorId, service));
    }

    @GetMapping("/vendor/{vendorId}")
    public ResponseEntity<List<ServiceEntity>> getServices(@PathVariable Long vendorId) {
        return ResponseEntity.ok(serviceService.getServicesByVendor(vendorId));
    }
}
