package com.vendorapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "service_id")
    private ServiceEntity service;
    
    private String customerName;
    private String customerEmail;
    private LocalDate bookingDate;
    private BigDecimal totalCost;
    private String status;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}