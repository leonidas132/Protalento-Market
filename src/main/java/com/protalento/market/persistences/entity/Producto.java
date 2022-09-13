package com.protalento.market.persistences.entity;

import javax.persistence.*;

/* @Entity le dara a entender a java que esta
clase se comporta como una clase que mapea una entidad enc una base de datos */

@Entity

/*
*@Table esta anotacion le dara entender a java que esta clase hace referencia a la tabla productos de
* la base de datos
*  */
@Table(name = "productos")
public class Producto {
    private  int pri;

    @Id   // @Id  para especificar que es una clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //para especificar que esta columna es la clave primaria y que es autoincrementable
    @Column(name = "id_producto") // @Column para definir el verdadero nombre de la columna en la base de datos en caso en que este se llame diferente
    private Integer idProdcuto;

    private String nombre;

    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    @Column(name = "precio_venta")
    private Float precioVenta;

    @Column(name = "cantidad_stock")
    private Integer cantidadStock;

    private Boolean estado;

    public Integer getIdProdcuto() {
        return idProdcuto;
    }

    public void setIdProdcuto(Integer idProdcuto) {
        this.idProdcuto = idProdcuto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
