package com.ada.aerolineaf.aerolineaV1.repository;

import com.ada.aerolineaf.aerolineaV1.model.Flight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface FlightRepository extends CrudRepository<Flight, Integer>  {

    @Query("from Flight where origin_city like %:city% or destination_city like %:city% or name like %:city%")
    Iterable<Flight> getFlightsByOriginOrDestinationLike(@Param("city") String city);

    @Query("from Flight where year(departure_date) = :year and month(departure_date) = :month and origin_city like %:city%")
    Iterable<Flight> getFlightsByDate(@Param("year") int year, @Param("month") int month, @Param("city") String city);
}
