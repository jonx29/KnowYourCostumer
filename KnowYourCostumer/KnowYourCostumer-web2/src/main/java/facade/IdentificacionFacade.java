/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.Identificacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.Identificacion_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dao.Cliente;
import dao.Pais;
import dao.TipoIdentificacion;

/**
 *
 * @author user
 */
@Stateless
public class IdentificacionFacade extends AbstractFacade<Identificacion> {

    @PersistenceContext(unitName = "hkjl_mavenproject3_war_678PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IdentificacionFacade() {
        super(Identificacion.class);
    }

    public boolean isClienteEmpty(Identificacion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Identificacion> identificacion = cq.from(Identificacion.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(identificacion, entity), cb.isNotNull(identificacion.get(Identificacion_.cliente)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Cliente findCliente(Identificacion entity) {
        return this.getMergedEntity(entity).getCliente();
    }

    public boolean isPaisEmpty(Identificacion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Identificacion> identificacion = cq.from(Identificacion.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(identificacion, entity), cb.isNotNull(identificacion.get(Identificacion_.pais)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Pais findPais(Identificacion entity) {
        return this.getMergedEntity(entity).getPais();
    }

    public boolean isTipoIdentificacionEmpty(Identificacion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Identificacion> identificacion = cq.from(Identificacion.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(identificacion, entity), cb.isNotNull(identificacion.get(Identificacion_.tipoIdentificacion)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TipoIdentificacion findTipoIdentificacion(Identificacion entity) {
        return this.getMergedEntity(entity).getTipoIdentificacion();
    }
    
}
