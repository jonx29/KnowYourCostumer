/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.Calle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.Calle_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dao.Ciudad;
import dao.Direccion;
import dao.Direccion;
import java.util.List;

/**
 *
 * @author user
 */
@Stateless
public class CalleFacade extends AbstractFacade<Calle> {

    @PersistenceContext(unitName = "hkjl_mavenproject3_war_678PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CalleFacade() {
        super(Calle.class);
    }

    public boolean isCodCiudadEmpty(Calle entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Calle> calle = cq.from(Calle.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(calle, entity), cb.isNotNull(calle.get(Calle_.codCiudad)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Ciudad findCodCiudad(Calle entity) {
        return this.getMergedEntity(entity).getCodCiudad();
    }

    public boolean isDireccionListEmpty(Calle entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Calle> calle = cq.from(Calle.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(calle, entity), cb.isNotEmpty(calle.get(Calle_.direccionList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Direccion> findDireccionList(Calle entity) {
        Calle mergedEntity = this.getMergedEntity(entity);
        List<Direccion> direccionList = mergedEntity.getDireccionList();
        direccionList.size();
        return direccionList;
    }

    public boolean isDireccionList1Empty(Calle entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Calle> calle = cq.from(Calle.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(calle, entity), cb.isNotEmpty(calle.get(Calle_.direccionList1)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Direccion> findDireccionList1(Calle entity) {
        Calle mergedEntity = this.getMergedEntity(entity);
        List<Direccion> direccionList1 = mergedEntity.getDireccionList1();
        direccionList1.size();
        return direccionList1;
    }
    
}
