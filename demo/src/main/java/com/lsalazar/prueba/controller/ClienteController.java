package com.lsalazar.prueba.controller;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lsalazar.prueba.entity.Cliente;
import com.lsalazar.prueba.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/listaClientes")
	public ResponseEntity<List<Cliente>>listarClientes(){
		List<Cliente> listaClientes = clienteService.listarClientes();
		return new ResponseEntity(listaClientes, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/detalleCliente/{id}")
	public ResponseEntity<Cliente> detalleCliente(@PathVariable("id") int id){
		Optional<Cliente> cliente = clienteService.getClienteById(id);
		return new ResponseEntity(cliente, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/updateCliente/{id}")
	public Cliente editarCliente(@RequestBody Cliente c, @PathVariable("id") int id) {
		c.setId(id);
		return clienteService.editCliente(c);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/nuevo")
	public ResponseEntity<?> insertarCliente(@RequestBody Cliente cliente){
		clienteService.insertarCliente(cliente);
		return new ResponseEntity(cliente, HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/borrarCliente/{id}")
	public ResponseEntity<?> deleteCliente(@PathVariable("id") int id){
		clienteService.deleteCliente(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/borrarLogicCliente/{id}")
	public ResponseEntity<?> deleteLogicCliente(@PathVariable("id") int id){
		clienteService.deleteLogicCliente(id);
		return new ResponseEntity(HttpStatus.OK);
	}
}
