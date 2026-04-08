package com.kevinjuarez.Sistema_Venta.Repository;

import com.kevinjuarez.Sistema_Venta.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}
