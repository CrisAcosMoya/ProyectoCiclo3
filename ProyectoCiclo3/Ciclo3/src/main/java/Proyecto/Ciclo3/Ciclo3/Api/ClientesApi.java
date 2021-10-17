package Proyecto.Ciclo3.Ciclo3.Api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Proyecto.Ciclo3.Ciclo3.Dao.ClientesDAO;
import Proyecto.Ciclo3.Ciclo3.Model.Clientes;
@RestController 
@RequestMapping("clientes")
public class ClientesApi {
	
	@Autowired 
	private ClientesDAO clientesDAO;
	
			@PostMapping("/guardar")
			public void guardar(@RequestBody Clientes clientes) {
				clientesDAO.save(clientes);
			}
			@GetMapping("/listar")
			public List<Clientes> listar(){
			return clientesDAO.findAll();
			}
			@DeleteMapping("/eliminar/{id}")
			public void eliminar(@PathVariable("id") Integer id) {
				clientesDAO.deleteById(id);
			}
			@PutMapping("/actualizar")
			public void actualizar(@RequestBody Clientes clientes) {
				clientesDAO.save(clientes);
			}
}