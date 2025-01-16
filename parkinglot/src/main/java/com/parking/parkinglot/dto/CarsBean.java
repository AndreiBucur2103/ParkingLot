package com.parking.parkinglot.dto;

import com.parking.parkinglot.entities.Car;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;




@Stateless
public class CarsBean {
    private static final Logger LOG = Logger.getLogger(CarsBean.class.getName());

    EntityManager entityManager;

    public List<CarDto> findAllCars() {
        String msg;
        LOG.info( "findAllCars");
        try {
            TypedQuery<Car> typedQuery = entityManager.createQuery( "SELECT c FROM Car c", Car.class);
            List<Car> cars = typedQuery.getResultList();
            return copyCarsToDto (cars);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    private List<CarDto> copyCarsToDto(List<Car> cars) {
        List<CarDto> dtos = new ArrayList<CarDto>();
        for (Car car : cars) {
            CarDto cd = new CarDto(car.getId(),car.getLicensePlate(),car.getParkingSpot(),car.getOwner().getUsername());
            dtos.add(cd);

        }
        return dtos;
    }
}

