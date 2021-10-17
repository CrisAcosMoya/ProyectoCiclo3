package Proyecto.Ciclo3.Ciclo3.Api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Proyecto.Ciclo3.Ciclo3.Dao.DetalleVentasDAO;
import Proyecto.Ciclo3.Ciclo3.Model.DetalleVentas;


@RestController 
@RequestMapping("detalle_ventas")
public class DetalleVentasApi {
	
	@Autowired 
	private DetalleVentasDAO detalleventasDAO;

			@PostMapping("/guardar")
			public void guardar(@RequestBody DetalleVentas detalleventas) {
				detalleventasDAO.save(detalleventas);
			}
			@GetMapping("/listar")
			public List<DetalleVentas> listar(){
			return detalleventasDAO.findAll();
			}
			@PutMapping("/actualizar")
			public void actualizar(@RequestBody DetalleVentas detalleventas) {
				detalleventasDAO.save(detalleventas);
			}

			
}
