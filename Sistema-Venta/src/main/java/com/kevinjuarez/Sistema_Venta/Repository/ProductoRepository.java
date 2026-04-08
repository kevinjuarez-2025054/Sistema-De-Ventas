package com.kevinjuarez.Sistema_Venta.Repository;

import com.kevinjuarez.Sistema_Venta.Entity.Producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {
}
