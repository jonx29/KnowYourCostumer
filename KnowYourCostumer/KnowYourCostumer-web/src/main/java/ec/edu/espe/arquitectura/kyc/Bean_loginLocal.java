/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.kyc;

import javax.ejb.Local;

/**
 *
 * @author User
 */
@Local
public interface Bean_loginLocal {
    public String Usuario(String usu, String contra);
    
}
