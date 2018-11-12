/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.Provincia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.Provincia_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dao.Pais;
import dao.Ciudad;
import java.util.List;

/**
 *
 * @author user
 */
@Stateless
public class ProvinciaFacade extends AbstractFacade<Provincia> {

    @PersistenceContext(unitName = "hkjl_mavenproject3_war_678PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProvinciaFacade() {
        super(Provincia.class);
    }

    public boolean isCodPaisEmpty(Provincia entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Provincia> provincia = cq.from(Provincia.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(provincia, entity), cb.isNotNull(provincia.get(Provincia_.codPais)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Pais findCodPais(Provincia entity) {
        return this.getMergedEntity(entity).getCodPais();
    }

    public boolean isCiudadListEmpty(Provincia entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Provincia> provincia = cq.from(Provincia.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(provincia, entity), cb.isNotEmpty(provincia.get(Provincia_.ciudadList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Ciudad> findCiudadList(Provincia entity) {
        Provincia mergedEntity = this.getMergedEntity(entity);
        List<Ciudad> ciudadList = mergedEntity.getCiudadList();
        ciudadList.size();
        return ciudadList;
    }
    
}
