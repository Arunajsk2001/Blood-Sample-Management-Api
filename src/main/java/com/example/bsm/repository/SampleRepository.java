package com.example.bsm.repository;

import com.example.bsm.entity.Sample;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepository extends JpaRepository<Sample,Integer> {

}
