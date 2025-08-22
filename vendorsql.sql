create database vendor_db;
use vendor_db;
CREATE TABLE vendors (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  email VARCHAR(100) UNIQUE,
  password VARCHAR(255),
  profile_image VARCHAR(255),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


CREATE TABLE services (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  vendor_id BIGINT,
  name VARCHAR(100),
  description TEXT,
  price DECIMAL(10,2),
  pricing_tier VARCHAR(50),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (vendor_id) REFERENCES vendors(id)
);


CREATE TABLE bookings (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  service_id BIGINT,
  customer_name VARCHAR(100),
  customer_email VARCHAR(100),
  booking_date DATE,
  total_cost DECIMAL(10,2),
  status VARCHAR(50),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (service_id) REFERENCES services(id)
);


CREATE TABLE availability (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  vendor_id BIGINT,
  date DATE,
  is_available BOOLEAN,
  FOREIGN KEY (vendor_id) REFERENCES vendors(id)
);


CREATE TABLE reviews (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  vendor_id BIGINT,
  rating INT,
  comment TEXT,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (vendor_id) REFERENCES vendors(id)
);