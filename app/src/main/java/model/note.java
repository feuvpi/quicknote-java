/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Feu's m15 R6
 */
public class Note {
    
    // definindo atributos
    
    private int id;
    private int idProject;
    private String name;
    private String note;
    private boolean Completed;
    private Date deadline;
    private Date createdAt;
    private Date modifiedAt;
    
    // construtor

    public Note(int id, int idProject, String name, String note, boolean Completed, Date deadline, Date createdAt, Date modifiedAt) {
        this.id = id;
        this.idProject = idProject;
        this.name = name;
        this.note = note;
        this.Completed = Completed;
        this.deadline = deadline;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
    
    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String description) {
        this.note = description;
    }
    
    public boolean isCompleted() {
        return Completed;
    }

    public void setCompleted(boolean isCompleted) {
        this.Completed = isCompleted;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @Override
    public String toString() {
        return "Note{" + "id=" + id + ", idProject=" + idProject + ", name=" + name + ", note=" + note + ", Completed=" + Completed + ", deadline=" + deadline + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt + '}';
    }

    
    
    
    
      
}
