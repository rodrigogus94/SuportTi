/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Anna Clara e Sophia
 */
@ManagedBean(name="Computador")
@RequestScoped
@Entity
@Table(name = "Computador")
public class Computador implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    
    @Column(name = "Marca", length = 100)
    private String marca;
    
    @Column(name = "Tipo", length = 100)
    private String tipo;
    
    private String data = getDateTime();
    
    @ManyToMany
    private List<Diaginostico> diaginosticos;
    
    @ManyToMany
    private List<Problema> problemas;
    
    public Computador() {
        this.diaginosticos = new ArrayList<>();
        this.problemas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }
    

    public void setId(int id) {
        this.id = id;
    }


    public Computador(String marca, String tipo) {
        this.marca = marca;
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Diaginostico> getDiaginosticos() {
        return diaginosticos;
    }

    public void setDiaginosticos(List<Diaginostico> diaginosticos) {
        this.diaginosticos = diaginosticos;
    }

    public List<Problema> getProblemas() {
        return problemas;
    }

    public void setProblemas(List<Problema> problemas) {
        this.problemas = problemas;
    }

    
    
    public String getDateTime(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return dateFormat.format(date);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    
    
    
    
}
