package com.compra.producto;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.compra.producto.Model.Producto;
import com.compra.producto.Model.Usuario;
import com.compra.producto.Services.ProductoServicio;
import com.compra.producto.Services.UsuarioServicio;
import com.compra.producto.Upload.StorageService;

@SpringBootApplication
public class CompraProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompraProductosApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(UsuarioServicio usuarioServicio, ProductoServicio productoServicio) {
		return args -> {

			Usuario usuario = new Usuario("Antonio Jesus", "López Garcia", null, "ajlg.lopez@gmail.com", "Antonio");
			usuario = usuarioServicio.registrar(usuario);

			Usuario usuario2 = new Usuario("Miguel", "García Perez", null, "miguel.garcia@gmail.com", "Miguel");
			usuario2 = usuarioServicio.registrar(usuario2);

			
			List<Producto> listado = Arrays.asList(new Producto("Bicicleta de montaña", 100.0f,"https://media.alltricks.com/hd/5c2f265f9cc40.jpg", usuario),
					new Producto("Golf GTI Serie 2", 2500.0f,
							"https://www.minicar.es/large/Volkswagen-Golf-GTi-G60-Serie-II-%281990%29-Norev-1%3A18-i22889.jpg",
							usuario),
					new Producto("Raqueta de tenis", 10.5f, "https://imgredirect.milanuncios.com/fg/2311/04/tenis/Raqueta-tenis-de-segunda-mano-en-Madrid-231104755_1.jpg?VersionId=T9dPhTf.3ZWiAFjnB7CvGKsvbdfPLHht", usuario),
					new Producto("Xbox One X", 425.0f, "https://images.vibbo.com/635x476/860/86038583196.jpg", usuario2),
					new Producto("Trípode flexible", 10.0f, "https://images.vibbo.com/635x476/860/86074256163.jpg", usuario2),
					new Producto("Iphone 7 128 GB", 350.0f, "https://store.storeimages.cdn-apple.com/4667/as-images.apple.com/is/image/AppleInc/aos/published/images/i/ph/iphone7/rosegold/iphone7-rosegold-select-2016?wid=470&hei=556&fmt=jpeg&qlt=95&op_usm=0.5,0.5&.v=1472430205982", usuario2));
			
			listado.forEach(productoServicio::insertar);
			

		};
	}
	
	/**
	 * Este bean se inicia al lanzar la aplicación. Nos permite inicializar el almacenamiento
	 * secundario del proyecto
	 * 
	 * @param storageService Almacenamiento secundario del proyecto
	 * @return
	 */
	@Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}