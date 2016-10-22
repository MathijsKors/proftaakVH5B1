/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.repository;

/**
 *
 * @author Dorian
 */
public class BaseRepository {
    DatabaseConnection con;
    
    
    public BaseRepository(DatabaseConnection con){
        this.con = con;
        
    }
    
    public DatabaseConnection getDatabaseConnection(){
        return this.con;
    }
}
