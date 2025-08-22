package com.vendorapp.service;

import com.vendorapp.entity.ServiceEntity;
import com.vendorapp.entity.Vendor;
import com.vendorapp.repository.ServiceRepository;
import com.vendorapp.repository.VendorRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceService {
    private final ServiceRepository serviceRepository;
    private final VendorRepository vendorRepository;
    
    @Autowired
    public ServiceService(ServiceRepository serviceRepository, VendorRepository vendorRepository) {
        this.serviceRepository = serviceRepository;
        this.vendorRepository = vendorRepository;
    }

    public ServiceEntity addService(Long vendorId, ServiceEntity service) {
        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));
        service.setVendor(vendor);
        return serviceRepository.save(service);
    }

    public List<ServiceEntity> getServicesByVendor(Long vendorId) {
        return serviceRepository.findByVendorId(vendorId);
    }
}
