/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.dao;

import ec.edu.espe.arquitectura.model.TipoEgreso;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jeffe
 */
@Stateless
public class TipoEgresoFacade extends AbstractFacade<TipoEgreso> {
    @PersistenceContext(unitName = "ec.edu.espe.arquitectura_KnowYourCostumer-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoEgresoFacade() {
        super(TipoEgreso.class);
    }
    
}
