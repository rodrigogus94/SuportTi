/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@ManagedBean(name = "Tecnico")
@RequestScoped
@Entity
@Table(name = "Tecnico")
public class Tecnico implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "Nome", length = 100)
    private String nome;

    @Column(name = "CPF", length = 20)
    private String cpf;
            
    @Column(name = "Endereco", length = 100)
    private String endereco;

    @Column(name = "Telefone", length = 20)
    private String telefone;

    @OneToMany
    private List<Cliente> clientes;

  

    public Tecnico() {
        this.clientes = new ArrayList<>();
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Cliente> getCliente() {
        return clientes;
    }

    public void setCliente(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tecnico other = (Tecnico) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }



}
