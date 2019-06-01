/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Negocio.Diaginostico;
import Negocio.Cliente;
import Repositorio.RepositorioDiaginostico;
import Repositorio.RepositorioCliente;
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
@ManagedBean(name = "ControladorDiaginostico")
@SessionScoped
public class ControladorDiaginostico {

    private RepositorioDiaginostico rd = null;
    private Diaginostico selectDiaginostico = null;

    public ControladorDiaginostico() {
        this.rd = new RepositorioDiaginostico();
    }

    public Diaginostico getSelectDiaginostico() {
        return selectDiaginostico;
    }

    public void setSelectDiaginostico(Diaginostico selectDiaginostico) {
        this.selectDiaginostico = selectDiaginostico;
    }

    public String inserirDiaginostico(Diaginostico d) {
//   
        this.rd.inserir(d);

        ((ControladorComputador) ((HttpSession) FacesContext.getCurrentInstance().
                getExternalContext().getSession(true)).getAttribute("ControladorComputador")).
                getSelectComputador().getDiaginosticos().add(d);

        ((ControladorComputador) ((HttpSession) FacesContext.getCurrentInstance().
                getExternalContext().getSession(true)).getAttribute("ControladorComputador")).
                alterarComputador(((ControladorComputador) ((HttpSession) FacesContext.getCurrentInstance().
                        getExternalContext().getSession(true)).getAttribute("ControladorComputador")).
                        getSelectComputador());

        return "ApresentaComputador.xhtml";

    }

    public String deletarDiaginostico(Diaginostico d) {

        ((ControladorComputador) ((HttpSession) FacesContext.getCurrentInstance().
                getExternalContext().getSession(true)).getAttribute("ControladorComputador")).
                getSelectComputador().getDiaginosticos().remove(d);

        ((ControladorComputador) ((HttpSession) FacesContext.getCurrentInstance().
                getExternalContext().getSession(true)).getAttribute("ControladorComputador")).
                alterarComputador(((ControladorComputador) ((HttpSession) FacesContext.getCurrentInstance().
                        getExternalContext().getSession(true)).getAttribute("ControladorComputador")).
                        getSelectComputador());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.rd.deletar(d);

        return "ApresentaComputador.xhtml";
    }

    public String alterarDiaginostico(Diaginostico d) {
        this.rd.alterar(d);
        return "index.xhtml";
    }

    public Diaginostico recuperarDiaginostico(int id) {
        return this.rd.recuperar(id);
    }

    public List<Diaginostico> recuperarDiaginostico() {
        return this.rd.recuperarTodos();
    }
}
