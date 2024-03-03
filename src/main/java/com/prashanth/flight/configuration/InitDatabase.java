package com.prashanth.flight.configuration;

import com.prashanth.flight.model.Flight;
import com.prashanth.flight.repository.FlightRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
@Slf4j
public class InitDatabase {

    private FlightRepository flightRepository;

    @Bean
    CommandLineRunner initDatabases(){
        return args -> {
            Flight flight = new Flight();
            flight1Data(flight);
//            customer2Data(customer);
//            customer3Data(customer);
//            customer4Data(customer);
//            customer5Data(customer);
            log.info("Database Initialized");
        };
    }
    void autofill(){

    }

    public void flight1Data(Flight flight){
        flight.setId("A");
        flight.setAirline("Boeing");
        flight.setOrigin("India");
        flight.setDestination("Dubai");
        flight.setPrice(100000);
        flightRepository.save(flight);
    }
//    public void customer2Data(Customer customer){
//        customer.setCustomerId(2);
//        customer.setName("Ram");
//        customer.setAge(19);
//        customer.setCreditScore(634);
//        customer.setSalary(325000);
//        customer.setExistingCustomer(false);
//        customerRepository.save(customer);
//    }
//    public void customer3Data(Customer customer){
//        customer.setCustomerId(3);
//        customer.setName("Prashanth");
//        customer.setAge(24);
//        customer.setCreditScore(830);
//        customer.setSalary(1500000);
//        customer.setExistingCustomer(true);
//        customerRepository.save(customer);
//    }
//    public void customer4Data(Customer customer){
//        customer.setCustomerId(4);
//        customer.setName("Leo");
//        customer.setAge(38);
//        customer.setCreditScore(710);
//        customer.setSalary(1000000);
//        customer.setExistingCustomer(false);
//        customerRepository.save(customer);
//    }
//    public void customer5Data(Customer customer){
//        customer.setCustomerId(5);
//        customer.setName("Pawan");
//        customer.setAge(34);
//        customer.setCreditScore(816);
//        customer.setSalary(1200000);
//        customer.setExistingCustomer(false);
//        customerRepository.save(customer);
//    }
}
