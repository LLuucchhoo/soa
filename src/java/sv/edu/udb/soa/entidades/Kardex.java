/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.soa.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author chernandez
 */
@Entity
@Table(name = "KARDEX")
@NamedQueries({
    @NamedQuery(name = "Kardex.findAll", query = "SELECT k FROM Kardex k")})
public class Kardex implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
     @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_KARDEX")
    private Integer idKardex;
    @Size(max = 50)
    @Column(name = "TIPO_OPERACION")
    private String tipoOperacion;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "CANTIDAD")
    private Integer cantidad;
    @Column(name = "PRECIO")
    private Long precio;
    @Column(name = "COSTO_PROMEDIO")
    private Long costoPromedio;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "idKardex")
    //private List<Venta> ventaList;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "idKardex")
    //private List<Compra> compraList;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne(optional=false)
    private Producto idProducto;
    @JoinColumn(name = "ID_TIPO_DOCUMENTO", referencedColumnName = "ID_TIPO_DOCUMENTO")
    @ManyToOne(optional=false)
    private TipoDocumento idTipoDocumento;
    @JoinColumn(name = "ID_TIPO_TRANSACCION", referencedColumnName = "ID_TIPO_TRANSACCION")
    @ManyToOne(optional=false)
    private TipoTransaccion idTipoTransaccion;
    
    public Kardex() {
    }

    public Kardex(Integer idKardex) {
        this.idKardex = idKardex;
    }

    public Kardex(Integer idKardex, String tipoOperacion, Date fecha, Integer cantidad, Long precio, Long costoPromedio) {
        this.idKardex = idKardex;
        this.tipoOperacion = tipoOperacion;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.precio = precio;
        this.costoPromedio = costoPromedio;
    }
    
    public Integer getIdKardex() {
        return idKardex;
    }

    public void setIdKardex(Integer idKardex) {
        this.idKardex = idKardex;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public Long getCostoPromedio() {
        return costoPromedio;
    }

    public void setCostoPromedio(Long costoPromedio) {
        this.costoPromedio = costoPromedio;
    }

 

    public TipoTransaccion getIdTipoTransaccion() {
        return idTipoTransaccion;
    }

    public void setIdTipoTransaccion(TipoTransaccion idTipoTransaccion) {
        this.idTipoTransaccion = idTipoTransaccion;
    }

    public TipoDocumento getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(TipoDocumento idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKardex != null ? idKardex.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kardex)) {
            return false;
        }
        Kardex other = (Kardex) object;
        if ((this.idKardex == null && other.idKardex != null) || (this.idKardex != null && !this.idKardex.equals(other.idKardex))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.soa.modelos.Kardex[ idKardex=" + idKardex + " ]";
    }
    
}
