/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;

/**
 *
 * @author Feu's m15 R6
 */
public class ProjectController {
    
    
    
    
    
    //controller methods
    public void save(Project project){
       String sql = "INSERT into projects (name,"
               + "description,"
               + "date_creation,"
               + "date_editing) "
               + "VALUES (?, ?, ?, ?)"; 
       
       Connection c = null;
       PreparedStatement statement = null;
       
       try{
           //create connection with database
           c = ConnectionFactory.getConnection();
           
           //create a PreparedStatement, clas used for query execution
           statement = c.prepareStatement(sql);
           
           statement.setString(1, project.getName());
           statement.setString(2, project.getDescription());
           statement.setDate(3, new Date(project.getCreatedAt().getTime()));
           statement.setDate(4, new Date(project.getModifiedAt().getTime()));
           
           //run sql for data insertion 
           statement.execute();
           
       } catch(SQLException ex){
           throw new RuntimeException("Erro ao salvar o projeto!", ex);
       } finally {
           ConnectionFactory.closeConnection(c, statement);
       }
    }
    
    
    
    public void update(Project project){
        String sql = "UPDATE projects SET "
                + "name = ?,"
                + "description = ?"
                + "WHERE id = ?";
        Connection c = null;
        PreparedStatement statement = null;
        try {
            // pass to c a connection with the database
            c = ConnectionFactory.getConnection();
            
            // create a preparedStatement, for sql command
            statement = c.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setInt(3, project.getId());
            
            //run sql command
            statement.execute();
        } catch (SQLException ex){
            throw new RuntimeException("Erro ao atualizar o projeto do projeto.", ex);
        } finally {
        //close the c connection and the statement
        ConnectionFactory.closeConnection(c, statement);
    }
                
    }
    
    public void removeById(int projectId){
        String sql = "DELETE project WHERE id = ?";
        Connection c = null;
        PreparedStatement statement = null;
        
        try {
            c = ConnectionFactory.getConnection();
            
            statement = c.prepareStatement(sql);
            statement.setInt(1, projectId);
            statement.execute();
            
        } catch(SQLException ex) {
            throw new RuntimeException("Erro ao deletar projeto.", ex);
        } finally {
            ConnectionFactory.closeConnection(c, statement);
        }
            
    }
    
    public List<Project> getAll(){
        String sql = "SELECT * from projects";
        
        List<Project> projects = new ArrayList<>();
        
        Connection c = null;
        PreparedStatement statement = null;
        
        ResultSet resultSet = null;
        
        try {
            c = ConnectionFactory.getConnection();
            statement = c.prepareStatement(sql);
            resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                Project project = new Project();
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCreatedAt(resultSet.getDate("date_creation"));
                project.setModifiedAt(resultSet.getDate("date_editing"));
                
                projects.add(project);
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar lista de projetos.", ex);
        } finally {
            ConnectionFactory.closeConnection(c, statement);
        }
        
        return projects;
    }

    
}
