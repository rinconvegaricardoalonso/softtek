package com.softtek.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.softtek.dao.ProveedorDao;
import com.softtek.entity.ProveedorEntity;

@ManagedBean (name = "proveedorBean")
@RequestScoped
public class ProveedorBean {
	
	static List<ProveedorEntity> proveedores = new ArrayList<ProveedorEntity>();
	static String condicion = "";
	static ProveedorDao proveedorDao = new ProveedorDao();

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	public List<ProveedorEntity> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<ProveedorEntity> proveedores) {
		this.proveedores = proveedores;
	}
	
	public void buscarProveedores() {
		System.out.println("*******************");
		System.out.println("busca proveedores por condicion: " + condicion);
		
		proveedores = proveedorDao.find(condicion);
		
		System.out.println(proveedores);
	}
	
	public String redireccionCrear() {
		System.out.println("*******************");
		System.out.println("se oprime botón de crear proveedor desde el index");
		
		ProveedorEntity proveedor = new ProveedorEntity();
		
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("proveedor", proveedor);
		
		return "/faces/crear.xhtml";
	}
	
	public String limpiar() {
		proveedores = null;
		condicion = null;
		
		return "/faces/index.xhtml";
	}
	
	public String redireccionEditar(ProveedorEntity proveedor) {
		System.out.println("*******************");
		System.out.println("se oprime botón de editar desde registro en el index");
		System.out.println(proveedor);
		
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("proveedor", proveedor);
		return "/faces/editar.xhtml";
	}
	
	public String guardarProveedor(ProveedorEntity proveedor) {
		System.out.println("*******************");
		System.out.println("se oprime botón de Crear/Actualizar proveedor");
		System.out.println(proveedor);
		
		if (proveedor.getIdproveedor() == null) proveedorDao.save(proveedor);
		else proveedorDao.update(proveedor);
		
		condicion = proveedor.getIdentificacion();
		buscarProveedores();
		
		return "/faces/index.xhtml";
	}
	
	public String eliminar(Long idproveedor) {
		System.out.println("*******************");
		System.out.println("se elimina proveedor: " + idproveedor);
		
		proveedorDao.delete(idproveedor);
		
		buscarProveedores();
		
		return "/faces/index.xhtml";
	}
	
	
	
}
