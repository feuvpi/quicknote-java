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
    private String title;
    private String note;
    private Date createdAt;
    private Date modifiedAt;
    
    // construtor

    public Note(int id, String title, String note, Date createdAt, Date modifiedAt) {
        this.id = id;
        this.title = title;
        this.note = note;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
    
    public Note (){
        this.createdAt = new Date();
    }
    
    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
        return "Note{" + "id=" + id + ", title=" + title + ", note=" + note + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt + '}';
    }

    
    
    
    
      
}
