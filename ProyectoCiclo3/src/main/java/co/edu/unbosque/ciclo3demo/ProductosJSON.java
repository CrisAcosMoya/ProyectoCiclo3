package co.edu.unbosque.ciclo3demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;

public class ProductosJSON {
	
	private static URL url;
	private static String sitio = "http://localhost:5000/";
	
	public static ArrayList<Productos> getJSON() throws IOException, ParseException{
		
		url = new URL(sitio +"productos/listar");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";
		
		for (int i = 0; i<inp.length ; i++) {
		   json += (char)inp[i];
		}
		
		ArrayList<Productos> lista = new ArrayList<Productos>();
		lista = parsingProductos(json);
		http.disconnect();
		return lista;
	}
	
	public static ArrayList<Productos> parsingProductos(String json) throws ParseException {
		JSONParser jsonParser = new JSONParser(json);
		ArrayList<Productos> lista = new ArrayList<Productos>();
		JSONArray productos = (JSONArray) jsonParser.parse(json);
		Iterator i = productos.iterator();
		while (i.hasNext()) {
		JSONObject innerObj = (JSONObject) i.next();
		Productos producto = new Productos();
		producto.setCodigo_producto(Long.parseLong(innerObj.get("codigo_producto").toString()));
		producto.setNombre_producto(innerObj.get("nombre_producto").toString());
		producto.setNit_proveedor(Long.parseLong(innerObj.get("nit_proveedor").toString()));
		producto.setPrecio_compra(Double.parseDouble(innerObj.get("precio_compra").toString()));
		producto.setIvacompra(Double.parseDouble(innerObj.get("ivacompra").toString()));
		producto.setPrecio_venta(Double.parseDouble(innerObj.get("precio_venta").toString()));
			lista.add(producto);
		}
		return lista;
	}
	
    public static int postJSON(Productos producto) throws IOException {
		
		
		url = new URL(sitio+"productos/guardar");
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		
		try {
		  http.setRequestMethod("POST");
		} catch (ProtocolException e) {
		  e.printStackTrace();
		}
		
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");
		
		String data = "{"
				+ "\"codigo_producto\":\""+ String.valueOf(producto.getCodigo_producto())
				+"\",\"nombre_producto\": \""+producto.getNombre_producto()
				+"\",\"nit_proveedor\": \""+producto.getNit_proveedor()
				+"\",\"precio_compra\":\""+producto.getPrecio_compra()
				+"\",\"ivacompra\":\""+producto.getIvacompra()
				+"\",\"precio_venta\":\""+producto.getPrecio_venta()
				+ "\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
public static int putJSON(Productos producto, Long id) throws IOException {
		
		
		url = new URL(sitio+"productos/actualizar");
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		
		try {
		  http.setRequestMethod("PUT");
		} catch (ProtocolException e) {
		  e.printStackTrace();
		}
		
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");
		
		String data = "{"
				+ "\"codigo_producto\":\""+ id
				+"\",\"nombre_producto\": \""+producto.getNombre_producto()
				+"\",\"nit_proveedor\": \""+producto.getNit_proveedor()
				+"\",\"precio_compra\":\""+producto.getPrecio_compra()
				+"\",\"ivacompra\":\""+producto.getIvacompra()
				+"\",\"precio_venta\":\""+producto.getPrecio_venta()
				+ "\"}";
				
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}


	public static int deleteJSON(Long id) throws IOException {
	
	
	url = new URL(sitio+"productos/eliminar/" + id);
	HttpURLConnection http;
	http = (HttpURLConnection)url.openConnection();
	
	try {
	  http.setRequestMethod("DELETE");
	} catch (ProtocolException e) {
	  e.printStackTrace();
	}
	
	http.setDoOutput(true);
	http.setRequestProperty("Accept", "application/json");
	http.setRequestProperty("Content-Type", "application/json");
	
	
	int respuesta = http.getResponseCode();
	http.disconnect();
	return respuesta;
}
}