package com.guillemet.ecommerce.dao;

import com.guillemet.ecommerce.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource
public interface StateRepository extends JpaRepository<State, Integer> {

    List<State> findByCountryCode(@Param("code") String code);

    // the same method as the previous but with a @Query annotation (by using a manually defined query)
    @Query("select s from State s join Country c on s.country.id = c.id where c.code = :code")
    List<State> findByCountryCodeByQuery(@Param("code") String code);

}
