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
@Table(name = "REPRESENTANTE_X_PROVEEDOR")
@NamedQueries({
    @NamedQuery(name = "RepresentanteXProveedor.findAll", query = "SELECT r FROM RepresentanteXProveedor r")})
public class RepresentanteXProveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_REPRESENTANTE_X_PROVEEDOR")
    private Integer idRepresentanteXProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE_REPRESENTANTE_PROVEEDOR")
    private String nombreRepresentanteProveedor;
    @Size(max = 20)
    @Column(name = "TELEFONO_REPRESENTANTE_PROVEEDOR")
    private String telefonoRepresentanteProveedor;
    @JoinColumn(name = "ID_PROVEEDOR", referencedColumnName = "ID_PROVEEDOR")
    @ManyToOne(optional = false)
    private Proveedor idProveedor;

    public RepresentanteXProveedor() {
    }

    public RepresentanteXProveedor(Integer idRepresentanteXProveedor) {
        this.idRepresentanteXProveedor = idRepresentanteXProveedor;
    }

    public RepresentanteXProveedor(Integer idRepresentanteXProveedor, String nombreRepresentanteProveedor) {
        this.idRepresentanteXProveedor = idRepresentanteXProveedor;
        this.nombreRepresentanteProveedor = nombreRepresentanteProveedor;
    }

    public Integer getIdRepresentanteXProveedor() {
        return idRepresentanteXProveedor;
    }

    public void setIdRepresentanteXProveedor(Integer idRepresentanteXProveedor) {
        this.idRepresentanteXProveedor = idRepresentanteXProveedor;
    }

    public String getNombreRepresentanteProveedor() {
        return nombreRepresentanteProveedor;
    }

    public void setNombreRepresentanteProveedor(String nombreRepresentanteProveedor) {
        this.nombreRepresentanteProveedor = nombreRepresentanteProveedor;
    }

    public String getTelefonoRepresentanteProveedor() {
        return telefonoRepresentanteProveedor;
    }

    public void setTelefonoRepresentanteProveedor(String telefonoRepresentanteProveedor) {
        this.telefonoRepresentanteProveedor = telefonoRepresentanteProveedor;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRepresentanteXProveedor != null ? idRepresentanteXProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RepresentanteXProveedor)) {
            return false;
        }
        RepresentanteXProveedor other = (RepresentanteXProveedor) object;
        if ((this.idRepresentanteXProveedor == null && other.idRepresentanteXProveedor != null) || (this.idRepresentanteXProveedor != null && !this.idRepresentanteXProveedor.equals(other.idRepresentanteXProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.soa.modelos.RepresentanteXProveedor[ idRepresentanteXProveedor=" + idRepresentanteXProveedor + " ]";
    }
    
}
