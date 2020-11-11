package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.*;
import com.upgrad.hirewheels.entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class VehicleServiceTest {

    @Mock
    private VehicleDao vehicleDao;
    private FuelTypeDao fuelTypeDao;
    private LocationDao locationDao;
    private VehicleSubcategoryDao vehicleSubcategoryDao;
    private VehicleCategoryDao vehicleCategoryDao;
    private CityDao cityDao;

    @InjectMocks
    private VehicleService vehicleService;

    @BeforeEach
    public void setupMockito() {

        Mockito.when(cityDao.findById(1)).thenReturn(Optional.of(new City(1, "City Name")));

        Mockito.when(vehicleCategoryDao.findById(1)).thenReturn(Optional.of(new VehicleCategory(1, "Car")));

        Mockito.when(vehicleSubcategoryDao.findById(1)).thenReturn(Optional.of(new VehicleSubcategory(1, "Sedan", 500, vehicleCategoryDao.findById(1).get())));

        Mockito.when(locationDao.findById(1)).thenReturn(Optional.of(new Location(1, "Naka", "BVM School", 452015 , cityDao.findById(1).get())));

        Mockito.when(vehicleDao.save(new Vehicle("Model", "Num001" ,vehicleSubcategoryDao.findById(1).get(),
                "Color", locationDao.findById(1).get(), fuelTypeDao.findById(1).get(), 1, "imageUrl")))
                .thenReturn(new Vehicle("Model", "Num001" ,vehicleSubcategoryDao.findById(1).get(), "Color",
                        locationDao.findById(1).get(), fuelTypeDao.findById(1).get(), 1, "imageUrl"));

        Mockito.when(vehicleDao.findAll()).thenReturn((List<Vehicle>)new Vehicle("Model", "Num001" ,vehicleSubcategoryDao.findById(1).get(),
                "Color", locationDao.findById(1).get(), fuelTypeDao.findById(1).get(), 1, "imageUrl"));

        Mockito.when(vehicleDao.findByAvailabilityStatus(1)).thenReturn(Optional.of(new Vehicle("Model", "Num001", vehicleSubcategoryDao.findById(1).get(),
                "Color", locationDao.findById(1).get(), fuelTypeDao.findById(1).get(), 1, "imageUrl")));

    }

    @Test
    public void testGetAllVehicles() {

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleModel("Model");
        vehicle.setVehicleNumber("Num001");
        vehicle.setVehicleSubcategory(vehicleSubcategoryDao.findById(1).get());
        vehicle.setColor("Color");
        vehicle.setLocation(locationDao.findById(1).get());
        vehicle.setFuelType(fuelTypeDao.findById(1).get());
        vehicle.setAvailabilityStatus(1);
        vehicle.setVehicleImageUrl("imageUrl");
        vehicleDao.save(vehicle);

        vehicleDao.findAll();
        Assertions.assertNotNull(vehicle);
        Assertions.assertTrue(vehicle.getVehicleId() != 0);
        Assertions.assertEquals("Model", vehicle.getVehicleModel());
        Assertions.assertEquals(vehicleSubcategoryDao.findById(1).get(), vehicle.getVehicleSubcategory());
        Assertions.assertEquals("Color", vehicle.getColor());
        Assertions.assertEquals(locationDao.findById(1).get(), vehicle.getLocation());
        Assertions.assertEquals(fuelTypeDao.findById(1).get(), vehicle.getFuelType());
        Assertions.assertEquals(1, vehicle.getAvailabilityStatus());
        Assertions.assertEquals("imageUrl", vehicle.getVehicleImageUrl());

    }

    @Test
    public void testGetAvailableVehicles() {

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleModel("Model");
        vehicle.setVehicleNumber("Num001");
        vehicle.setVehicleSubcategory(vehicleSubcategoryDao.findById(1).get());
        vehicle.setColor("Color");
        vehicle.setLocation(locationDao.findById(1).get());
        vehicle.setFuelType(fuelTypeDao.findById(1).get());
        vehicle.setAvailabilityStatus(1);
        vehicle.setVehicleImageUrl("imageUrl");
        vehicleDao.save(vehicle);

        vehicleDao.findByAvailabilityStatus(1);

        Assertions.assertNotNull(vehicle);
        Assertions.assertTrue(vehicle.getVehicleId() != 0);
        Assertions.assertEquals("Model", vehicle.getVehicleModel());
        Assertions.assertEquals(vehicleSubcategoryDao.findById(1).get(), vehicle.getVehicleSubcategory());
        Assertions.assertEquals("Color", vehicle.getColor());
        Assertions.assertEquals(locationDao.findById(1).get(), vehicle.getLocation());
        Assertions.assertEquals(fuelTypeDao.findById(1).get(), vehicle.getFuelType());
        Assertions.assertEquals(1, vehicle.getAvailabilityStatus());
        Assertions.assertEquals("imageUrl", vehicle.getVehicleImageUrl());

    }
}
