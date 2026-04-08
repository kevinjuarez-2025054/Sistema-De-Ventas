package com.kevinjuarez.Sistema_Venta.Service;

import com.kevinjuarez.Sistema_Venta.Entity.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> getAllCliente();
    Cliente getByIdCliente(Integer id);
    Cliente saveCliente(Cliente cliente) throws RuntimeException;
    Cliente updateCliente(Integer id, Cliente cliente);
    void deleteCliente(Integer id);
}
