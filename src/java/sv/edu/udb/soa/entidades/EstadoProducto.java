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
@Table(name = "ESTADO_PRODUCTO")
@NamedQueries({
    @NamedQuery(name = "EstadoProducto.findAll", query = "SELECT e FROM EstadoProducto e")})
public class EstadoProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
     @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_ESTADO_PRODUCTO")
    private Integer idEstadoProducto;
    @Size(max = 100)
    @Column(name = "NOMBRE_ESTADO_PRODUCTO")
    private String nombreEstadoProducto;
    @Size(max = 250)
    @Column(name = "OBSERVACION_ESTADO_PRODUCTO")
    private String observacionEstadoProducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoProducto")
    private List<Producto> productoList;

    public EstadoProducto() {
    }

    public EstadoProducto(Integer idEstadoProducto) {
        this.idEstadoProducto = idEstadoProducto;
    }

    public Integer getIdEstadoProducto() {
        return idEstadoProducto;
    }

    public void setIdEstadoProducto(Integer idEstadoProducto) {
        this.idEstadoProducto = idEstadoProducto;
    }

    public String getNombreEstadoProducto() {
        return nombreEstadoProducto;
    }

    public void setNombreEstadoProducto(String nombreEstadoProducto) {
        this.nombreEstadoProducto = nombreEstadoProducto;
    }

    public String getObservacionEstadoProducto() {
        return observacionEstadoProducto;
    }

    public void setObservacionEstadoProducto(String observacionEstadoProducto) {
        this.observacionEstadoProducto = observacionEstadoProducto;
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoProducto != null ? idEstadoProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoProducto)) {
            return false;
        }
        EstadoProducto other = (EstadoProducto) object;
        if ((this.idEstadoProducto == null && other.idEstadoProducto != null) || (this.idEstadoProducto != null && !this.idEstadoProducto.equals(other.idEstadoProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.soa.modelos.EstadoProducto[ idEstadoProducto=" + idEstadoProducto + " ]";
    }
    
}
