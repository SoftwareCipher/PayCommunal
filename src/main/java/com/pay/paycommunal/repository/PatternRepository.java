package com.pay.paycommunal.repository;

import com.pay.paycommunal.entities.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatternRepository extends JpaRepository<Pattern, Long> {
    @Query("select p from Pattern p where p.address = ?1")
    List<Pattern> getAddressForPattern(Long address);

    @Query("select p from Pattern p where p.namePattern = ?1")
    List<Pattern> getNameForPattern(String name);
}
