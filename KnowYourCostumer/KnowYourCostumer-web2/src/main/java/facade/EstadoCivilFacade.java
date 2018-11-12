/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.EstadoCivil;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.EstadoCivil_;
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
public class EstadoCivilFacade extends AbstractFacade<EstadoCivil> {

    @PersistenceContext(unitName = "hkjl_mavenproject3_war_678PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoCivilFacade() {
        super(EstadoCivil.class);
    }

    public boolean isClienteListEmpty(EstadoCivil entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<EstadoCivil> estadoCivil = cq.from(EstadoCivil.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(estadoCivil, entity), cb.isNotEmpty(estadoCivil.get(EstadoCivil_.clienteList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Cliente> findClienteList(EstadoCivil entity) {
        EstadoCivil mergedEntity = this.getMergedEntity(entity);
        List<Cliente> clienteList = mergedEntity.getClienteList();
        clienteList.size();
        return clienteList;
    }
    
}
