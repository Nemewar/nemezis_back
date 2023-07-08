package com.cavanosa.TutorialStripe.repository;

import com.cavanosa.TutorialStripe.model.Articulo;
import com.cavanosa.TutorialStripe.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
