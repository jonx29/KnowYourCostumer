/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.TipoPersoneria;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.TipoPersoneria_;
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
public class TipoPersoneriaFacade extends AbstractFacade<TipoPersoneria> {

    @PersistenceContext(unitName = "hkjl_mavenproject3_war_678PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoPersoneriaFacade() {
        super(TipoPersoneria.class);
    }

    public boolean isClienteListEmpty(TipoPersoneria entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TipoPersoneria> tipoPersoneria = cq.from(TipoPersoneria.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tipoPersoneria, entity), cb.isNotEmpty(tipoPersoneria.get(TipoPersoneria_.clienteList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Cliente> findClienteList(TipoPersoneria entity) {
        TipoPersoneria mergedEntity = this.getMergedEntity(entity);
        List<Cliente> clienteList = mergedEntity.getClienteList();
        clienteList.size();
        return clienteList;
    }
    
}
