/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Repositorio;

import InterfaceRepositorio.Interface;
import Negocio.Computador;
import dao.DaoManagerHiber;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anna Clara e Sophia
 */
public class RepositorioComputador implements Interface<Computador, String>{
    
   

    @Override
    public void inserir(Computador t) {
        DaoManagerHiber.persist(t);
    }

    @Override
    public void alterar(Computador t) {
        DaoManagerHiber.update(t);
    }

    @Override
    public Computador recuperar(int id) {
        return  (Computador)DaoManagerHiber.recover("from CClasses where id ="+ id).get(0);
    }
    
    
    @Override
    public void deletar(Computador t) {
        DaoManagerHiber.delete(t);
    }
  

    @Override
    public List<Computador> recuperarTodos() {
       return DaoManagerHiber.recover("from CClasses");
    }
    
    
    
}
