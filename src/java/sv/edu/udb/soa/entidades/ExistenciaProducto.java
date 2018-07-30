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
@Table(name = "EXISTENCIA_PRODUCTO")
@NamedQueries({
    @NamedQuery(name = "ExistenciaProducto.findAll", query = "SELECT e FROM ExistenciaProducto e")})
public class ExistenciaProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_EXISTENCIA_PRODUCTO")
    private Integer idExistenciaProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INGRESO")
    private int ingreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EGRESO")
    private int egreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SALDO")
    private int saldo;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne(optional = false)
    private Producto idProducto;

    public ExistenciaProducto() {
    }

    public ExistenciaProducto(Integer idExistenciaProducto) {
        this.idExistenciaProducto = idExistenciaProducto;
    }

    public ExistenciaProducto(Integer idExistenciaProducto, Integer ingreso, Integer egreso, Integer saldo) {
        this.idExistenciaProducto = idExistenciaProducto;
        this.ingreso = ingreso;
        this.egreso = egreso;
        this.saldo = saldo;
    }

    public Integer getIdExistenciaProducto() {
        return idExistenciaProducto;
    }

    public void setIdExistenciaProducto(Integer idExistenciaProducto) {
        this.idExistenciaProducto = idExistenciaProducto;
    }

    public Integer getIngreso() {
        return ingreso;
    }

    public void setIngreso(Integer ingreso) {
        this.ingreso = ingreso;
    }

    public Integer getEgreso() {
        return egreso;
    }

    public void setEgreso(Integer egreso) {
        this.egreso = egreso;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        Integer hash = 0;
        hash += (idExistenciaProducto != null ? idExistenciaProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExistenciaProducto)) {
            return false;
        }
        ExistenciaProducto other = (ExistenciaProducto) object;
        if ((this.idExistenciaProducto == null && other.idExistenciaProducto != null) || (this.idExistenciaProducto != null && !this.idExistenciaProducto.equals(other.idExistenciaProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.soa.modelos.ExistenciaProducto[ idExistenciaProducto=" + idExistenciaProducto + " ]";
    }
    
}
