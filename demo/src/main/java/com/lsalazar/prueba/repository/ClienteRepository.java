package com.lsalazar.prueba.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lsalazar.prueba.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	@Query(value = "{call getClientes()}", nativeQuery = true)
	List<Cliente> getClientes();
	
	@Query(value = "{call getClienteById(:id_)}", nativeQuery = true)
	Optional<Cliente> getClienteById(@Param("id_") int id);
	
	@Transactional
	@Modifying
	@Query(value = "{call insertCliente(:nombre_, :apellidos_, :ruc_, :dni_, :direccion_, :telefono_, :distrito_)}", nativeQuery = true)
	void insertarCliente(
			@Param("nombre_") String nombre_,
			@Param("apellidos_") String apellidos_,
			@Param("ruc_") String ruc_,
			@Param("dni_") String dni_,
			@Param("direccion_") String direccion_,
			@Param("telefono_") String telefono_,
			@Param("distrito_") String distrito_
			);
	
	@Transactional
	@Modifying
	@Query(value = "{call insertCliente(:id_, :nombre_, :apellidos_, :ruc_, :dni_, :direccion_, :telefono_, :distrito_)}", nativeQuery = true)
	void updateCliente(
			@Param("nombre_") String nombre_,
			@Param("apellidos_") String apellidos_,
			@Param("ruc_") String ruc_,
			@Param("dni_") String dni_,
			@Param("direccion_") String direccion_,
			@Param("telefono_") String telefono_,
			@Param("distrito_") String distrito_
			);
	
	@Transactional
	@Modifying
	@Query(value = "{call deleteCliente(:id_)}", nativeQuery = true)
	void deleteCliente(@Param("id_") int id);
	
	@Transactional
	@Modifying
	@Query(value = "{call deleteLogicCliente(:id_)}", nativeQuery = true)
	void deleteLogicCliente(@Param("id_") int id);
	
	@Transactional
	@Modifying
	Cliente save(Cliente c);

}
