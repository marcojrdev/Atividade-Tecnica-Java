package org.marco.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.marco.config.Transactional;
import org.marco.models.CargoVencimento;

public class DaoGenerico implements Serializable{

	@Inject
    protected EntityManager em;

    public DaoGenerico() {

    }
    
    @SuppressWarnings("unchecked")
	public Object encontrar(Class obj, int id){
    	return em.find(obj, id);
    }
    
    @SuppressWarnings("unchecked")
  	public Object encontrar(Class obj, String campo, int id){
    	Query query = this.em.createQuery("FROM " + obj.getCanonicalName() + " WHERE " + campo + " = " + id, obj);
		List <Object> listOb = query.getResultList();
		if (listOb.isEmpty()) {
			return null;
		} 
		else return listOb.get(0);
     }
      
    
    
    @SuppressWarnings("unchecked")
  	public <T> List<? extends T> encontrar(Class obj, String campo, String id){
    	Query query = this.em.createQuery("FROM " + obj.getCanonicalName() + " WHERE " + campo + " like '%" + id +"%'", obj);
		return query.getResultList();
    
    }
    
   
	 @SuppressWarnings("unchecked")
	public <T> List<? extends T> getAll(Class obj ) {
			Query query = this.em.createQuery("FROM " + obj.getCanonicalName(), obj);
			return query.getResultList();
		}
	 
	 @Transactional
	 public void deleAll (Class obj ) {
			Query query = this.em.createQuery("DELETE FROM "
					+ "" + obj.getCanonicalName());
			 query.executeUpdate();
		}

    public DaoGenerico(EntityManager em) {
        this.em = em;
    }
    
    @Transactional
    public Object salvar(Object obj) {
        return em.merge(obj);
    }

    @Transactional
    public void deletar(Object obj, int id) {
        em.remove(em.find(obj.getClass(), id));

    }
    
    public EntityManager getEm() {
		return em;
	}
}
