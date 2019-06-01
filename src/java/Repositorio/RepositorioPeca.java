/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Repositorio;

import InterfaceRepositorio.Interface;
import Negocio.Computador;
import Negocio.Peca;
import dao.DaoManagerHiber;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anna Clara e Sophia
 */
public class RepositorioPeca implements Interface<Peca, String>{
    
   

    @Override
    public void inserir(Peca t) {
        DaoManagerHiber.persist(t);
    }

    @Override
    public void alterar(Peca t) {
        DaoManagerHiber.update(t);
    }

    @Override
    public Peca recuperar(int id) {
        return  (Peca)DaoManagerHiber.recover("from CClasses where id ="+ id).get(0);
    }
    
    
    @Override
    public void deletar(Peca t) {
        DaoManagerHiber.delete(t);
    }
  

    @Override
    public List<Peca> recuperarTodos() {
       return DaoManagerHiber.recover("from CClasses");
    }
    
    
    
}
