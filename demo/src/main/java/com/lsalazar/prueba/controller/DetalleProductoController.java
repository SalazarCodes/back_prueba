package com.lsalazar.prueba.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lsalazar.prueba.entity.DetalleProducto;
import com.lsalazar.prueba.service.DetalleProductoService;

@RestController
@RequestMapping("/producto")
public class DetalleProductoController {
	
	@Autowired
	DetalleProductoService detalleProductoService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/listaProductos")
	public ResponseEntity<List<DetalleProducto>>listarDetalle(){
		List<DetalleProducto> listaDetalleProducto = detalleProductoService.listarProductos();
		return new ResponseEntity(listaDetalleProducto, HttpStatus.OK);
	}
		
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/detalleProducto/{id}")
	public ResponseEntity<DetalleProducto> detalleProducto(@PathVariable("id") int id){
		Optional<DetalleProducto> detalleProducto = detalleProductoService.getProductosById(id);
		return new ResponseEntity(detalleProducto, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/nuevo")
	public ResponseEntity<?> insertarProducto(@RequestBody DetalleProducto detalleProducto){
		detalleProductoService.insertarDetalle(detalleProducto);
		return new ResponseEntity(detalleProducto, HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/borrarProducto/{id}")
	public ResponseEntity<?> deleteProducto(@PathVariable("id") int id){
		detalleProductoService.deleteProducto(id);
		return new ResponseEntity(HttpStatus.OK);
	}

}
