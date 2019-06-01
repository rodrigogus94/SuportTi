package Repositorio;


import InterfaceRepositorio.Interface;
import Negocio.Cliente;
import Negocio.Tecnico;
import dao.DaoManagerHiber;
import java.util.List;

public class RepositorioTecnico implements Interface<Tecnico, String>{

    

    @Override
    public void inserir(Tecnico t) {
        DaoManagerHiber.persist(t);
    }

    @Override
    public void alterar(Tecnico t) {
        DaoManagerHiber.update(t);
    }
    

    @Override
    public Tecnico recuperar(int id) {
        return (Tecnico)DaoManagerHiber.recover("from Tecnico where id ="+ id).get(0);
    }

    @Override
    public void deletar(Tecnico t) {
       dao.DaoManagerHiber.delete(t);
   
}
    @Override
    public List<Tecnico> recuperarTodos() {
        return dao.DaoManagerHiber.recover("from Tecnico");
    }
   
}
