/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Repositorio;

import Negocio.Diaginostico;
import dao.DaoManagerHiber;
import java.util.List;

/**
 *
 * @author Ricardo Alves
 */
public class RepositorioDiaginostico implements InterfaceRepositorio.Interface<Diaginostico, String>{

    @Override
    public void inserir(Diaginostico t) {
        DaoManagerHiber.persist(t);
    }

    @Override
    public void alterar(Diaginostico t) {
        DaoManagerHiber.update(t);
    }

    @Override
    public Diaginostico recuperar(int id) {
        return (Diaginostico)DaoManagerHiber.recover("from Acompanhamento where id = " + id);
    }

    @Override
    public void deletar(Diaginostico t) {
        DaoManagerHiber.delete(t);
    }

    @Override
    public List<Diaginostico> recuperarTodos() {
        return DaoManagerHiber.recover("from Acompanhamento");
    }
    
}
