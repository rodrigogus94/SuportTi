/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Negocio.Computador;
import Repositorio.RepositorioComputador;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;

@ManagedBean(name = "ControladorComputador")
@SessionScoped
public class ControladorComputador {

    private RepositorioComputador rc = null;
    private Computador SelectComputador;

    public Computador getSelectComputador() {
        return SelectComputador;
    }

    public void setSelectComputador(Computador SelectComputador) {
        this.SelectComputador = SelectComputador;
    }

    public ControladorComputador() {
        this.rc = new RepositorioComputador();
        this.SelectComputador = new Computador();
    }

    public String inserirComputador(Computador c) {
        this.rc.inserir(c);

            ((ControladorCliente)((HttpSession)FacesContext.getCurrentInstance().
                    getExternalContext().getSession(true)).getAttribute("ControladorCliente")).
                    getSelectCliente().getComputadores().add(c);

            ((ControladorCliente)((HttpSession)FacesContext.getCurrentInstance().
                    getExternalContext().getSession(true)).getAttribute("ControladorCliente")).
                    alterarCliente(((ControladorCliente) ((HttpSession) FacesContext.getCurrentInstance().
                            getExternalContext().getSession(true)).getAttribute("ControladorCliente")).
                            getSelectCliente());

        return "ApresentaComputador.xhtml";
    }

    public void alterarComputador(Computador c) {
        this.rc.alterar(c);
    }

    public Computador recuperarComputador(int id) {
        return this.rc.recuperar(id);
    }

    public String deletarComputador(Computador c) {
        
        ((ControladorCliente)((HttpSession)FacesContext.getCurrentInstance().
                getExternalContext().getSession(true)).getAttribute("ControladorCliente")).
                getSelectCliente().getComputadores().remove(c);

        ((ControladorCliente) ((HttpSession)FacesContext.getCurrentInstance().
                getExternalContext().getSession(true)).getAttribute("ControladorCliente")).
                alterarCliente(((ControladorCliente) ((HttpSession) FacesContext.getCurrentInstance().
                        getExternalContext().getSession(true)).getAttribute("ControladorCliente")).
                        getSelectCliente());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.rc.deletar(c);
        return "ApresentaComputador.xhtml";
    }

    public List<Computador> recuperarTodosComputador() {
        return this.rc.recuperarTodos();
    }
}
