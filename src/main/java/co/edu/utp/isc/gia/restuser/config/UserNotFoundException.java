/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.restuser.config;

/**
 *
 * @author dfch1
 */
public class UserNotFoundException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;
    
    public UserNotFoundException(String message){
        super(message);
    }
    
}
