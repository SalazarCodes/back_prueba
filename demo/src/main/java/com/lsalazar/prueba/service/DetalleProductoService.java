package com.lsalazar.prueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lsalazar.prueba.entity.DetalleProducto;
import com.lsalazar.prueba.repository.DetalleProductoRepository;

@Service
public class DetalleProductoService {
	
	@Autowired
	DetalleProductoRepository detalleProductoRepository;
	
	public List<DetalleProducto> listarProductos(){
		return detalleProductoRepository.getProductos();
	}
	
	public Optional<DetalleProducto> getProductosById(int id){
		return detalleProductoRepository.getProductosById(id);
	}
	
	public void insertarDetalle(DetalleProducto detalleProducto) {
		detalleProductoRepository.insertarProductoDetalle(detalleProducto.getSku(), detalleProducto.getDescripcion(), detalleProducto.getPrecio());
	}
	
	public void deleteProducto(int id) {
		detalleProductoRepository.deleteDetalle(id);
	}
}
