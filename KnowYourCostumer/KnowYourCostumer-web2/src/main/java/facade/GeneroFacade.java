/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.Genero;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.Genero_;
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
public class GeneroFacade extends AbstractFacade<Genero> {

    @PersistenceContext(unitName = "hkjl_mavenproject3_war_678PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GeneroFacade() {
        super(Genero.class);
    }

    public boolean isClienteListEmpty(Genero entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Genero> genero = cq.from(Genero.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(genero, entity), cb.isNotEmpty(genero.get(Genero_.clienteList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Cliente> findClienteList(Genero entity) {
        Genero mergedEntity = this.getMergedEntity(entity);
        List<Cliente> clienteList = mergedEntity.getClienteList();
        clienteList.size();
        return clienteList;
    }
    
}
