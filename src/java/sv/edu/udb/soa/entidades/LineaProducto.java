/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.soa.entidades;

import java.io.Serializable;
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
@Table(name = "LINEA_PRODUCTO")
@NamedQueries({
    @NamedQuery(name = "LineaProducto.findAll", query = "SELECT l FROM LineaProducto l")})
public class LineaProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_LINEA_PRODUCTO")
    private Integer idLineaProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE_LINEA_PRODUCTO")
    private String nombreLineaProducto;
    @Size(max = 250)
    @Column(name = "OBSERVACION_LINEA_PRODUCTO")
    private String observacionLineaProducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLineaProducto")
    private List<Producto> productoList;
    @JoinColumn(name = "ID_CLASE_PRODUCTO", referencedColumnName = "ID_CLASE_PRODUCTO")
    @ManyToOne(optional = false)
    private ClaseProducto idClaseProducto;

    public LineaProducto() {
    }

    public LineaProducto(Integer idLineaProducto) {
        this.idLineaProducto = idLineaProducto;
    }

    public LineaProducto(Integer idLineaProducto, String nombreLineaProducto) {
        this.idLineaProducto = idLineaProducto;
        this.nombreLineaProducto = nombreLineaProducto;
    }

    public Integer getIdLineaProducto() {
        return idLineaProducto;
    }

    public void setIdLineaProducto(Integer idLineaProducto) {
        this.idLineaProducto = idLineaProducto;
    }

    public String getNombreLineaProducto() {
        return nombreLineaProducto;
    }

    public void setNombreLineaProducto(String nombreLineaProducto) {
        this.nombreLineaProducto = nombreLineaProducto;
    }

    public String getObservacionLineaProducto() {
        return observacionLineaProducto;
    }

    public void setObservacionLineaProducto(String observacionLineaProducto) {
        this.observacionLineaProducto = observacionLineaProducto;
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    public ClaseProducto getIdClaseProducto() {
        return idClaseProducto;
    }

    public void setIdClaseProducto(ClaseProducto idClaseProducto) {
        this.idClaseProducto = idClaseProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLineaProducto != null ? idLineaProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LineaProducto)) {
            return false;
        }
        LineaProducto other = (LineaProducto) object;
        if ((this.idLineaProducto == null && other.idLineaProducto != null) || (this.idLineaProducto != null && !this.idLineaProducto.equals(other.idLineaProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.soa.modelos.LineaProducto[ idLineaProducto=" + idLineaProducto + " ]";
    }
    
}
