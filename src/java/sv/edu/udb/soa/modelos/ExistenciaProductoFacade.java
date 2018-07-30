/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.soa.modelos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.udb.soa.entidades.ExistenciaProducto;

/**
 *
 * @author Lic Miguel Cortez
 */
@Stateless
public class ExistenciaProductoFacade extends AbstractFacade<ExistenciaProducto> {

    @PersistenceContext(unitName = "soaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExistenciaProductoFacade() {
        super(ExistenciaProducto.class);
    }
    
}
