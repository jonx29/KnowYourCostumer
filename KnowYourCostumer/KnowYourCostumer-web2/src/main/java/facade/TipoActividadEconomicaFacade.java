/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.TipoActividadEconomica;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.TipoActividadEconomica_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dao.Cliente;
import java.util.List;

/**
 *
 * @author user
 */
@Stateless
public class TipoActividadEconomicaFacade extends AbstractFacade<TipoActividadEconomica> {

    @PersistenceContext(unitName = "hkjl_mavenproject3_war_678PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoActividadEconomicaFacade() {
        super(TipoActividadEconomica.class);
    }

    public boolean isClienteListEmpty(TipoActividadEconomica entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TipoActividadEconomica> tipoActividadEconomica = cq.from(TipoActividadEconomica.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tipoActividadEconomica, entity), cb.isNotEmpty(tipoActividadEconomica.get(TipoActividadEconomica_.clienteList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Cliente> findClienteList(TipoActividadEconomica entity) {
        TipoActividadEconomica mergedEntity = this.getMergedEntity(entity);
        List<Cliente> clienteList = mergedEntity.getClienteList();
        clienteList.size();
        return clienteList;
    }
    
}
