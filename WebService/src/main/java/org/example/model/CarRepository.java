package org.example.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    /*
        extends JpaRepository<Car, Integer> int - bo id, klucz główny
        Car findByLicensePlate (findBy - stały człon, to co znajduje się po - nazwa kolumny)
     */
    Car findByLicensePlate(String licensePlate);
}
