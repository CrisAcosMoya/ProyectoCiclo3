package Proyecto.Ciclo3.Ciclo3.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class DetalleVentas {
	@Id
	private long codigo_detalle_ventas;
	private long cantidad_producto;
	private long codigo_producto;
	private long codigo_venta;
	private double valor_total;
	private double valor_venta;
	private double valoriva;
	
	public long getCodigo_detalle_ventas() {
		return codigo_detalle_ventas;
	}
	public void setCodigo_detalle_ventas(long codigo_detalle_ventas) {
		this.codigo_detalle_ventas = codigo_detalle_ventas;
	}
	public long getCantidad_producto() {
		return cantidad_producto;
	}
	public void setCantidad_producto(long cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}
	public long getCodigo_producto() {
		return codigo_producto;
	}
	public void setCodigo_producto(long codigo_producto) {
		this.codigo_producto = codigo_producto;
	}
	public long getCodigo_venta() {
		return codigo_venta;
	}
	public void setCodigo_venta(long codigo_venta) {
		this.codigo_venta = codigo_venta;
	}
	public double getValor_total() {
		return valor_total;
	}
	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}
	public double getValor_venta() {
		return valor_venta;
	}
	public void setValor_venta(double valor_venta) {
		this.valor_venta = valor_venta;
	}
	public double getValoriva() {
		return valoriva;
	}
	public void setValoriva(double valoriva) {
		this.valoriva = valoriva;
	}
	
	

}
