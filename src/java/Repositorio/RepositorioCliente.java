package Repositorio;


import InterfaceRepositorio.Interface;
import Negocio.Cliente;
import dao.DaoManagerHiber;
import java.util.List;

public class RepositorioCliente implements Interface<Cliente, String>{

    

    @Override
    public void inserir(Cliente t) {
        DaoManagerHiber.persist(t);
    }

    @Override
    public void alterar(Cliente t) {
        DaoManagerHiber.update(t);
    }
    

    @Override
    public Cliente recuperar(int id) {
        return (Cliente)DaoManagerHiber.recover("from Cliente where id ="+ id).get(0);
    }

    @Override
    public void deletar(Cliente t) {
       dao.DaoManagerHiber.delete(t);
   
}
    @Override
    public List<Cliente> recuperarTodos() {
        return dao.DaoManagerHiber.recover("from Cliente");
    }
   
}
