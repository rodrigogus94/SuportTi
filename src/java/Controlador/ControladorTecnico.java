/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;


import Negocio.Cliente;
import Negocio.Computador;
import Negocio.Tecnico;
import Repositorio.RepositorioCliente;
import Repositorio.RepositorioComputador;
import Repositorio.RepositorioTecnico;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rodrigo-Casa
 */
@ManagedBean(name = "ControladorTecnico")
@SessionScoped
public class ControladorTecnico {
    
    private RepositorioTecnico rt= null;
    private Tecnico SelectTecnico = null;

    public Tecnico getSelectTecnico() {
        return SelectTecnico;
    }

    public void setSelectTecnico(Tecnico SelectTecnico) {
        this.SelectTecnico = SelectTecnico;
    }
    
    
   
    public ControladorTecnico(){
        this.rt = new RepositorioTecnico();
        
    }

      
    public String inserirTecnico(Tecnico t){
        
        this.rt.inserir(t);
         
         return "ApresentaTecnico.xhtml";
    }
     public String alterarTecnico(Tecnico t){
         
         this.rt.alterar(t);
        
        return "ApresentaTecnico.xhtml";
    }
   
    public Tecnico recuperarTecnico(int id){
        return this.rt.recuperar(id);
    }
    
    public void deletarTecnico(Tecnico t){
        this.rt.deletar(t);
        
    }
    
    public List<Tecnico> recuperarTodosTecnico(){
        return this.rt.recuperarTodos();
    }
    public List<Cliente> recuperarClientes(){
        return this.getSelectTecnico().getCliente();
    }
    
  
}
