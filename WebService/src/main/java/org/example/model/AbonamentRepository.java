package org.example.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbonamentRepository extends JpaRepository<Abonament, Integer> {
    /*
        baza danych z tabelką i danymi
        aby odczytać dane z bazy danych - budowane jest repozytorium

        repozytorium w springu - interfejs
        dla każdej tabelki osobne repozytorium

        żeby działało - rozszerzenie JpaRepository - daje podstawową funkcjonalnośc
        jak np. znajdowanie, odczytywanie samochodów z tabeli cars
     */
}
