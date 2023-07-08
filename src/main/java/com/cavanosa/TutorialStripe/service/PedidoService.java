package com.cavanosa.TutorialStripe.service;

import com.cavanosa.TutorialStripe.model.Pedido;
import com.cavanosa.TutorialStripe.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public void save(Pedido order){
        pedidoRepository.save(order);
    }

    public List<Pedido> findAll(){
        return pedidoRepository.findAll();
    }

    public boolean existsById(long id){
        return pedidoRepository.existsById(id);
    }

    public Pedido findOne(long id){
        return pedidoRepository.findById(id).get();
    }

    public void deleteById(long id){
        pedidoRepository.deleteById(id);
    }
}
