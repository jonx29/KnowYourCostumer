/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.TipoIdentificacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.TipoIdentificacion_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dao.Identificacion;
import java.util.List;

/**
 *
 * @author user
 */
@Stateless
public class TipoIdentificacionFacade extends AbstractFacade<TipoIdentificacion> {

    @PersistenceContext(unitName = "hkjl_mavenproject3_war_678PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoIdentificacionFacade() {
        super(TipoIdentificacion.class);
    }

    public boolean isIdentificacionListEmpty(TipoIdentificacion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TipoIdentificacion> tipoIdentificacion = cq.from(TipoIdentificacion.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tipoIdentificacion, entity), cb.isNotEmpty(tipoIdentificacion.get(TipoIdentificacion_.identificacionList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Identificacion> findIdentificacionList(TipoIdentificacion entity) {
        TipoIdentificacion mergedEntity = this.getMergedEntity(entity);
        List<Identificacion> identificacionList = mergedEntity.getIdentificacionList();
        identificacionList.size();
        return identificacionList;
    }
    
}
