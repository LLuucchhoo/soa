/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.soa.entidades;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
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
@Table(name = "CLASE_PRODUCTO")
@NamedQueries({
    @NamedQuery(name = "ClaseProducto.findAll", query = "SELECT c FROM ClaseProducto c")})
public class ClaseProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_CLASE_PRODUCTO")
    private Integer idClaseProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE_CLASE_PRODUCTO")
    private String nombreClaseProducto;
    @Size(max = 250)
    @Column(name = "OBSERVACION_CLASE_PRODUCTO")
    private String observacionClaseProducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClaseProducto")
    private List<LineaProducto> lineaProductoList;

    public ClaseProducto() {
    }

    public ClaseProducto(Integer idClaseProducto) {
        this.idClaseProducto = idClaseProducto;
    }

    public ClaseProducto(Integer idClaseProducto, String nombreClaseProducto) {
        this.idClaseProducto = idClaseProducto;
        this.nombreClaseProducto = nombreClaseProducto;
    }

    public Integer getIdClaseProducto() {
        return idClaseProducto;
    }

    public void setIdClaseProducto(Integer idClaseProducto) {
        this.idClaseProducto = idClaseProducto;
    }

    public String getNombreClaseProducto() {
        return nombreClaseProducto;
    }

    public void setNombreClaseProducto(String nombreClaseProducto) {
        this.nombreClaseProducto = nombreClaseProducto;
    }

    public String getObservacionClaseProducto() {
        return observacionClaseProducto;
    }

    public void setObservacionClaseProducto(String observacionClaseProducto) {
        this.observacionClaseProducto = observacionClaseProducto;
    }

    public List<LineaProducto> getLineaProductoList() {
        return lineaProductoList;
    }

    public void setLineaProductoList(List<LineaProducto> lineaProductoList) {
        this.lineaProductoList = lineaProductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClaseProducto != null ? idClaseProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClaseProducto)) {
            return false;
        }
        ClaseProducto other = (ClaseProducto) object;
        if ((this.idClaseProducto == null && other.idClaseProducto != null) || (this.idClaseProducto != null && !this.idClaseProducto.equals(other.idClaseProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.soa.modelos.ClaseProducto[ idClaseProducto=" + idClaseProducto + " ]";
    }
    
}
