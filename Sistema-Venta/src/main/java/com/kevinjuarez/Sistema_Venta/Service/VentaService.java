package com.kevinjuarez.Sistema_Venta.Service;

import com.kevinjuarez.Sistema_Venta.Entity.Venta;

import java.util.List;

public interface VentaService {
    List<Venta> getAll();
    Venta getByIdVenta(Integer id);
    Venta saveVenta(Venta venta) throws RuntimeException;
    Venta updateVenta(Integer id,Venta venta);
    void deleteVenta(Integer id);
}
