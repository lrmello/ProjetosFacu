package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

    private String hostname;
    private int port;
    private String database;
    private String username;
    private String password;
    private Connection connection;
    
    public DataSource(){
        
        try{
            
            hostname = "localhost";
            port     = 3306;
            database = "crudb";
            username = "root";
            password = "";
            
            String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database;
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = (Connection) DriverManager.getConnection(url,username,password);
            System.out.println("Conexão bem sucedida!!  Baleia Gorda...");
            
            
        }catch(SQLException sqlEx){
            System.err.println("Ocorreu um erro ao tentar conectar!!  Bolsonaro...\n" + sqlEx.getMessage());
        }catch (Exception ex){
            System.err.println("Houve um erro :\n" + ex.getMessage());
        }
        
    }
            
    public Connection getConnection(){
        
        return this.connection;
        
    }
    
    public void closeConnection(){
        
        try{
            connection.close();
        }catch(Exception ex){
            System.err.println("Houve um erro :\n" + ex.getMessage());
        }
        
    }
    
    
    
}
