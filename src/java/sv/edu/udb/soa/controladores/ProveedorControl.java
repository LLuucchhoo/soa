/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.soa.controladores;

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
import sv.edu.udb.soa.modelos.ProveedorFacade;

/**
 *
 * @author chernandez
 */
@ManagedBean(name = "proveedorControl")
@ViewScoped
public class ProveedorControl implements Serializable{
    @EJB
    private ProveedorFacade proveedorFacade;
    
    private Proveedor proveedor;
    private List<Proveedor> lstProveedores;
    private List<Proveedor> lstProveedoresFiltrada;
    private String accion;

    @PostConstruct
    public void init() {        
        proveedor = new Proveedor();
        lstProveedores = new ArrayList<>();
        listarProveedores();
    }
    
    public void limpiar(){
        proveedor = new Proveedor();
    }
    
    private void listarProveedores(){
        lstProveedores = proveedorFacade.findAll();
    }
    
        public void doAccion(){
        if(accion.equals("MODIFICAR"))
            modificarTpoTransaccion();
        else
            guardarTpoTransaccion();
    }

    public void modificarTpoTransaccion(){
        try {
            proveedorFacade.edit(proveedor);
            lstProveedores = proveedorFacade.findAll();
            proveedor = new Proveedor();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Proveedor modificado", "Proveedor modificado."));
        } catch (Exception e) {
            System.out.println("Error al modificar proveedor." + e);
        }
    }
    
    public void guardarTpoTransaccion(){
        try {
            proveedorFacade.create(proveedor);
            lstProveedores = proveedorFacade.findAll();
            proveedor = new Proveedor();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Proveedor guardado", "Proveedor guardado."));
        } catch (Exception e) {
            System.out.println("Error al guardar proveedor." + e);
        }
    }
    
    public void borrarProveedor(){
        try {
            proveedorFacade.remove(proveedor);
            lstProveedores = proveedorFacade.findAll();
            proveedor = new Proveedor();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Proveedor eliminado", "Proveedor eliminado."));
        } catch (Exception e) {
            System.out.println("Error al eliminar proveedor." + e);
        }
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<Proveedor> getLstProveedores() {
        return lstProveedores;
    }

    public void setLstProveedores(List<Proveedor> lstProveedores) {
        this.lstProveedores = lstProveedores;
    }

    public List<Proveedor> getLstProveedoresFiltrada() {
        return lstProveedoresFiltrada;
    }

    public void setLstProveedoresFiltrada(List<Proveedor> lstProveedoresFiltrada) {
        this.lstProveedoresFiltrada = lstProveedoresFiltrada;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    
    
    
}
