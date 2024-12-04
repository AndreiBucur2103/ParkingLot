package com.parking.parkinglot.ejb;

import com.parking.parkinglot.common.CarDto;
import jakarta.ejb.Stateless;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.logging.Logger;

@Stateless
public class CarsBean {
    private static final Logger LOG = Logger.getLogger(CarsBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

}
