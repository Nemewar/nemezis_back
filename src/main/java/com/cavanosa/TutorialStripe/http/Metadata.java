package com.cavanosa.TutorialStripe.http;

import lombok.ToString;

@ToString
public class Metadata {

    private PedidoDto pedido;

    public PedidoDto getPedido() {
        return pedido;
    }

    public void setPedido(PedidoDto pedido) {
        this.pedido = pedido;
    }
}
