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
@Table(name = "PROVEEDOR")
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p")})
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_PROVEEDOR")
    private Integer idProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "NOMBRE_PROVEEDOR")
    private String nombreProveedor;
    @Size(max = 20)
    @Column(name = "NIT_PROVEEDOR")
    private String nitProveedor;
    @Size(max = 250)
    @Column(name = "OBSERVACION_PROVEEDOR")
    private String observacionProveedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProveedor")
    private List<Compra> compraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProveedor")
    private List<RepresentanteXProveedor> representanteXProveedorList;

    public Proveedor() {
    }

    public Proveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Proveedor(Integer idProveedor, String nombreProveedor) {
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getNitProveedor() {
        return nitProveedor;
    }

    public void setNitProveedor(String nitProveedor) {
        this.nitProveedor = nitProveedor;
    }

    public String getObservacionProveedor() {
        return observacionProveedor;
    }

    public void setObservacionProveedor(String observacionProveedor) {
        this.observacionProveedor = observacionProveedor;
    }

    public List<Compra> getCompraList() {
        return compraList;
    }

    public void setCompraList(List<Compra> compraList) {
        this.compraList = compraList;
    }

    public List<RepresentanteXProveedor> getRepresentanteXProveedorList() {
        return representanteXProveedorList;
    }

    public void setRepresentanteXProveedorList(List<RepresentanteXProveedor> representanteXProveedorList) {
        this.representanteXProveedorList = representanteXProveedorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProveedor != null ? idProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.idProveedor == null && other.idProveedor != null) || (this.idProveedor != null && !this.idProveedor.equals(other.idProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.soa.modelos.Proveedor[ idProveedor=" + idProveedor + " ]";
    }
    
}
