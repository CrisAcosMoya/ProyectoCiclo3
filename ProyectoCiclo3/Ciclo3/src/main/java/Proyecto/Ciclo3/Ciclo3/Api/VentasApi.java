package Proyecto.Ciclo3.Ciclo3.Api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Proyecto.Ciclo3.Ciclo3.Dao.VentasDAO;
import Proyecto.Ciclo3.Ciclo3.Model.Ventas;
@RestController 
@RequestMapping("ventas")
public class VentasApi {
	
	@Autowired 
	private VentasDAO ventasDAO;
	
			@GetMapping("/listar")
			public List<Ventas> listar(){
			return ventasDAO.findAll();
			}
			
}

