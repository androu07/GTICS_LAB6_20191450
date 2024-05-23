package com.example.lab6.Repository;

import com.example.lab6.Entity.Dispositivos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DispositivosRepository extends CrudRepository<Dispositivos, Integer> {
}
