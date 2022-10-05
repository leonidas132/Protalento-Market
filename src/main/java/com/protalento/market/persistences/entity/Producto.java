package com.protalento.market.persistences.entity;


import javax.persistence.*;
import java.util.List;

/* @Entity le dara a entender a java que esta
clase se comporta como una clase que mapea una entidad enc una base de datos */

/*
*@Table esta anotacion le dara entender a java que esta clase hace referencia a la tabla productos de
* la base de datos
*  */
@Entity
@Table(name = "productos")
public class Producto {


    @Id   // @Id  para especificar que es una clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //para especificar que esta columna es la clave primaria y que es autoincrementable y adicional le dara identidad a los registros que esten en la tabla producto
    @Column(name = "id_producto") // @Column para definir el verdadero nombre de la columna en la base de datos en caso en que este se llame diferente
    private Integer idProducto;

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

    //este atributo nos ayuda a relacionar nuestra tabla categoria con productos
    @ManyToOne  //especifica una relación muchos-a-uno
    @JoinColumn(name = "id_categoria",insertable = false,updatable = false) //atrabes de esta anotacion espesificamos que atravez de esta relacion no vamos insertar ni a actualizar
    private Categoria categoria;

    @OneToMany(mappedBy = "producto")
    private List<ComprasProductos> listar;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<ComprasProductos> getListar() {
        return listar;
    }

    public void setListar(List<ComprasProductos> listar) {
        this.listar = listar;
    }
}
