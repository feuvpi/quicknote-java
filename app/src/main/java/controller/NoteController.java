/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Note;
import util.ConnectionFactory;

/**
 *
 * @author Feu's m15 R6
 */
public class NoteController {
    
    public void save(Note note) {
        
        String sql = "INSERT INTO tasks (idProject, name, note, completed, deadline, date_creation, date_editing) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        Connection c = null;
        PreparedStatement statement = null;
        
        try {
            c = ConnectionFactory.getConnection();
            statement = c.prepareStatement(sql);
            statement.setInt(1, note.getIdProject());
            statement.setString(2, note.getName());
            statement.setString(3, note.getNote());
            statement.setBoolean(4, note.isCompleted());
            statement.setDate(5, new Date(note.getDeadline().getTime()));
            statement.setDate(6, new Date(note.getCreatedAt().getTime()));
            statement.setDate(7, new Date(note.getModifiedAt().getTime()));
            statement.execute();
                    
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar a nota " + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(c, statement);
       
        }
        
    };
    
    public void update (Note note) {
        
        String sql = "UPDATE notes SET "
                + "idProject = ?, "
                + "name = ?, "
                + "note = ?, "
                + "completed = ?, "
                + "deadline = ?, "
                + "date_editing = ? "
                + "WHERE id = ?";
        
        
        Connection c = null;
        PreparedStatement statement = null;
        
        try {
            c = ConnectionFactory.getConnection();
            statement = c.prepareStatement(sql);
            statement.setInt(1, note.getIdProject());
            statement.setString(2, note.getName());
            statement.setString(3, note.getNote());
            statement.setBoolean(4, note.isCompleted());
            statement.setDate(5, new Date(note.getDeadline().getTime()));
            statement.setDate(6, new Date(note.getModifiedAt().getTime()));
            statement.setInt(7, note.getId());
            statement.execute();
                    
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao editar a nota " + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(c, statement);
       
        }
        
    }
    
    public void removeById(int noteId) throws SQLException{
        String sql = "DELETE FROM tasks WHERE id = ?";
        
        Connection c = null;
        PreparedStatement statement = null;
        
        try {
            c = ConnectionFactory.getConnection();
            statement = c.prepareStatement(sql);
            statement.setInt(1, noteId);
            statement.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar a nota" + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(c, statement);
        }
    }
    
    public List<Note> getAll(int idProject) {
        
        String sql = "SELECT * from tasks WHERE idProject = ?";
        
        Connection c = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Note> notes = new ArrayList<Note>();
        
        try {
            c = ConnectionFactory.getConnection();
            statement = c.prepareStatement(sql);
            statement.setInt(1, idProject);
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao carregar notas" + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(c);
        }
        
        
        return null;
    }
    
}
