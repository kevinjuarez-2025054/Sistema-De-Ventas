package com.kevinjuarez.Sistema_Venta.Service;

import com.kevinjuarez.Sistema_Venta.Entity.DetalleVentas;

import java.util.List;

public interface DetalleVentaService {
    List<DetalleVentas> getAll();
    DetalleVentas getById(Integer id);
    DetalleVentas saveDetalleVenta(DetalleVentas detalleVentas) throws RuntimeException;
    DetalleVentas updateDetalleVenta(Integer id,DetalleVentas detalleVentas);
    void deleteDetalleVenta(Integer id);
}
