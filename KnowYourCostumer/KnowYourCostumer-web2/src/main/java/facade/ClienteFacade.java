/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.Cliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dao.Cliente_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import dao.Pais;
import dao.Cliente;
import dao.Cliente;
import dao.TipoActividadEconomica;
import dao.Profesion;
import dao.DireccionCliente;
import dao.Cuenta;
import dao.CargoPolitico;
import dao.Identificacion;
import dao.EstadoCivil;
import dao.Genero;
import dao.Pais;
import dao.TipoPersoneria;
import dao.IngresoCliente;
import dao.NumeroTelefono;
import dao.Parentesco;
import dao.Parentesco;
import dao.Referencia;
import dao.Referencia;
import dao.EgresoCliente;
import java.util.List;

/**
 *
 * @author user
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "hkjl_mavenproject3_war_678PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }

    public boolean isPaisListEmpty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotEmpty(cliente.get(Cliente_.paisList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Pais> findPaisList(Cliente entity) {
        Cliente mergedEntity = this.getMergedEntity(entity);
        List<Pais> paisList = mergedEntity.getPaisList();
        paisList.size();
        return paisList;
    }

    public boolean isClienteListEmpty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotEmpty(cliente.get(Cliente_.clienteList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Cliente> findClienteList(Cliente entity) {
        Cliente mergedEntity = this.getMergedEntity(entity);
        List<Cliente> clienteList = mergedEntity.getClienteList();
        clienteList.size();
        return clienteList;
    }

    public boolean isClienteList1Empty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotEmpty(cliente.get(Cliente_.clienteList1)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Cliente> findClienteList1(Cliente entity) {
        Cliente mergedEntity = this.getMergedEntity(entity);
        List<Cliente> clienteList1 = mergedEntity.getClienteList1();
        clienteList1.size();
        return clienteList1;
    }

    public boolean isTipoActividadEconomicaListEmpty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotEmpty(cliente.get(Cliente_.tipoActividadEconomicaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<TipoActividadEconomica> findTipoActividadEconomicaList(Cliente entity) {
        Cliente mergedEntity = this.getMergedEntity(entity);
        List<TipoActividadEconomica> tipoActividadEconomicaList = mergedEntity.getTipoActividadEconomicaList();
        tipoActividadEconomicaList.size();
        return tipoActividadEconomicaList;
    }

    public boolean isProfesionListEmpty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotEmpty(cliente.get(Cliente_.profesionList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Profesion> findProfesionList(Cliente entity) {
        Cliente mergedEntity = this.getMergedEntity(entity);
        List<Profesion> profesionList = mergedEntity.getProfesionList();
        profesionList.size();
        return profesionList;
    }

    public boolean isDireccionClienteListEmpty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotEmpty(cliente.get(Cliente_.direccionClienteList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<DireccionCliente> findDireccionClienteList(Cliente entity) {
        Cliente mergedEntity = this.getMergedEntity(entity);
        List<DireccionCliente> direccionClienteList = mergedEntity.getDireccionClienteList();
        direccionClienteList.size();
        return direccionClienteList;
    }

    public boolean isCuentaListEmpty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotEmpty(cliente.get(Cliente_.cuentaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Cuenta> findCuentaList(Cliente entity) {
        Cliente mergedEntity = this.getMergedEntity(entity);
        List<Cuenta> cuentaList = mergedEntity.getCuentaList();
        cuentaList.size();
        return cuentaList;
    }

    public boolean isCargoPoliticoListEmpty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotEmpty(cliente.get(Cliente_.cargoPoliticoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<CargoPolitico> findCargoPoliticoList(Cliente entity) {
        Cliente mergedEntity = this.getMergedEntity(entity);
        List<CargoPolitico> cargoPoliticoList = mergedEntity.getCargoPoliticoList();
        cargoPoliticoList.size();
        return cargoPoliticoList;
    }

    public boolean isIdentificacionListEmpty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotEmpty(cliente.get(Cliente_.identificacionList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Identificacion> findIdentificacionList(Cliente entity) {
        Cliente mergedEntity = this.getMergedEntity(entity);
        List<Identificacion> identificacionList = mergedEntity.getIdentificacionList();
        identificacionList.size();
        return identificacionList;
    }

    public boolean isCodEstadoCivilEmpty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotNull(cliente.get(Cliente_.codEstadoCivil)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public EstadoCivil findCodEstadoCivil(Cliente entity) {
        return this.getMergedEntity(entity).getCodEstadoCivil();
    }

    public boolean isCodGeneroEmpty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotNull(cliente.get(Cliente_.codGenero)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Genero findCodGenero(Cliente entity) {
        return this.getMergedEntity(entity).getCodGenero();
    }

    public boolean isPaisNacimientoEmpty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotNull(cliente.get(Cliente_.paisNacimiento)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Pais findPaisNacimiento(Cliente entity) {
        return this.getMergedEntity(entity).getPaisNacimiento();
    }

    public boolean isCodTipoPersoneriaEmpty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotNull(cliente.get(Cliente_.codTipoPersoneria)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TipoPersoneria findCodTipoPersoneria(Cliente entity) {
        return this.getMergedEntity(entity).getCodTipoPersoneria();
    }

    public boolean isIngresoClienteListEmpty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotEmpty(cliente.get(Cliente_.ingresoClienteList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<IngresoCliente> findIngresoClienteList(Cliente entity) {
        Cliente mergedEntity = this.getMergedEntity(entity);
        List<IngresoCliente> ingresoClienteList = mergedEntity.getIngresoClienteList();
        ingresoClienteList.size();
        return ingresoClienteList;
    }

    public boolean isNumeroTelefonoListEmpty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotEmpty(cliente.get(Cliente_.numeroTelefonoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<NumeroTelefono> findNumeroTelefonoList(Cliente entity) {
        Cliente mergedEntity = this.getMergedEntity(entity);
        List<NumeroTelefono> numeroTelefonoList = mergedEntity.getNumeroTelefonoList();
        numeroTelefonoList.size();
        return numeroTelefonoList;
    }

    public boolean isParentescoListEmpty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotEmpty(cliente.get(Cliente_.parentescoList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Parentesco> findParentescoList(Cliente entity) {
        Cliente mergedEntity = this.getMergedEntity(entity);
        List<Parentesco> parentescoList = mergedEntity.getParentescoList();
        parentescoList.size();
        return parentescoList;
    }

    public boolean isParentescoList1Empty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotEmpty(cliente.get(Cliente_.parentescoList1)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Parentesco> findParentescoList1(Cliente entity) {
        Cliente mergedEntity = this.getMergedEntity(entity);
        List<Parentesco> parentescoList1 = mergedEntity.getParentescoList1();
        parentescoList1.size();
        return parentescoList1;
    }

    public boolean isReferenciaListEmpty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotEmpty(cliente.get(Cliente_.referenciaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Referencia> findReferenciaList(Cliente entity) {
        Cliente mergedEntity = this.getMergedEntity(entity);
        List<Referencia> referenciaList = mergedEntity.getReferenciaList();
        referenciaList.size();
        return referenciaList;
    }

    public boolean isReferenciaList1Empty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotEmpty(cliente.get(Cliente_.referenciaList1)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Referencia> findReferenciaList1(Cliente entity) {
        Cliente mergedEntity = this.getMergedEntity(entity);
        List<Referencia> referenciaList1 = mergedEntity.getReferenciaList1();
        referenciaList1.size();
        return referenciaList1;
    }

    public boolean isEgresoClienteListEmpty(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(cliente, entity), cb.isNotEmpty(cliente.get(Cliente_.egresoClienteList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<EgresoCliente> findEgresoClienteList(Cliente entity) {
        Cliente mergedEntity = this.getMergedEntity(entity);
        List<EgresoCliente> egresoClienteList = mergedEntity.getEgresoClienteList();
        egresoClienteList.size();
        return egresoClienteList;
    }

    @Override
    public Cliente findWithParents(Cliente entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Cliente> cq = cb.createQuery(Cliente.class);
        Root<Cliente> cliente = cq.from(Cliente.class);
        cliente.fetch(Cliente_.paisList, JoinType.LEFT);
        cliente.fetch(Cliente_.clienteList, JoinType.LEFT);
        cliente.fetch(Cliente_.tipoActividadEconomicaList, JoinType.LEFT);
        cliente.fetch(Cliente_.profesionList, JoinType.LEFT);
        cq.select(cliente).where(cb.equal(cliente, entity));
        try {
            return em.createQuery(cq).getSingleResult();
        } catch (Exception e) {
            return entity;
        }
    }
    
}
