package com.example.ManagementSystem.Repository;

import com.example.ManagementSystem.Entity.Parts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartsRepository extends JpaRepository<Parts,Long> {

        List<Parts> findAllByOrderByIdAsc();

}
