package com.example.lab6.Repository;

import com.example.lab6.Entity.Prestamos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestamosRepository extends JpaRepository<Prestamos, Integer> {
}
