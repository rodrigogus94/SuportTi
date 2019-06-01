/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Repositorio;

import Negocio.Diaginostico;
import Negocio.Problema;
import dao.DaoManagerHiber;
import java.util.List;

/**
 *
 * @author Ricardo Alves
 */
public class RepositorioProblema implements InterfaceRepositorio.Interface<Problema, String>{

    @Override
    public void inserir(Problema t) {
        DaoManagerHiber.persist(t);
    }

    @Override
    public void alterar(Problema t) {
        DaoManagerHiber.update(t);
    }

    @Override
    public Problema recuperar(int id) {
        return (Problema)DaoManagerHiber.recover("from Acompanhamento where id = " + id);
    }

    @Override
    public void deletar(Problema t) {
        DaoManagerHiber.delete(t);
    }

    @Override
    public List<Problema> recuperarTodos() {
        return DaoManagerHiber.recover("from Acompanhamento");
    }
    
}
