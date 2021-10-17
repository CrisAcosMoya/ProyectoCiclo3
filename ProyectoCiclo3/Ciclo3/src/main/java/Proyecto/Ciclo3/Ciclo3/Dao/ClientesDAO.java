package Proyecto.Ciclo3.Ciclo3.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import Proyecto.Ciclo3.Ciclo3.Model.Clientes;

public interface ClientesDAO extends JpaRepository<Clientes, Integer>{}