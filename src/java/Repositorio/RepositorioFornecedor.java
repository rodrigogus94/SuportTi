package Repositorio;


import InterfaceRepositorio.Interface;
import Negocio.Fornecedor;
import dao.DaoManagerHiber;
import java.util.List;

public class RepositorioFornecedor implements Interface<Fornecedor, String>{

    

    @Override
    public void inserir(Fornecedor t) {
        DaoManagerHiber.persist(t);
    }

    @Override
    public void alterar(Fornecedor t) {
        DaoManagerHiber.update(t);
    }
    

    @Override
    public Fornecedor recuperar(int id) {
        return (Fornecedor)DaoManagerHiber.recover("from Fornecedor where id ="+ id).get(0);
    }

    @Override
    public void deletar(Fornecedor t) {
       dao.DaoManagerHiber.delete(t);
   
}
    @Override
    public List<Fornecedor> recuperarTodos() {
        return dao.DaoManagerHiber.recover("from Fornecedor");
    }
   
}
