package com.ada.aerolineaf.aerolineaV1.repository;

import com.ada.aerolineaf.aerolineaV1.model.Base;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BaseRepository extends CrudRepository<Base, Integer> {

    @Query("from Base where city like %:city%")
    Iterable<Base> getBasesByCityLike(@Param("city")  String city);
}
