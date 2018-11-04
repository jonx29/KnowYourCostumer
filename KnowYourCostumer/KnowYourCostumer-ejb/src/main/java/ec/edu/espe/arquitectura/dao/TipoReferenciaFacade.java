/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.dao;

import ec.edu.espe.arquitectura.model.TipoReferencia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jeffe
 */
@Stateless
public class TipoReferenciaFacade extends AbstractFacade<TipoReferencia> {
    @PersistenceContext(unitName = "ec.edu.espe.arquitectura_KnowYourCostumer-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoReferenciaFacade() {
        super(TipoReferencia.class);
    }
    
}
