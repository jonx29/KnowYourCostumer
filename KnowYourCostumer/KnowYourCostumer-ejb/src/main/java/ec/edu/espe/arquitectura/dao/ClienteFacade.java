/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.dao;

import ec.edu.espe.arquitectura.model.Cliente;
import java.math.BigDecimal;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jonathan
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura_KnowYourCostumer-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }

    public int eliminarRegistro(Integer codigo) {
        int retorno = 0;
        try {
            Query query1 = em.createNativeQuery("Delete from nacionalidad where cod_cliente = " + codigo);
            query1.executeUpdate();
            Query query2 = em.createNativeQuery("Delete from identificacion where cod_cliente = " + codigo);
            query2.executeUpdate();
            Query query3 = em.createNativeQuery("Delete from contacto where cod_cliente = " + codigo);
            query3.executeUpdate();
            Query query4 = em.createNativeQuery("Delete from egreso_cliente where cod_cliente = " + codigo);
            query4.executeUpdate();
            Query query5 = em.createNativeQuery("Delete from cargo_politico where cod_cliente = " + codigo);
            query5.executeUpdate();
            Query query6 = em.createNativeQuery("Delete from profesion_cliente where cod_cliente = " + codigo);
            query6.executeUpdate();
            Query query7 = em.createNativeQuery("Delete from ingreso_cliente where cod_cliente = " + codigo);
            query7.executeUpdate();
            Query query8 = em.createNativeQuery("Delete from referencia where cod_cliente = " + codigo);
            query8.executeUpdate();
            Query query9 = em.createNativeQuery("Delete from parentesco where cod_cliente = " + codigo);
            query9.executeUpdate();
            Query query10 = em.createNativeQuery("Delete from actividad_economica where cod_cliente = " + codigo);
            query10.executeUpdate();
            Query query11 = em.createNativeQuery("Delete from cuenta where cod_cliente = " + codigo);
            query11.executeUpdate();
            Query query12 = em.createNativeQuery("Delete from numero_telefono where cod_cliente = " + codigo);
            query12.executeUpdate();

            Query query = em.createNativeQuery("Delete from cliente where cod_cliente = " + codigo);
            query.executeUpdate();
            Query query15 = em.createNativeQuery("Delete from cliente where cod_cliente = " + (codigo + 1));
            query15.executeUpdate();
            retorno = 1;
        } catch (Exception ex) {
            retorno = 0;
        }
        return retorno;
    }

    public int maxCodigo() {
        int valorMaximo = 0;
        List<BigDecimal> listaMaxima = new ArrayList<BigDecimal>();
        Query q_maximo = em.createNativeQuery("SELECT MAX(cod_cliente)+1 FROM cliente");
        listaMaxima = q_maximo.getResultList();
        valorMaximo = Integer.parseInt(listaMaxima.get(0).toString());
        return valorMaximo;
    }

    public int maxCodigoProfesion() {
        int valorMaximo = 0;
        List<BigDecimal> listaMaxima = new ArrayList<BigDecimal>();
        Query q_maximo = em.createNativeQuery("SELECT MAX(cod_profesion)+1 FROM profesion");
        listaMaxima = q_maximo.getResultList();
        valorMaximo = Integer.parseInt(listaMaxima.get(0).toString());
        return valorMaximo;
    }

    public int genero(String genero) {
        int generoFinal = 0;
        List<BigDecimal> listaGenero = new ArrayList<BigDecimal>();
        Query q_maximo = em.createNativeQuery("SELECT cod_genero FROM genero where descripcion='" + genero + "'");
        listaGenero = q_maximo.getResultList();
        generoFinal = Integer.parseInt(listaGenero.get(0).toString());
        return generoFinal;
    }

    public int estadoCivil(String estado) {
        int estadoCivilFinal = 0;
        List<BigDecimal> listaEstado = new ArrayList<BigDecimal>();
        Query q_maximo = em.createNativeQuery("SELECT cod_estado_civil FROM estado_civil where descripcion='" + estado + "'");
        listaEstado = q_maximo.getResultList();
        estadoCivilFinal = Integer.parseInt(listaEstado.get(0).toString());
        return estadoCivilFinal;
    }

    public int calles(String nombre) {
        int totalCalles = 0;
        List<Long> listaCalles = new ArrayList<Long>();
        Query q_maximo = em.createNativeQuery("SELECT count(cod_calle) FROM calle where nombre='" + nombre + "'");
        listaCalles = q_maximo.getResultList();
        totalCalles = Integer.parseInt(listaCalles.get(0).toString());
        return totalCalles;
    }

    public int tipoIdentificacion(String idef) {
        int idefFinal = 0;
        List<BigDecimal> listaIdentificacion = new ArrayList<BigDecimal>();
        Query q_maximo = em.createNativeQuery("SELECT cod_tipo_identificacion FROM tipo_identificacion where descripcion='" + idef + "'");
        listaIdentificacion = q_maximo.getResultList();
        idefFinal = Integer.parseInt(listaIdentificacion.get(0).toString());
        return idefFinal;
    }

    public int profesiones(String nombre) {
        int totalProfesiones = 0;
        List<Long> listaProfesion = new ArrayList<Long>();
        Query q_maximo = em.createNativeQuery("SELECT count(cod_profesion) FROM profesion where descripcion='" + nombre + "'");
        listaProfesion = q_maximo.getResultList();
        totalProfesiones = Integer.parseInt(listaProfesion.get(0).toString());
        return totalProfesiones;
    }

    public int cedula(String cedula) {
        int totalCedulas = 0;
        List<Long> listaCedulas = new ArrayList<Long>();
        Query q_maximo = em.createNativeQuery("SELECT count(cod_identificacion) FROM identificacion where numero_identificacion=" + Integer.parseInt(cedula) + "");
        listaCedulas = q_maximo.getResultList();
        totalCedulas = Integer.parseInt(listaCedulas.get(0).toString());
        return totalCedulas;
    }

    public int ingresarCliente(String apellidos, String nombres, Date nace, Date registro, String genero1, String estado1, String profesion, String cedula, String pais, String tipoIdef) {
        int retorno = 0;
        try {
            if (cedula(cedula) != 1) {
                if (pais != null) {
                    Query query1;
                    if (profesiones(profesion) != 1) {
                        query1 = em.createNativeQuery("INSERT INTO profesion(cod_profesion, descripcion) "
                                + "VALUES (" + maxCodigoProfesion() + ",'" + profesion + "')");
                        query1.executeUpdate();
                    } else {
                    }
                    Query query2 = em.createNativeQuery("INSERT INTO profesion_cliente(cod_profesion_cliente, cod_cliente, cod_profesion) "
                            + "VALUES ((SELECT MAX(cod_profesion_cliente)+1 FROM profesion_cliente),1,(SELECT cod_profesion FROM profesion where descripcion='" + profesion + "'))");
                    query2.executeUpdate();
                    Query query3 = em.createNativeQuery("INSERT INTO identificacion(cod_identificacion, cod_tipo_identificacion, cod_cliente, cod_pais, numero_identificacion) "
                            + "VALUES ((SELECT MAX(cod_identificacion)+1 FROM identificacion)," + tipoIdentificacion(tipoIdef) + ",1,(SELECT cod_pais FROM pais where nombre='" + pais + "')," + Integer.parseInt(cedula) + ")");
                    query3.executeUpdate();

                    Date hoy = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
                    Query query = em.createNativeQuery("INSERT INTO cliente(cod_cliente, cod__direccion, cod_estado_civil, "
                            + "cod_genero, cod_tipo_personeria, pais_nacimiento, nombres, apellidos, fecha_nacimiento, fecha_registro, hora_registro) "
                            + "VALUES (" + maxCodigo() + ", 1, " + estadoCivil(estado1) + "," + genero(genero1) + ", 1, (SELECT cod_pais FROM pais WHERE nombre = '" + pais + "'), '" + nombres + "', '" + apellidos + "', '" + nace + "', '" + registro + "', '" + sdf.format(hoy) + "')");
                    query.executeUpdate();

                    Query query20 = em.createNativeQuery("UPDATE profesion_cliente SET cod_cliente= (SELECT MAX(cod_cliente) FROM cliente) where cod_profesion_cliente=(SELECT MAX(cod_profesion_cliente) FROM profesion_cliente)");
                    query20.executeUpdate();
                    Query query21 = em.createNativeQuery("UPDATE identificacion SET cod_cliente= (SELECT MAX(cod_cliente) FROM cliente) where cod_identificacion=(SELECT MAX(cod_identificacion) FROM identificacion)");
                    query21.executeUpdate();

                    retorno = 1;
                } else {
                    retorno = 0;
                }
            } else {
                retorno = 0;
            }
        } catch (Exception ex) {
            retorno = 0;
        }
        return retorno;
    }

    public int ingresarResidencia(String pais, String ciudad, String provincia, String calleP, String calleS, int casa, String referencia, int celular, int domicilio) {
        int retorno = 0;
        try {
            if (pais != null && ciudad != null && provincia != null && calleP != null && calleS != null && casa != 0
                    && referencia != null && celular > 0 && domicilio > 0) {
                if (celular > 99999999 && domicilio > 999999) {
                    Query query8 = em.createNativeQuery("INSERT INTO nacionalidad(cod_nacionalidad, cod_pais, cod_cliente) "
                            + "VALUES ((SELECT MAX(cod_nacionalidad)+1 FROM nacionalidad),(SELECT cod_pais FROM pais WHERE nombre='" + pais + "'),(SELECT MAX(cod_cliente) FROM cliente))");
                    query8.executeUpdate();

                    Query query1;
                    if (calles(calleP) != 1) {
                        query1 = em.createNativeQuery("INSERT INTO calle(cod_calle, cod_ciudad, nombre) "
                                + "VALUES ((SELECT MAX(cod_calle)+1 FROM calle),(SELECT cod_ciudad FROM ciudad WHERE nombre='" + ciudad + "'),'" + calleP + "')");
                        query1.executeUpdate();
                    } else {
                    }
                    Query query2;
                    if (calles(calleS) != 1) {
                        query2 = em.createNativeQuery("INSERT INTO calle(cod_calle, cod_ciudad, nombre) "
                                + "VALUES ((SELECT MAX(cod_calle)+1 FROM calle),(SELECT cod_ciudad FROM ciudad WHERE nombre='" + ciudad + "'),'" + calleS + "')");
                        query2.executeUpdate();
                    } else {
                    }
                    Query query3 = em.createNativeQuery("INSERT INTO direccion(cod_direccion, cod_calle, cod_calle_trans, numero, referencia) "
                            + "VALUES ((SELECT MAX(cod_direccion)+1 FROM direccion),(SELECT cod_calle FROM calle WHERE nombre='" + calleP + "'),(SELECT cod_calle FROM calle WHERE nombre='" + calleS + "')," + casa + ",'" + referencia + "' )");
                    query3.executeUpdate();

                    Query query4 = em.createNativeQuery("INSERT INTO numero_telefono(cod_numero_telefono, cod_tipo_telefono,cod_cliente,numero) "
                            + "VALUES ((SELECT MAX(cod_numero_telefono)+1 FROM numero_telefono),1,(SELECT MAX(cod_cliente) FROM cliente)," + celular + ")");
                    query4.executeUpdate();
                    Query query5 = em.createNativeQuery("INSERT INTO numero_telefono(cod_numero_telefono, cod_tipo_telefono,cod_cliente,numero) "
                            + "VALUES ((SELECT MAX(cod_numero_telefono)+1 FROM numero_telefono),2,(SELECT MAX(cod_cliente) FROM cliente)," + domicilio + ")");
                    query5.executeUpdate();

                    Query query21 = em.createNativeQuery("UPDATE cliente SET cod__direccion = (SELECT MAX(cod_direccion) FROM direccion) where cod_cliente=(SELECT MAX(cod_cliente) FROM cliente)");
                    query21.executeUpdate();

                    retorno = 1;
                } else {
                    eliminarRegistro(maxCodigo() - 1);
                    retorno = 0;
                }
            } else {
                eliminarRegistro(maxCodigo() - 1);
                retorno = 0;
            }
        } catch (Exception ex) {
            eliminarRegistro(maxCodigo());
            retorno = 0;
        }
        return retorno;
    }

    public int ingresarDatosEconomicos(String actividad, double ingresos, double egresos) {
        int retorno = 0;
        //try {
        if (ingresos!=0 && egresos!=0) {
            Query query1 = em.createNativeQuery("INSERT INTO tipo_actividad_economica(cod_tipo_actividad_economica, descripcion) "
                    + "VALUES ((SELECT MAX(cod_tipo_actividad_economica)+1 FROM tipo_actividad_economica),'" + actividad + "')");
            query1.executeUpdate();
            Query query2 = em.createNativeQuery("INSERT INTO actividad_economica(cod_actividad_economica, cod_tipo_actividad_economica, cod_cliente) "
                    + "VALUES ((SELECT MAX(cod_actividad_economica)+1 FROM actividad_economica),(SELECT MAX(cod_tipo_actividad_economica) FROM tipo_actividad_economica),(SELECT MAX(cod_cliente) FROM cliente))");
            query2.executeUpdate();

            Query query3 = em.createNativeQuery("INSERT INTO ingreso_cliente(cod_ingreso_cliente, cod_tipo_ingreso, cod_cliente, valor) "
                    + "VALUES ((SELECT MAX(cod_ingreso_cliente)+1 FROM ingreso_cliente),1,(SELECT MAX(cod_cliente) FROM cliente)," + ingresos + ")");
            query3.executeUpdate();
            Query query4 = em.createNativeQuery("INSERT INTO egreso_cliente(cod_egreso_cliente, cod_tipo_egreso, cod_cliente, valor) "
                    + "VALUES ((SELECT MAX(cod_egreso_cliente)+1 FROM egreso_cliente),1,(SELECT MAX(cod_cliente) FROM cliente)," + egresos + ")");
            query4.executeUpdate();

            retorno = 1;
        }else{
            retorno = 0;
        }
        /*} catch (Exception ex) {
            retorno = 0;
        }*/
        return retorno;
    }

    public int ingresarActividadPolitica(String cargo, Date inicio, Date Fin) {
        int retorno = 0;
        //try{
        Query query1 = em.createNativeQuery("INSERT INTO tipo_cargo_politico(cod_tipo_cargo_politico, descripcion) "
                + "VALUES ((SELECT MAX(cod_tipo_cargo_politico)+1 FROM tipo_cargo_politico),'" + cargo + "')");
        query1.executeUpdate();
        Query query2 = em.createNativeQuery("INSERT INTO cargo_politico(cod_cargo_politico, cod_tipo_cargo_politico, cod_cliente, fecha_inicio, fecha_fin) "
                + "VALUES ((SELECT MAX(cod_cargo_politico)+1 FROM cargo_politico),(SELECT MAX(cod_tipo_cargo_politico) FROM tipo_cargo_politico),"
                + "(SELECT MAX(cod_cliente) FROM cliente),'" + inicio + "','" + Fin + "')");
        query2.executeUpdate();

        retorno = 1;
        /*} catch (Exception ex) {
         retorno = 0;
         }*/

        return retorno;
    }

    public int parentesco(String parentesco) {
        int totalparentesco = 0;
        List<Long> listaPariente = new ArrayList<Long>();
        Query q_maximo = em.createNativeQuery("SELECT count(cod_tipo_parentesco) FROM tipo_parentesco where descripcion='" + parentesco + "'");
        listaPariente = q_maximo.getResultList();
        totalparentesco = Integer.parseInt(listaPariente.get(0).toString());
        return totalparentesco;
    }

    public int ingresarParentescoEmpleados(String nombre, String apellido, Date nace, String pais, String parentesco1) {
        int retorno = 0;
        //try{        
        Query query2;
        if (parentesco(parentesco1) != 1) {
            query2 = em.createNativeQuery("INSERT INTO tipo_parentesco(cod_tipo_parentesco, descripcion) "
                    + "VALUES ((SELECT MAX(cod_tipo_parentesco)+1 FROM tipo_parentesco),'" + parentesco1 + "')");
            query2.executeUpdate();
        } else {
        }
        Query query1 = em.createNativeQuery("INSERT INTO cliente(cod_cliente, cod__direccion, cod_estado_civil, "
                + "cod_genero, cod_tipo_personeria, pais_nacimiento, nombres, apellidos, fecha_nacimiento, fecha_registro, hora_registro) "
                + "VALUES (" + maxCodigo() + ", 1, 1, 4, 1,(SELECT cod_pais FROM pais WHERE nombre = '" + pais + "'), '" + nombre + "', '" + apellido + "', "
                + "'" + nace + "', '1900-01-01', '01:00:00')");
        query1.executeUpdate();

        Query query3 = em.createNativeQuery("INSERT INTO parentesco(cod_parentesco, cod_cliente, cli_cod_cliente, cod_tipo_parentesco) VALUES ("
                + "(SELECT MAX(cod_parentesco)+1 FROM parentesco),(SELECT MAX(cod_cliente)-1 FROM cliente),(SELECT MAX(cod_cliente) FROM cliente),"
                + "(SELECT cod_tipo_parentesco FROM tipo_parentesco WHERE descripcion ='" + parentesco1 + "'))");
        query3.executeUpdate();

        retorno = 1;
        /*} catch (Exception ex) {sout  
         retorno = 0;
         }*/

        return retorno;
    }

