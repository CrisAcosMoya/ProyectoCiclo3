package co.edu.unbosque.ciclo3demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
        public Controlador() {
          super();
        }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
String menu = request.getParameter("menu");
String accion = request.getParameter("accion");
        
 switch (menu) {
     case "Principal":
	  request.getRequestDispatcher("/Principal.jsp").forward(request, response);
	  break;
     case "Usuarios":
	  if (accion.equals("Listar")) {
	     try {
	        ArrayList<Usuarios> lista = UsuariosJSON.getJSON();
		 request.setAttribute("lista", lista);
	     } catch (Exception e) {
		 e.printStackTrace();
	     }
	  }else if(accion.equals("Agregar")) {
	     Usuarios usuario = new Usuarios();
	     usuario.setCedula_usuario(Long.parseLong(request.getParameter("txtcedula")));
	     usuario.setNombre_usuario(request.getParameter("txtnombre"));
	     usuario.setEmail_usuario(request.getParameter("txtemail"));
	     usuario.setUsuario(request.getParameter("txtusuario"));
	     usuario.setPassword(request.getParameter("txtpassword"));
					
            int respuesta=0;
	      try {
		   respuesta = UsuariosJSON.postJSON(usuario);
		   PrintWriter write = response.getWriter();
		if (respuesta==200) {
	request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);
		   } else {
			   write.println("Error: " +  respuesta);
			}
			   write.close();
			} catch (Exception e) {
			   e.printStackTrace();
			}
		}else if(accion.equals("Actualizar")) {
		     Usuarios usuario = new Usuarios();
	            usuario.setCedula_usuario(Long.parseLong(request.getParameter("txtcedula")));
		      usuario.setNombre_usuario(request.getParameter("txtnombre"));
		      usuario.setEmail_usuario(request.getParameter("txtemail"));
			usuario.setUsuario(request.getParameter("txtusuario"));
			usuario.setPassword(request.getParameter("txtpassword"));
			
	             int respuesta=0;
			try {
			   respuesta = UsuariosJSON.putJSON(usuario,usuario.getCedula_usuario());
			   PrintWriter write = response.getWriter();
							
			   if (respuesta==200) {
		request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);
	        	   } else {
				write.println("Error: " +  respuesta);
			   }
				write.close();
			   } catch (Exception e) {
				e.printStackTrace();
			   }
		}else if(accion.equals("Cargar")) {
			Long id= Long.parseLong(request.getParameter("id"));
			try {
	                ArrayList<Usuarios> lista1 = UsuariosJSON.getJSON();
			   System.out.println("Parametro: " + id);						
			   for (Usuarios usuarios:lista1){
				if (usuarios.getCedula_usuario()==id) {
				   request.setAttribute("usuarioSeleccionado", usuarios);
		request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);	
				}
			   }
			 } catch (Exception e) {
		       	e.printStackTrace();
			 }
		}else if(accion.equals("Eliminar")) {
	        	Long id= Long.parseLong(request.getParameter("id"));			
			int respuesta=0;
			try {
			   respuesta = UsuariosJSON.deleteJSON(id);
			   PrintWriter write = response.getWriter();
			   if (respuesta==200) {
		request.getRequestDispatcher("Controlador?menu=Usuarios&accion=Listar").forward(request, response);
			   } else {
				write.println("Error: " +  respuesta);
			   }
			      write.close();
			   } catch (Exception e) {
				e.printStackTrace();
			   }	
		}
		request.getRequestDispatcher("/Usuarios.jsp").forward(request, response);
        break;
