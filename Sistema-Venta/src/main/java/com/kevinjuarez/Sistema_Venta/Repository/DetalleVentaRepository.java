package com.kevinjuarez.Sistema_Venta.Repository;

import com.kevinjuarez.Sistema_Venta.Entity.DetalleVentas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVentas,Integer> {
}
