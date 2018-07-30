/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.soa.controladores;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import sv.edu.udb.soa.entidades.Proveedor;
import sv.edu.udb.soa.entidades.RepresentanteXProveedor;
import sv.edu.udb.soa.modelos.ProveedorFacade;
import sv.edu.udb.soa.modelos.RepresentanteXProveedorFacade;

@ManagedBean(name = "representanteXProveedorControl")
@ViewScoped
public class RepresentanteXProveedorControl implements Serializable {

    @EJB
    private RepresentanteXProveedorFacade representanteXProveedorFacade;
     @EJB
    private ProveedorFacade proveedorFacade;
    private RepresentanteXProveedor representanteXProveedor;
    private List<RepresentanteXProveedor> lstRepresentanteXProveedor;
    private List<RepresentanteXProveedor> lstRepresentanteXProveedorFiltrada;
    private List<Proveedor> lstProveedor;
    private String accion;

    @PostConstruct
    public void init() {
        representanteXProveedor = new RepresentanteXProveedor();
        lstRepresentanteXProveedor = new ArrayList<>();
        lstProveedor = new ArrayList<>();
        listarRepresentanteXProveedor();
        listarProveedor();
       // limpiarRepresentanteXProveedor();
       
    }
    

    public void doAccion() {
        if (accion.equals("AGREGAR")) {
            guardarRepresentanteXProveedor();
        } else {
            modificarRepresentanteXProveedor();
        }
    }
    public void limpiarRepresentanteXProveedor(){
        representanteXProveedor = new RepresentanteXProveedor();
    }
    

    public void modificarRepresentanteXProveedor() {
        try {
            representanteXProveedorFacade.edit(representanteXProveedor);
            lstRepresentanteXProveedor = representanteXProveedorFacade.findAll();
            representanteXProveedor = new RepresentanteXProveedor();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Linea Producto modificado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la linea del producto " + e);
        }
    }
    public void borrarRepresentanteXProveedor() {
        try {
            representanteXProveedorFacade.remove(representanteXProveedor);
            lstRepresentanteXProveedor = representanteXProveedorFacade.findAll();
            representanteXProveedor = new RepresentanteXProveedor();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Linea de producto borrado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la linea del producto " + e);
        }
    }

    public void guardarRepresentanteXProveedor() {
        try {
            representanteXProveedorFacade.create(representanteXProveedor);
            lstRepresentanteXProveedor = representanteXProveedorFacade.findAll();
            representanteXProveedor = new RepresentanteXProveedor();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Linea de Producto guardado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la linea del producto " + e);
        }
    }
    

        public void listarRepresentanteXProveedor() {
        lstRepresentanteXProveedor = representanteXProveedorFacade.findAll();
    }
         

    public RepresentanteXProveedor getRepresentanteXProveedor(){
        return representanteXProveedor;
    }

    public void setRepresentanteXProveedor(RepresentanteXProveedor representanteXProveedor) {
        this.representanteXProveedor = representanteXProveedor;
    }

    public List<RepresentanteXProveedor> getLstRepresentanteXProveedor() {
        return lstRepresentanteXProveedor;
    }

    public void setLstRepresentanteXProveedor(List<RepresentanteXProveedor> lstRepresentanteXProveedor) {
        this.lstRepresentanteXProveedor = lstRepresentanteXProveedor;
    }

    public List<RepresentanteXProveedor> getLstRepresentanteXProveedorFiltrada() {
        return lstRepresentanteXProveedorFiltrada;
    }

    public void setLstRepresentanteXProveedorFiltrada(List<RepresentanteXProveedor> lstRepresentanteXProveedorFiltrada) {
        this.lstRepresentanteXProveedorFiltrada = lstRepresentanteXProveedorFiltrada;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    private void listarProveedor() {
     lstProveedor=proveedorFacade.findAll();
    }

    public RepresentanteXProveedorFacade getRepresentanteXProveedorFacade() {
        return representanteXProveedorFacade;
    }

    public void setRepresentanteXProveedorFacade(RepresentanteXProveedorFacade representanteXProveedorFacade) {
        this.representanteXProveedorFacade = representanteXProveedorFacade;
    }

    public ProveedorFacade getProveedorFacade() {
        return proveedorFacade;
    }

    public void setProveedorFacade(ProveedorFacade proveedorFacade) {
        this.proveedorFacade = proveedorFacade;
    }

    public List<Proveedor> getLstProveedor() {
        return lstProveedor;
    }

    public void setLstProveedor(List<Proveedor> lstProveedor) {
        this.lstProveedor = lstProveedor;
    }
    

}
