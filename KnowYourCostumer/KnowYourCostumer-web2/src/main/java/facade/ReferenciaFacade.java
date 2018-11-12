/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.Referencia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.Referencia_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dao.Cliente;
import dao.Cliente;
import dao.TipoReferencia;

/**
 *
 * @author user
 */
@Stateless
public class ReferenciaFacade extends AbstractFacade<Referencia> {

    @PersistenceContext(unitName = "hkjl_mavenproject3_war_678PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReferenciaFacade() {
        super(Referencia.class);
    }

    public boolean isClienteEmpty(Referencia entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Referencia> referencia = cq.from(Referencia.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(referencia, entity), cb.isNotNull(referencia.get(Referencia_.cliente)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Cliente findCliente(Referencia entity) {
        return this.getMergedEntity(entity).getCliente();
    }

    public boolean isCliente1Empty(Referencia entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Referencia> referencia = cq.from(Referencia.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(referencia, entity), cb.isNotNull(referencia.get(Referencia_.cliente1)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Cliente findCliente1(Referencia entity) {
        return this.getMergedEntity(entity).getCliente1();
    }

    public boolean isCodTipoReferenciaEmpty(Referencia entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Referencia> referencia = cq.from(Referencia.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(referencia, entity), cb.isNotNull(referencia.get(Referencia_.codTipoReferencia)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TipoReferencia findCodTipoReferencia(Referencia entity) {
        return this.getMergedEntity(entity).getCodTipoReferencia();
    }
    
}
