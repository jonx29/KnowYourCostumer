/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.Profesion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.Profesion_;
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
public class ProfesionFacade extends AbstractFacade<Profesion> {

    @PersistenceContext(unitName = "hkjl_mavenproject3_war_678PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProfesionFacade() {
        super(Profesion.class);
    }

    public boolean isClienteListEmpty(Profesion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Profesion> profesion = cq.from(Profesion.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(profesion, entity), cb.isNotEmpty(profesion.get(Profesion_.clienteList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Cliente> findClienteList(Profesion entity) {
        Profesion mergedEntity = this.getMergedEntity(entity);
        List<Cliente> clienteList = mergedEntity.getClienteList();
        clienteList.size();
        return clienteList;
    }
    
}
