/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;


import Negocio.Cliente;
import Negocio.Computador;
import Negocio.Fornecedor;
import Negocio.Peca;
import Repositorio.RepositorioCliente;
import Repositorio.RepositorioComputador;
import Repositorio.RepositorioFornecedor;
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
@ManagedBean(name = "ControladorFornecedor")
@SessionScoped
public class ControladorFornecedor {
    
    private RepositorioFornecedor rf= null;
    private Fornecedor SelectFornecedor = null;

    public Fornecedor getSelectFornecedor() {
        return SelectFornecedor;
    }

    public void setSelectFornecedor(Fornecedor SelectFornecedor) {
        this.SelectFornecedor = SelectFornecedor;
    }
    
    
   
    public ControladorFornecedor(){
        this.rf = new RepositorioFornecedor();
        
    }

      
    public String inserirFornecedor(Fornecedor f){
        
        this.rf.inserir(f);
         
         return "ApresentaFornecedor.xhtml";
    }
     public String alterarFornecedor(Fornecedor f){
         
         this.rf.alterar(f);
        
        return "ApresentaFornecedor.xhtml";
    }
   
    public Fornecedor recuperarFornecedor(int id){
        return this.rf.recuperar(id);
    }
    
    public void deletarFornecedor(Fornecedor f){
        this.rf.deletar(f);
        
    }
    
    public List<Fornecedor> recuperarTodosFornecedor(){
        return this.rf.recuperarTodos();
    }
    public List<Peca> recuperarPecas(){
        return this.getSelectFornecedor().getPecas();
    }
    
  
}
