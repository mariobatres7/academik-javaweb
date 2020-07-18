package edu.academik.producto.micro.service;

import edu.academik.producto.micro.domain.Product;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mario Batres
 */
@RequestScoped
public class ProductService {

    @PersistenceContext
    private EntityManager entityManager;
    
    public Product findProduct(Long id){
        return this.entityManager.find(Product.class, id);
    }

}