//    public Cliente busqueda(Integer codCliente) {
//
//        Cliente cliente = null;
//        System.out.println("este es oara buscar al cliente");
//
//        try {
//            Query q = em.createNativeQuery("SELECT * FROM cliente WHERE cod_cliente='" + codCliente + "'");
//            List li = q.getResultList();
//
//            if (li.size() >= 1) {
//                System.out.println("este es el if");
//                for (Object lista : li) {
//                    System.out.println("este es el for");
//                    Object[] clientes = (Object[]) (lista);
//                    System.out.println("ffffff");
//                    BigDecimal codigo = (BigDecimal) clientes[0];
//                    System.out.println("codigo"+codigo);
//                    int direccion = (int) clientes[1];
//                    int estadoCivil = (int) clientes[2];
//                    int genero = (int) clientes[3];
//                    int personeria = (int) clientes[4];
//                    int pais = (int) clientes[5];
//                    String nombres = clientes[6].toString();
//                    String apellidos = clientes[7].toString();
//                    System.out.println("Apellido"+apellidos);
//                    Date fechaNac = (Date) clientes[8];
//                    Date fechaRegis = (Date) clientes[9];
//                    Time tiempo = (Time) clientes[10];
//                   // cliente = new Cliente(codCliente, nombres, apellidos, fechaRegis, fechaRegis);
//
//                }
//            }
//        } catch (Exception ex) {
//
//        }
//
//        return cliente;
//    }
    public Cliente busqueda(Integer codCliente) {
         Cliente use;
        try {
            System.out.println("entra a la busqueda");
            Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.codCliente = :codCliente");
            query.setParameter("codCliente", codCliente);
            use = (Cliente) query.getSingleResult();
            System.out.println("busca algo o no "+use.getApellidos());
        } catch (Exception e) {
            System.out.println("ERROR" + e);
            use = null;
        }

        return use;
    }

}
