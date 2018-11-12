/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.IngresoCliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.IngresoCliente_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dao.Cliente;
import dao.TipoIngreso;

/**
 *
 * @author user
 */
@Stateless
public class IngresoClienteFacade extends AbstractFacade<IngresoCliente> {

    @PersistenceContext(unitName = "hkjl_mavenproject3_war_678PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IngresoClienteFacade() {
        super(IngresoCliente.class);
    }

    public boolean isClienteEmpty(IngresoCliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<IngresoCliente> ingresoCliente = cq.from(IngresoCliente.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ingresoCliente, entity), cb.isNotNull(ingresoCliente.get(IngresoCliente_.cliente)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Cliente findCliente(IngresoCliente entity) {
        return this.getMergedEntity(entity).getCliente();
    }

    public boolean isTipoIngresoEmpty(IngresoCliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<IngresoCliente> ingresoCliente = cq.from(IngresoCliente.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ingresoCliente, entity), cb.isNotNull(ingresoCliente.get(IngresoCliente_.tipoIngreso)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TipoIngreso findTipoIngreso(IngresoCliente entity) {
        return this.getMergedEntity(entity).getTipoIngreso();
    }
    
}
