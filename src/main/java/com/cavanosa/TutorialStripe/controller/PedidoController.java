package com.cavanosa.TutorialStripe.controller;

import com.cavanosa.TutorialStripe.http.PedidoDto;
import com.cavanosa.TutorialStripe.http.ArticuloDto;
import com.cavanosa.TutorialStripe.model.Articulo;
import com.cavanosa.TutorialStripe.model.Pedido;
import com.cavanosa.TutorialStripe.service.ArticuloService;
import com.cavanosa.TutorialStripe.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/pedido")
@CrossOrigin("*")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @Autowired
    ArticuloService aticuloService;

    @PostMapping("/create")
    public ResponseEntity<?> createPedido(@RequestBody PedidoDto pedidoDto){
        Pedido pedido = new Pedido(pedidoDto.getUsuario());

        Set<Articulo> articulos = new HashSet<>();

        for(ArticuloDto p: pedidoDto.getArticulos()){
            if(aticuloService.existsId(p.getId())){
                Articulo articulo = aticuloService.getById(p.getId()).get();
                articulos.add(articulo);
            }
        }
        pedido.setArticulos(articulos);
        pedidoService.save(pedido);

        return new ResponseEntity("Pedido created", HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Pedido>> listPedidos(){
        List<Pedido> pedidos = pedidoService.findAll();
        return new ResponseEntity(pedidos, HttpStatus.OK);
    }
}
