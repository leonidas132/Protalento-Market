package com.protalento.market.persistences.entity;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


// construyendo nuestra llave primaria compuesta

@Embeddable
public class ComprasProductoPk implements Serializable {
    private  int pri;
    @Column(name = "id_compra")
    private Integer idCompra;

    @Column(name = "id_producto")
    private Integer idProducto;

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }


}
