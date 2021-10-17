package Proyecto.Ciclo3.Ciclo3.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import Proyecto.Ciclo3.Ciclo3.Model.Productos;

public interface ProductosDAO extends JpaRepository<Productos, Integer>{}