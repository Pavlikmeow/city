package com.test.city.repository;

import com.test.city.data.entity.Sight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SightRepository extends JpaRepository<Sight, UUID> {

}
