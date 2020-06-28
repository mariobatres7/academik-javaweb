package com.academik.javaweb.clase04.jsf001.servicio;

import com.academik.javaweb.clase04.jsf001.domain.Inventario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Mario Batres
 */
@Stateless
public class InventarioServicio {

    @PersistenceContext
    private EntityManager entityManager;

    
    public List<Inventario> findInventarioList() {

        //select * from productos
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        
        CriteriaQuery<Inventario> query = builder.createQuery(Inventario.class);
        
        Root<Inventario> root =  query.from(Inventario.class);
        
        root.fetch("producto");
        
        return this.entityManager.createQuery(query).getResultList();
        
    }
}
