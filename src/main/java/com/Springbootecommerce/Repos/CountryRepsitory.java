package com.Springbootecommerce.Repos;

import com.Springbootecommerce.Entity.Country;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("http://localhost:4200")

public interface CountryRepsitory extends JpaRepository<Country,Integer> {


}
