/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.Direccion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.Direccion_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dao.DireccionCliente;
import dao.Calle;
import dao.Calle;
import java.util.List;

/**
 *
 * @author user
 */
@Stateless
public class DireccionFacade extends AbstractFacade<Direccion> {

    @PersistenceContext(unitName = "hkjl_mavenproject3_war_678PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DireccionFacade() {
        super(Direccion.class);
    }

    public boolean isDireccionClienteListEmpty(Direccion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Direccion> direccion = cq.from(Direccion.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(direccion, entity), cb.isNotEmpty(direccion.get(Direccion_.direccionClienteList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<DireccionCliente> findDireccionClienteList(Direccion entity) {
        Direccion mergedEntity = this.getMergedEntity(entity);
        List<DireccionCliente> direccionClienteList = mergedEntity.getDireccionClienteList();
        direccionClienteList.size();
        return direccionClienteList;
    }

    public boolean isCodCalleTransEmpty(Direccion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Direccion> direccion = cq.from(Direccion.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(direccion, entity), cb.isNotNull(direccion.get(Direccion_.codCalleTrans)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Calle findCodCalleTrans(Direccion entity) {
        return this.getMergedEntity(entity).getCodCalleTrans();
    }

    public boolean isCodCalleEmpty(Direccion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Direccion> direccion = cq.from(Direccion.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(direccion, entity), cb.isNotNull(direccion.get(Direccion_.codCalle)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Calle findCodCalle(Direccion entity) {
        return this.getMergedEntity(entity).getCodCalle();
    }
    
}
