/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.DireccionCliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.DireccionCliente_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dao.Cliente;
import dao.Direccion;

/**
 *
 * @author user
 */
@Stateless
public class DireccionClienteFacade extends AbstractFacade<DireccionCliente> {

    @PersistenceContext(unitName = "hkjl_mavenproject3_war_678PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DireccionClienteFacade() {
        super(DireccionCliente.class);
    }

    public boolean isClienteEmpty(DireccionCliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<DireccionCliente> direccionCliente = cq.from(DireccionCliente.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(direccionCliente, entity), cb.isNotNull(direccionCliente.get(DireccionCliente_.cliente)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Cliente findCliente(DireccionCliente entity) {
        return this.getMergedEntity(entity).getCliente();
    }

    public boolean isDireccionEmpty(DireccionCliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<DireccionCliente> direccionCliente = cq.from(DireccionCliente.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(direccionCliente, entity), cb.isNotNull(direccionCliente.get(DireccionCliente_.direccion)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Direccion findDireccion(DireccionCliente entity) {
        return this.getMergedEntity(entity).getDireccion();
    }
    
}
