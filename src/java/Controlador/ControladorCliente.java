/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Negocio.Cliente;
import Negocio.Computador;
import Repositorio.RepositorioCliente;
import Repositorio.RepositorioComputador;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo-Casa
 */
@ManagedBean(name = "ControladorCliente")
@SessionScoped
public class ControladorCliente {

    private RepositorioCliente rc = null;
    private Cliente SelectCliente = null;

    public Cliente getSelectCliente() {
        return SelectCliente;
    }

    public void setSelectCliente(Cliente SelectCliente) {
        this.SelectCliente = SelectCliente;
    }

    public ControladorCliente() {
        this.rc = new RepositorioCliente();

    }

    public String inserirCliente(Cliente c) {

        this.rc.inserir(c);
        

        ((ControladorTecnico)((HttpSession)FacesContext.getCurrentInstance().
                    getExternalContext().getSession(true)).getAttribute("ControladorTecnico")).
                    getSelectTecnico().getCliente().add(c);

            ((ControladorTecnico)((HttpSession)FacesContext.getCurrentInstance().
                    getExternalContext().getSession(true)).getAttribute("ControladorTecnico")).
                    alterarTecnico(((ControladorTecnico) ((HttpSession) FacesContext.getCurrentInstance().
                            getExternalContext().getSession(true)).getAttribute("ControladorTecnico")).
                            getSelectTecnico());
        return "ApresentaCliente.xhtml";
       
    }

    public String alterarCliente(Cliente c) {

        this.rc.alterar(c);

        return "ApresentaCliente.xhtml";
    }

    public Cliente recuperarCliente(int id) {
        
        
        return this.rc.recuperar(id);
    }

    public void deletarCliente(Cliente c) {
         this.rc.deletar(c);
         ((ControladorTecnico)((HttpSession)FacesContext.getCurrentInstance().
                getExternalContext().getSession(true)).getAttribute("ControladorTecnico")).
                getSelectTecnico().getCliente().remove(c);

        ((ControladorTecnico) ((HttpSession)FacesContext.getCurrentInstance().
                getExternalContext().getSession(true)).getAttribute("ControladorTecnico")).
                alterarTecnico(((ControladorTecnico) ((HttpSession) FacesContext.getCurrentInstance().
                        getExternalContext().getSession(true)).getAttribute("ControladorTecnico")).
                        getSelectTecnico());
    
        
       

    }

    public List<Cliente> recuperarTodosCliente() {
        return this.rc.recuperarTodos();
    }

    public List<Computador> recuperarComputadores() {
        return this.getSelectCliente().getComputadores();
    }

}
