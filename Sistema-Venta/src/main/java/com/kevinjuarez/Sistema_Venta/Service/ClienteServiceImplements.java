package com.kevinjuarez.Sistema_Venta.Service;

import com.kevinjuarez.Sistema_Venta.Entity.Cliente;
import com.kevinjuarez.Sistema_Venta.Repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImplements implements ClienteService{
    private final ClienteRepository clienteRepository;

    public ClienteServiceImplements(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> getAllCliente() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getByIdCliente(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente saveCliente(Cliente cliente) throws RuntimeException {
        Cliente c = new Cliente();
        c.setDpiCliente(cliente.getDpiCliente());
        c.setNombreCliente(cliente.getNombreCliente());
        c.setApellidoCliente(cliente.getApellidoCliente());
        c.setDireccionCliente(cliente.getDireccionCliente());
        c.setEstadoCliente(1);
        return clienteRepository.save(c);
    }

    @Override
    public Cliente updateCliente(Integer id, Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteCliente(Integer id) {
        clienteRepository.deleteById(id);
    }
}
