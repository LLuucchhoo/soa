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
import sv.edu.udb.soa.entidades.Producto;
import sv.edu.udb.soa.modelos.ProductoFacade;

@ManagedBean(name = "productoControl")
@ViewScoped
public class ProductoControl implements Serializable {

    @EJB
    private ProductoFacade productoFacade;
    private Producto producto;
    private List<Producto> lstProducto;
    private List<Producto> lstProductoFiltrada;
    private String accion;

    @PostConstruct
    public void init() {
        producto = new Producto();
        lstProducto = new ArrayList<>();
        listarProducto();
        limpiarProducto();
       
    }

    public void doAccion() {
        if (accion.equals("AGREGAR")) {
            guardarProducto();
        } else {
            modificarProducto();
        }
    }
    public void limpiarProducto(){
        producto = new Producto();
    }

    public void modificarProducto() {
        try {
            productoFacade.edit(producto);
            lstProducto = productoFacade.findAll();
            producto = new Producto();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Linea Producto modificado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la linea del producto " + e);
        }
    }
    public void borrarProducto() {
        try {
            productoFacade.remove(producto);
            lstProducto = productoFacade.findAll();
            producto = new Producto();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Linea de producto borrado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la linea del producto " + e);
        }
    }

    public void guardarProducto() {
        try {
            productoFacade.create(producto);
            lstProducto = productoFacade.findAll();
            producto = new Producto();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Linea de Producto guardado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la linea del producto " + e);
        }
    }

        public void listarProducto() {
        lstProducto = productoFacade.findAll();
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getLstProducto() {
        return lstProducto;
    }

    public void setLstProducto(List<Producto> lstProducto) {
        this.lstProducto = lstProducto;
    }

    public List<Producto> getLstProductoFiltrada() {
        return lstProductoFiltrada;
    }

    public void setLstProductoFiltrada(List<Producto> lstProductoFiltrada) {
        this.lstProductoFiltrada = lstProductoFiltrada;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

}
