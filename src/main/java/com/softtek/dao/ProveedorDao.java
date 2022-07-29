package com.softtek.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.softtek.entity.ProveedorEntity;
import com.softtek.util.SofttekJPA;

public class ProveedorDao {

	private EntityManager entity = SofttekJPA.getEntityManagerFactory().createEntityManager();
	
	public void save(ProveedorEntity proveedor) {
		proveedor.setNombre(proveedor.getNombre().toUpperCase());
		entity.getTransaction().begin();
		entity.persist(proveedor);
		entity.getTransaction().commit();
	}
	
	public void update(ProveedorEntity proveedor) {
		proveedor.setNombre(proveedor.getNombre().toUpperCase());
		entity.getTransaction().begin();
		entity.merge(proveedor);
		entity.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<ProveedorEntity> find(String condicion) {
		Query query = entity.createQuery("SELECT p FROM ProveedorEntity p "
										+ "where p.nombre like '%" + condicion.toUpperCase() + "%' "
										+ "or p.identificacion like '%" + condicion + "%' ");
		List<ProveedorEntity> proveedorLis = query.getResultList();
		return proveedorLis;
	}
	
	@SuppressWarnings("unchecked")
	public ProveedorEntity findByIdentificacion(String identificacion) {
		Query query = entity.createQuery("SELECT p FROM ProveedorEntity p "
										+ "where p.identificacion = '" + identificacion + "' ");
		ProveedorEntity proveedor = (ProveedorEntity) query.getSingleResult();
		return proveedor;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProveedorEntity> findAll() {
		Query uery = entity.createQuery("SELECT P FROM ProveedorEntity P");
		List<ProveedorEntity> proveedorLis = uery.getResultList();
		SofttekJPA.shutdown();
		return proveedorLis;
	}
	
	public void delete(Long idproveedor) {
		entity.getTransaction().begin();
		ProveedorEntity proveedorEntity = entity.find(ProveedorEntity.class, idproveedor);
		entity.remove(proveedorEntity);
		entity.getTransaction().commit();
	}
	
}
