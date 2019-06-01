/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ricardo Alves
 */
@ManagedBean(name = "Diaginostico")
@RequestScoped
    @Entity
    @Table(name = "Diaginostico")
public class Diaginostico implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    
    @Column(name = "data")
    private String data = getDateTime();
    
    private String relatorioDiaginostico;

    public Diaginostico() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getRelatorioDiaginostico() {
        return relatorioDiaginostico;
    }

    public void setRelatorioDiaginostico(String relatorioDiaginostico) {
        this.relatorioDiaginostico = relatorioDiaginostico;
    }
    
    public String getDateTime(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return dateFormat.format(date);
    }
}
