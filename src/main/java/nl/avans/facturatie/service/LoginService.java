/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.service;

import nl.avans.facturatie.model.User;
import nl.avans.facturatie.repository.LoginRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dyl
 */
@Service
public class LoginService {
    
    private final Logger logger = LoggerFactory.getLogger(LoginService.class);
    
    private LoginRepository loginRepository;
    private User user;
    
    /**
     *
     * @param loginRepository
     */
    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }
    
    /**
     *
     * @param username
     * @param password
     * @return
     */
    public boolean checkPassword(String username, String password){
        logger.info("checkPassword - login" + username + password);
        return loginRepository.checkPassword(username, password);
    }
    
}