case "Clientes":
	if (accion.equals("Listar")) {
	     try {
	        ArrayList<Clientes> lista = ClientesJSON.getJSON();
		 request.setAttribute("lista", lista);
	     } catch (Exception e) {
		 e.printStackTrace();
	     }
	  }else if(accion.equals("Agregar")) {
	     Clientes clientes = new Clientes();
	     clientes.setCedula_cliente(Long.parseLong(request.getParameter("txtcedula")));
	     clientes.setDireccion_cliente(request.getParameter("txtdireccion"));
	     clientes.setEmail_cliente(request.getParameter("txtemail"));
	     clientes.setNombre_cliente(request.getParameter("txtnombre"));
	     clientes.setTelefono_cliente(request.getParameter("txttelefono"));
					
           int respuesta=0;
	      try {
		   respuesta = ClientesJSON.postJSON(clientes);
		   PrintWriter write = response.getWriter();
		if (respuesta==200) {
	request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
		   } else {
			   write.println("Error: " +  respuesta);
			}
			   write.close();
			} catch (Exception e) {
			   e.printStackTrace();
			}
		}else if(accion.equals("Actualizar")) {
			Clientes clientes = new Clientes();
		     clientes.setCedula_cliente(Long.parseLong(request.getParameter("txtcedula")));
		     clientes.setDireccion_cliente(request.getParameter("txtdireccion"));
		     clientes.setEmail_cliente(request.getParameter("txtemail"));
		     clientes.setNombre_cliente(request.getParameter("txtnombre"));
		     clientes.setTelefono_cliente(request.getParameter("txttelefono"));
			
	             int respuesta=0;
			try {
			   respuesta = ClientesJSON.putJSON(clientes,clientes.getCedula_cliente());
			   PrintWriter write = response.getWriter();
							
			   if (respuesta==200) {
		request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
	        	   } else {
				write.println("Error: " +  respuesta);
			   }
				write.close();
			   } catch (Exception e) {
				e.printStackTrace();
			   }
		}else if(accion.equals("Cargar")) {
			Long id= Long.parseLong(request.getParameter("id"));
			try {
	                ArrayList<Clientes> lista1 = ClientesJSON.getJSON();
			   System.out.println("Parametro: " + id);						
			   for (Clientes clientes:lista1){
				if (clientes.getCedula_cliente()==id) {
				   request.setAttribute("usuarioSeleccionado", clientes);
		request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);	
				}
			   }
			 } catch (Exception e) {
		       	e.printStackTrace();
			 }
		}else if(accion.equals("Eliminar")) {
	        	Long id= Long.parseLong(request.getParameter("id"));			
			int respuesta=0;
			try {
			   respuesta = ClientesJSON.deleteJSON(id);
			   PrintWriter write = response.getWriter();
			   if (respuesta==200) {
		request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
			   } else {
				write.println("Error: " +  respuesta);
			   }
			      write.close();
			   } catch (Exception e) {
				e.printStackTrace();
			   }	
		}
    request.getRequestDispatcher("/Clientes.jsp").forward(request, response);
  break;
 case "Proveedores":
		if (accion.equals("Listar")) {
		     try {
		        ArrayList<Proveedores> lista = ProveedoresJSON.getJSON();
			 request.setAttribute("lista", lista);
		     } catch (Exception e) {
			 e.printStackTrace();
		     }
		  }else if(accion.equals("Agregar")) {
			  Proveedores proveedores = new Proveedores();
			  proveedores.setNit_proveedor(Long.parseLong(request.getParameter("txtnit")));
			  proveedores.setDireccion_proveedor(request.getParameter("txtdireccion"));
			  proveedores.setCiudad_proveedor(request.getParameter("txtciudad"));
			  proveedores.setNombre_proveedor(request.getParameter("txtnombre"));
			  proveedores.setTelefono_proveedor(request.getParameter("txttelefono"));
						
	           int respuesta=0;
		      try {
			   respuesta = ProveedoresJSON.postJSON(proveedores);
			   PrintWriter write = response.getWriter();
			if (respuesta==200) {
		request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);
			   } else {
				   write.println("Error: " +  respuesta);
				}
				   write.close();
				} catch (Exception e) {
				   e.printStackTrace();
				}
			}else if(accion.equals("Actualizar")) {
				Proveedores proveedores = new Proveedores();
				proveedores.setNit_proveedor(Long.parseLong(request.getParameter("txtnit")));
				proveedores.setDireccion_proveedor(request.getParameter("txtdireccion"));
				proveedores.setCiudad_proveedor(request.getParameter("txtciudad"));
				proveedores.setNombre_proveedor(request.getParameter("txtnombre"));
				proveedores.setTelefono_proveedor(request.getParameter("txttelefono"));
				
		             int respuesta=0;
				try {
				   respuesta = ProveedoresJSON.putJSON(proveedores,proveedores.getNit_proveedor());
				   PrintWriter write = response.getWriter();
								
				   if (respuesta==200) {
			request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);
		        	   } else {
					write.println("Error: " +  respuesta);
				   }
					write.close();
				   } catch (Exception e) {
					e.printStackTrace();
				   }
			}else if(accion.equals("Cargar")) {
				Long id= Long.parseLong(request.getParameter("id"));
				try {
		                ArrayList<Proveedores> lista1 = ProveedoresJSON.getJSON();
				   System.out.println("Parametro: " + id);						
				   for (Proveedores proveedores:lista1){
					if (proveedores.getNit_proveedor()==id) {
					   request.setAttribute("usuarioSeleccionado", proveedores);
			request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);	
					}
				   }
				 } catch (Exception e) {
			       	e.printStackTrace();
				 }
			}else if(accion.equals("Eliminar")) {
		        	Long id= Long.parseLong(request.getParameter("id"));			
				int respuesta=0;
				try {
				   respuesta = ProveedoresJSON.deleteJSON(id);
				   PrintWriter write = response.getWriter();
				   if (respuesta==200) {
			request.getRequestDispatcher("Controlador?menu=Proveedores&accion=Listar").forward(request, response);
				   } else {
					write.println("Error: " +  respuesta);
				   }
				      write.close();
				   } catch (Exception e) {
					e.printStackTrace();
				   }	
			}
   request.getRequestDispatcher("/Proveedores.jsp").forward(request, response);
   break;
 case "Productos":
		if (accion.equals("Listar")) {
		     try {
		        ArrayList<Productos> lista = ProductosJSON.getJSON();
			 request.setAttribute("lista", lista);
		     } catch (Exception e) {
			 e.printStackTrace();
		     }
		  }else if(accion.equals("Agregar")) {
			  Productos productos = new Productos();
			  productos.setCodigo_producto(Long.parseLong(request.getParameter("txtcodigo")));
			  productos.setNombre_producto(request.getParameter("txtnombre"));
			  productos.setNit_proveedor(Long.parseLong(request.getParameter("txtnit")));
			  productos.setPrecio_compra(Double.parseDouble(request.getParameter("txtprecio")));
			  productos.setIvacompra(Double.parseDouble(request.getParameter("txtiva")));
			  productos.setPrecio_venta(Double.parseDouble(request.getParameter("txtprecio")));
			  
	           int respuesta=0;
		      try {
			   respuesta = ProductosJSON.postJSON(productos);
			   PrintWriter write = response.getWriter();
			if (respuesta==200) {
		request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);
			   } else {
				   write.println("Error: " +  respuesta);
				}
				   write.close();
				} catch (Exception e) {
				   e.printStackTrace();
				}
			}else if(accion.equals("Actualizar")) {
				Productos productos = new Productos();
				  productos.setCodigo_producto(Long.parseLong(request.getParameter("txtcodigo")));
				  productos.setNombre_producto(request.getParameter("txtnombre"));
				  productos.setNit_proveedor(Long.parseLong(request.getParameter("txtnit")));
				  productos.setPrecio_compra(Double.parseDouble(request.getParameter("txtprecio")));
				  productos.setIvacompra(Double.parseDouble(request.getParameter("txtivacompra")));
				  productos.setPrecio_venta(Double.parseDouble(request.getParameter("txtprecio")));
				
		             int respuesta=0;
				try {
				   respuesta = ProductosJSON.putJSON(productos,productos.getCodigo_producto());
				   PrintWriter write = response.getWriter();
								
				   if (respuesta==200) {
			request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);
		        	   } else {
					write.println("Error: " +  respuesta);
				   }
					write.close();
				   } catch (Exception e) {
					e.printStackTrace();
				   }
			}else if(accion.equals("Cargar")) {
				Long id= Long.parseLong(request.getParameter("id"));
				try {
		                ArrayList<Productos> lista1 = ProductosJSON.getJSON();
				   System.out.println("Parametro: " + id);						
				   for (Productos productos:lista1){
					if (productos.getCodigo_producto()==id) {
					   request.setAttribute("usuarioSeleccionado", productos);
			request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);	
					}
				   }
				 } catch (Exception e) {
			       	e.printStackTrace();
				 }
			}else if(accion.equals("Eliminar")) {
		        	Long id= Long.parseLong(request.getParameter("id"));			
				int respuesta=0;
				try {
				   respuesta = ProductosJSON.deleteJSON(id);
				   PrintWriter write = response.getWriter();
				   if (respuesta==200) {
			request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);
				   } else {
					write.println("Error: " +  respuesta);
				   }
				      write.close();
				   } catch (Exception e) {
					e.printStackTrace();
				   }	
			}
	request.getRequestDispatcher("/Productos.jsp").forward(request, response);
	break;
 case "Ventas":
		if (accion.equals("Listar")) {
		     try {
		        ArrayList<Ventas> lista = VentasJSON.getJSON();
			 request.setAttribute("lista", lista);
		     } catch (Exception e) {
			 e.printStackTrace();
		     }
		  }else if(accion.equals("Agregar")) {
			  Ventas ventas = new Ventas();
			  ventas.setCodigo_venta(Long.parseLong(request.getParameter("txtcodigo")));
			  ventas.setCedula_cliente(Long.parseLong(request.getParameter("txtcedulacliente")));
			  ventas.setCedula_usuario(Long.parseLong(request.getParameter("txtcedulausuario")));
			  ventas.setIva_venta(Double.parseDouble(request.getParameter("txtivaventa")));
			  ventas.setTotal_venta(Double.parseDouble(request.getParameter("txttotal")));
			  ventas.setValor_venta(Double.parseDouble(request.getParameter("txtvalor")));
			  
	           int respuesta=0;
		      try {
			   respuesta = VentasJSON.postJSON(ventas);
			   PrintWriter write = response.getWriter();
			if (respuesta==200) {
		request.getRequestDispatcher("Controlador?menu=Ventas&accion=Listar").forward(request, response);
			   } else {
				   write.println("Error: " +  respuesta);
				}
				   write.close();
				} catch (Exception e) {
				   e.printStackTrace();
				}
			}else if(accion.equals("Actualizar")) {
				Ventas ventas = new Ventas();
				  ventas.setCodigo_venta(Long.parseLong(request.getParameter("txtcodigo")));
				  ventas.setCedula_cliente(Long.parseLong(request.getParameter("txtcedulacliente")));
				  ventas.setCedula_usuario(Long.parseLong(request.getParameter("txtcedulausuario")));
				  ventas.setIva_venta(Double.parseDouble(request.getParameter("txtivaventa")));
				  ventas.setTotal_venta(Double.parseDouble(request.getParameter("txttotal")));
				  ventas.setValor_venta(Double.parseDouble(request.getParameter("txtvalor")));
				
		             int respuesta=0;
				try {
				   respuesta = VentasJSON.putJSON(ventas,ventas.getCodigo_venta());
				   PrintWriter write = response.getWriter();
								
				   if (respuesta==200) {
			request.getRequestDispatcher("Controlador?menu=Ventas&accion=Listar").forward(request, response);
		        	   } else {
					write.println("Error: " +  respuesta);
				   }
					write.close();
				   } catch (Exception e) {
					e.printStackTrace();
				   }
			}else if(accion.equals("Cargar")) {
				Long id= Long.parseLong(request.getParameter("id"));
				try {
		                ArrayList<Ventas> lista1 = VentasJSON.getJSON();
				   System.out.println("Parametro: " + id);						
				   for (Ventas ventas:lista1){
					if (ventas.getCodigo_venta()==id) {
					   request.setAttribute("usuarioSeleccionado", ventas);
			request.getRequestDispatcher("Controlador?menu=Ventas&accion=Listar").forward(request, response);	
					}
				   }
				 } catch (Exception e) {
			       	e.printStackTrace();
				 }
			}else if(accion.equals("Eliminar")) {
		        	Long id= Long.parseLong(request.getParameter("id"));			
				int respuesta=0;
				try {
				   respuesta = VentasJSON.deleteJSON(id);
				   PrintWriter write = response.getWriter();
				   if (respuesta==200) {
			request.getRequestDispatcher("Controlador?menu=Ventas&accion=Listar").forward(request, response);
				   } else {
					write.println("Error: " +  respuesta);
				   }
				      write.close();
				   } catch (Exception e) {
					e.printStackTrace();
				   }	
			}
	request.getRequestDispatcher("/Ventas.jsp").forward(request, response);
	break;
	}
 
	}
}

