package Proyecto.Ciclo3.Ciclo3.Api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Proyecto.Ciclo3.Ciclo3.Dao.ProductosDAO;
import Proyecto.Ciclo3.Ciclo3.Model.Productos;
@RestController 
@RequestMapping("productos")
public class ProductosApi {
	
	@Autowired 
	private ProductosDAO productosDAO;
	
			@GetMapping("/listar")
			public List<Productos> listar(){
			return productosDAO.findAll();
			}
			@PutMapping("/actualizar")
			public void actualizar(@RequestBody Productos productos) {
				productosDAO.save(productos);
			}
}
