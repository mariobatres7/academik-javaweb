package com.academik.javaweb.clase04.jsf001.servicio;

import com.academik.javaweb.clase04.jsf001.domain.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 * Stateless, Statefull o Singleton (EJB)
 *
 * @author Mario Batres
 */
@Stateless
public class ProductoServicio {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Producto> findProductoList() {

        //select * from productos
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        
        CriteriaQuery<Producto> query = builder.createQuery(Producto.class);
        
        query.from(Producto.class);
        
        return this.entityManager.createQuery(query).getResultList();
        
    }
}
