package com.compra.producto.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compra.producto.Model.Compra;
import com.compra.producto.Model.Usuario;


@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

	List<Compra> findByPropietario(Usuario propietario);
}
