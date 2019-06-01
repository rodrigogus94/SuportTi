/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Negocio.Cliente;
import Negocio.Diaginostico;
import Negocio.Problema;
import Repositorio.RepositorioCliente;
import Repositorio.RepositorioDiaginostico;
import Repositorio.RepositorioProblema;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ricardo Alves
 */
@ManagedBean(name = "ControladorProblema")
@SessionScoped
public class ControladorProblema {
    private RepositorioProblema rp = null;
    private Problema selectProblema = null;

    public ControladorProblema() {
        this.rp = new RepositorioProblema();
    }

    public Problema getSelectProblema() {
        return selectProblema;
    }

    public void setSelectProblema(Problema selectProblema) {
        this.selectProblema = selectProblema;
    }
    
    public String inserirProblema(Problema p){
//   
        this.rp.inserir(p);
        
         ((ControladorComputador)((HttpSession)FacesContext.getCurrentInstance().
                 getExternalContext().getSession(true)).getAttribute("ControladorComputador")).
                 getSelectComputador().getProblemas().add(p);
         
         ((ControladorComputador)((HttpSession)FacesContext.getCurrentInstance().
                 getExternalContext().getSession(true)).getAttribute("ControladorComputador")).
                 alterarComputador(((ControladorComputador)((HttpSession)FacesContext.getCurrentInstance().
                 getExternalContext().getSession(true)).getAttribute("ControladorComputador")).
                 getSelectComputador());
       
         
         
         return "ApresentaComputador.xhtml";

    }
    
    public String deletarProblema(Problema p){
        
        ((ControladorComputador)((HttpSession)FacesContext.getCurrentInstance().
                 getExternalContext().getSession(true)).getAttribute("ControladorComputador")).
                 getSelectComputador().getProblemas().remove(p);
         
         ((ControladorComputador)((HttpSession)FacesContext.getCurrentInstance().
                 getExternalContext().getSession(true)).getAttribute("ControladorComputador")).
                 alterarComputador(((ControladorComputador)((HttpSession)FacesContext.getCurrentInstance().
                 getExternalContext().getSession(true)).getAttribute("ControladorComputador")).
                 getSelectComputador());
         
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         this.rp.deletar(p);
         
         return "ApresentaCliente.xhtml";
    }
    
    public String alterarProblema(Problema p){
        this.rp.alterar(p);
        return "index.xhtml";
    }
    
    public Problema recuperarProblema(int id){
        return this.rp.recuperar(id);
    }
    
    public List<Problema> recuperarProblema(){
        return this.rp.recuperarTodos();
    }
}
