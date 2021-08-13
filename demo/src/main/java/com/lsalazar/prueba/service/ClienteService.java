package com.lsalazar.prueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lsalazar.prueba.entity.Cliente;
import com.lsalazar.prueba.repository.ClienteRepository;


@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public List<Cliente> listarClientes(){
		return clienteRepository.getClientes();
	}
	
	public Optional<Cliente> getClienteById(int id){
		return clienteRepository.getClienteById(id);
	}
	
	public void insertarCliente(Cliente cliente) {
		clienteRepository.insertarCliente(cliente.getNombre(), cliente.getApellidos(), cliente.getRuc(), 
										  cliente.getDni(), cliente.getDireccion(), cliente.getTelefono(), 
										  cliente.getDistrito());
	}
	
	public void updateCliente(Cliente cliente) {
		clienteRepository.updateCliente(cliente.getNombre(), cliente.getApellidos(), cliente.getRuc(), 
										  cliente.getDni(), cliente.getDireccion(), cliente.getTelefono(), 
										  cliente.getDistrito());
	}
	
	public void deleteCliente(int id) {
		clienteRepository.deleteCliente(id);
	}
	
	public void deleteLogicCliente(int id) {
		clienteRepository.deleteLogicCliente(id);
	}
	
	public Cliente editCliente(Cliente c) {
		return clienteRepository.save(c);
	}

}
