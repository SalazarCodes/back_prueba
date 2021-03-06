package com.lsalazar.prueba.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lsalazar.prueba.entity.DetalleProducto;

public interface DetalleProductoRepository extends JpaRepository<DetalleProducto, Integer>{

	@Query(value = "{call getProductoDetalle()}", nativeQuery = true)
	List<DetalleProducto> getProductos();
	
	@Query(value = "{call getProductoDetalleById(:id_)}", nativeQuery = true)
	Optional<DetalleProducto> getProductosById(@Param("id_") int id);
	
	@Transactional
	@Modifying
	@Query(value = "{call insertProductoDetalle(:sku_, :descripcion_, :precio_)}", nativeQuery = true)
	void insertarProductoDetalle(
			@Param("sku_") String sku_,
			@Param("descripcion_") String descripcion_,
			@Param("precio_") Double precio_
			);
	
	@Transactional
	@Modifying
	@Query(value = "{call deleteProductoDetalle(:id_)}", nativeQuery = true)
	void deleteDetalle(@Param("id_") int id);
	
	
}
