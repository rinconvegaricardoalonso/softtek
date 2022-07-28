package com.softtek.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proveedor")
public class ProveedorEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idproveedor;
	
	@Column
	private String nombre;
	
	@Column
	private String identificacion;
	
	@Column
	private String direccion;
	
	@Column
	private String correo;
	
	@Column
	private Integer disponibilidad;

	public Long getIdproveedor() {
		return idproveedor;
	}

	public void setIdproveedor(Long idproveedor) {
		this.idproveedor = idproveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Integer getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(Integer disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	@Override
	public String toString() {
		return "ProveedorEntity [idproveedor=" + idproveedor + ", nombre=" + nombre + ", identificacion="
				+ identificacion + ", direccion=" + direccion + ", correo=" + correo + ", disponibilidad="
				+ disponibilidad + "]";
	}

}
