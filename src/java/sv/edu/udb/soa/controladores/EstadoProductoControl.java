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
import sv.edu.udb.soa.entidades.EstadoProducto;
import sv.edu.udb.soa.modelos.EstadoProductoFacade;

@ManagedBean(name = "estadoProductoControl")
@ViewScoped
public class EstadoProductoControl implements Serializable {

    @EJB
    private EstadoProductoFacade estadoProductoFacade;
    private EstadoProducto estadoProducto;
    private List<EstadoProducto> lstEstadoProducto;
    private List<EstadoProducto> lstEstadoProductoFiltrada;
    private String accion;

    @PostConstruct
    public void init() {
        estadoProducto = new EstadoProducto();
        lstEstadoProducto = new ArrayList<>();
        listarEstadoProducto();
        limpiarEstadoProducto();
       
    }

    public void doAccion() {
        if (accion.equals("AGREGAR")) {
            guardarEstadoProducto();
        } else {
            modificarEstadoProducto();
        }
    }
    public void limpiarEstadoProducto(){
        estadoProducto = new EstadoProducto();
    }

    public void modificarEstadoProducto() {
        try {
            estadoProductoFacade.edit(estadoProducto);
            lstEstadoProducto = estadoProductoFacade.findAll();
            estadoProducto = new EstadoProducto();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Estado Producto modificado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar el estado del producto " + e);
        }
    }
    public void borrarEstadoProducto() {
        try {
            estadoProductoFacade.remove(estadoProducto);
            lstEstadoProducto = estadoProductoFacade.findAll();
            estadoProducto = new EstadoProducto();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Estado de producto borrado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la estado del producto " + e);
        }
    }

    public void guardarEstadoProducto() {
        try {
            estadoProductoFacade.create(estadoProducto);
            lstEstadoProducto = estadoProductoFacade.findAll();
            estadoProducto = new EstadoProducto();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Estado de Producto guardado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la estado del producto " + e);
        }
    }

        public void listarEstadoProducto() {
        lstEstadoProducto = estadoProductoFacade.findAll();
    }

    public EstadoProducto getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(EstadoProducto estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    public List<EstadoProducto> getLstEstadoProducto() {
        return lstEstadoProducto;
    }

    public void setLstEstadoProducto(List<EstadoProducto> lstEstadoProducto) {
        this.lstEstadoProducto = lstEstadoProducto;
    }

    public List<EstadoProducto> getLstEstadoProductoFiltrada() {
        return lstEstadoProductoFiltrada;
    }

    public void setLstEstadoProductoFiltrada(List<EstadoProducto> lstEstadoProductoFiltrada) {
        this.lstEstadoProductoFiltrada = lstEstadoProductoFiltrada;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

}
