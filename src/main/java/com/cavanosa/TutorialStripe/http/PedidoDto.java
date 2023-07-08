package com.cavanosa.TutorialStripe.http;

import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.List;

@ToString
public class PedidoDto {

    @NotBlank
    private String usuario;

    private List<ArticuloDto> articulos;

    public PedidoDto() {
    }

    public PedidoDto(String usuario) {
        this.usuario = usuario;
    }

    public PedidoDto(String usuario, List<ArticuloDto> articulos) {
        this.usuario = usuario;
        this.articulos = articulos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public List<ArticuloDto> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<ArticuloDto> articulos) {
        this.articulos = articulos;
    }
}
