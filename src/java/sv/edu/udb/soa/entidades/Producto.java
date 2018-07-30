/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.soa.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author chernandez
 */
@Entity
@Table(name = "PRODUCTO")
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_PRODUCTO")
    private Integer idProducto;
    @Size(max = 150)
    @Column(name = "NO_SERIE")
    private String noSerie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE_PRODUCTO")
    private String nombreProducto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO_PRODUCTO")
    private BigDecimal precioProducto;
    @JoinColumn(name = "ID_LINEA_PRODUCTO", referencedColumnName = "ID_LINEA_PRODUCTO")
    @ManyToOne(optional = false)
    private LineaProducto idLineaProducto;
    @JoinColumn(name = "ID_ESTADO_PRODUCTO", referencedColumnName = "ID_ESTADO_PRODUCTO")
    @ManyToOne(optional = false)
    private EstadoProducto idEstadoProducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private List<ExistenciaProducto> existenciaProductoList;
    @OneToMany(mappedBy = "idProducto")
    private List<Kardex> kardexList;

    public Producto() {
    }

    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(Integer idProducto, String nombreProducto, BigDecimal precioProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNoSerie() {
        return noSerie;
    }

    public void setNoSerie(String noSerie) {
        this.noSerie = noSerie;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public BigDecimal getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(BigDecimal precioProducto) {
        this.precioProducto = precioProducto;
    }

    public LineaProducto getIdLineaProducto() {
        return idLineaProducto;
    }

    public void setIdLineaProducto(LineaProducto idLineaProducto) {
        this.idLineaProducto = idLineaProducto;
    }

    public EstadoProducto getIdEstadoProducto() {
        return idEstadoProducto;
    }

    public void setIdEstadoProducto(EstadoProducto idEstadoProducto) {
        this.idEstadoProducto = idEstadoProducto;
    }

    public List<ExistenciaProducto> getExistenciaProductoList() {
        return existenciaProductoList;
    }

    public void setExistenciaProductoList(List<ExistenciaProducto> existenciaProductoList) {
        this.existenciaProductoList = existenciaProductoList;
    }

    public List<Kardex> getKardexList() {
        return kardexList;
    }

    public void setKardexList(List<Kardex> kardexList) {
        this.kardexList = kardexList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.soa.modelos.Producto[ idProducto=" + idProducto + " ]";
    }
    
}
