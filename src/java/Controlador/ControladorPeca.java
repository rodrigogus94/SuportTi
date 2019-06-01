package Controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import Negocio.Computador;
import Negocio.Peca;
import Repositorio.RepositorioComputador;
import Repositorio.RepositorioPeca;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;


@ManagedBean(name = "ControladorPeca")
@SessionScoped
public class ControladorPeca {

    private RepositorioPeca rp = null;
    private Peca SelectPeca;
    
    

    public Peca getSelectPeca() {
        return SelectPeca;
    }

    public void setSelectPeca(Peca SelectPeca) {
        this.SelectPeca = SelectPeca;
    }

    public ControladorPeca() {
        this.rp = new RepositorioPeca();
        this.SelectPeca = new Peca();
    }

    public String inserirPeca(Peca p){
        this.rp.inserir(p);  
        
        ((ControladorFornecedor)((HttpSession)FacesContext.getCurrentInstance().
                getExternalContext().getSession(true)).getAttribute("ControladorFornecedor")).
                getSelectFornecedor().getPecas().add(p);

        ((ControladorFornecedor)((HttpSession)FacesContext.getCurrentInstance().
                getExternalContext().getSession(true)).getAttribute("ControladorFornecedor")).
                alterarFornecedor(((ControladorFornecedor) ((HttpSession) FacesContext.getCurrentInstance().
                        getExternalContext().getSession(true)).getAttribute("ControladorFornecedor")).
                        getSelectFornecedor());

         
         return "ApresentaPecas.xhtml";
    }
     public void alterarPeca(Peca p){
        this.rp.alterar(p);
    }
   
    public Peca recuperarPeca(int id){
        return this.rp.recuperar(id);
    }
    
    public String deletarPeca(Peca p){
        
        ((ControladorFornecedor)((HttpSession)FacesContext.getCurrentInstance().
                getExternalContext().getSession(true)).getAttribute("ControladorFornecedor")).
                getSelectFornecedor().getPecas().remove(p);

        ((ControladorFornecedor)((HttpSession)FacesContext.getCurrentInstance().
                getExternalContext().getSession(true)).getAttribute("ControladorFornecedor")).
                alterarFornecedor(((ControladorFornecedor) ((HttpSession) FacesContext.getCurrentInstance().
                        getExternalContext().getSession(true)).getAttribute("ControladorFornecedor")).
                        getSelectFornecedor());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ControladorFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         this.rp.deletar(p);
         
         return "ApresentaPecas.xhtml";
    }
    
    public List<Peca> recuperarTodosPeca(){
        return this.rp.recuperarTodos();
    }
}
