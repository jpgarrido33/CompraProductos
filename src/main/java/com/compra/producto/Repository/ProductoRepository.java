package com.compra.producto.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compra.producto.Model.Compra;
import com.compra.producto.Model.Producto;
import com.compra.producto.Model.Usuario;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

	 List<Producto> findByPropietario (Usuario propiertario);
	
	 List<Producto> findByCompra(Compra compra);
	
	 List<Producto> findByCompraIsNull();
	
	 List<Producto> findByNombreContainsIgnoreCaseAndCompraIsNull(String nombre);
	
	 List<Producto>  findByNombreContainsIgnoreCaseAndPropietario(String nombre, Usuario propietario);
	
	
}
