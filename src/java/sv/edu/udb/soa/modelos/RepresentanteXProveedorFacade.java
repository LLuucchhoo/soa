/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.soa.modelos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.udb.soa.entidades.RepresentanteXProveedor;

/**
 *
 * @author Lic Miguel Cortez
 */
@Stateless
public class RepresentanteXProveedorFacade extends AbstractFacade<RepresentanteXProveedor> {

    @PersistenceContext(unitName = "soaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RepresentanteXProveedorFacade() {
        super(RepresentanteXProveedor.class);
    }
    
}
