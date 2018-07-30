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
import sv.edu.udb.soa.entidades.ClaseProducto;
import sv.edu.udb.soa.modelos.ClaseProductoFacade;


@ManagedBean(name = "claseProductoControl")
@ViewScoped
public class ClaseProductoControl implements Serializable {

    @EJB
    private ClaseProductoFacade claseProductoFacade;
    
    private ClaseProducto claseProducto;
    private List<ClaseProducto> lstClaseProducto;
    private List<ClaseProducto> lstClaseProductoFiltrada;
    private String accion;

    @PostConstruct
    public void init() {
        claseProducto = new ClaseProducto();
        lstClaseProducto = new ArrayList<>();
        listarClaseProducto();
       // limpiarClaseProducto();
       
    }

    public void doAccion() {
        if (accion.equals("AGREGAR")) {
            guardarClaseProducto();
        } else {
            modificarClaseProducto();
        }
    }
    public void limpiarClaseProducto(){
        claseProducto = new ClaseProducto();
    }
     public void guardarClaseProducto() {
        try {
            claseProductoFacade.create(claseProducto);
            lstClaseProducto = claseProductoFacade.findAll();
            claseProducto = new ClaseProducto();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Clase de Producto guardado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la clase del producto " + e);
        }
    }


    public void modificarClaseProducto() {
        try {
            claseProductoFacade.edit(claseProducto);
            lstClaseProducto = claseProductoFacade.findAll();
            claseProducto = new ClaseProducto();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Clase Producto modificado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la clase del producto " + e);
        }
    }
    public void borrarClaseProducto() {
        try {
            claseProductoFacade.remove(claseProducto);
            lstClaseProducto = claseProductoFacade.findAll();
            claseProducto = new ClaseProducto();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Clase de producto borrado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la clase del producto " + e);
        }
    }

   
        public void listarClaseProducto() {
        lstClaseProducto = claseProductoFacade.findAll();
    }

    public ClaseProducto getClaseProducto() {
        return claseProducto;
    }

    public void setClaseProducto(ClaseProducto claseProducto) {
        this.claseProducto = claseProducto;
    }

    public List<ClaseProducto> getLstClaseProducto() {
        return lstClaseProducto;
    }

    public void setLstClaseProducto(List<ClaseProducto> lstClaseProducto) {
        this.lstClaseProducto = lstClaseProducto;
    }

    public List<ClaseProducto> getLstClaseProductoFiltrada() {
        return lstClaseProductoFiltrada;
    }

    public void setLstClaseProductoFiltrada(List<ClaseProducto> lstClaseProductoFiltrada) {
        this.lstClaseProductoFiltrada = lstClaseProductoFiltrada;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

}
