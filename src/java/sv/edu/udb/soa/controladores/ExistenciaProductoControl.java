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
import sv.edu.udb.soa.entidades.Producto;
import sv.edu.udb.soa.entidades.ExistenciaProducto;
import sv.edu.udb.soa.modelos.ProductoFacade;
import sv.edu.udb.soa.modelos.ExistenciaProductoFacade;

@ManagedBean(name = "existenciaProductoControl")
@ViewScoped
public class ExistenciaProductoControl implements Serializable {

    @EJB
    private ExistenciaProductoFacade existenciaProductoFacade;
     @EJB
    private ProductoFacade productoFacade;
    private ExistenciaProducto existenciaProducto;
    private List<ExistenciaProducto> lstExistenciaProducto;
    private List<ExistenciaProducto> lstExistenciaProductoFiltrada;
    private List<Producto> lstProducto;
    private String accion;

    @PostConstruct
    public void init() {
        existenciaProducto = new ExistenciaProducto();
        lstExistenciaProducto = new ArrayList<>();
        lstProducto = new ArrayList<>();
        listarExistenciaProducto();
        listarProducto();
       // limpiarExistenciaProducto();
       
    }
    

    public void doAccion() {
        if (accion.equals("AGREGAR")) {
            guardarExistenciaProducto();
        } else {
            modificarExistenciaProducto();
        }
    }
    public void limpiarExistenciaProducto(){
        existenciaProducto = new ExistenciaProducto();
    }
    

    public void modificarExistenciaProducto() {
        try {
            existenciaProductoFacade.edit(existenciaProducto);
            lstExistenciaProducto = existenciaProductoFacade.findAll();
            existenciaProducto = new ExistenciaProducto();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Linea Producto modificado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la linea del producto " + e);
        }
    }
    public void borrarExistenciaProducto() {
        try {
            existenciaProductoFacade.remove(existenciaProducto);
            lstExistenciaProducto = existenciaProductoFacade.findAll();
            existenciaProducto = new ExistenciaProducto();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Linea de producto borrado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la linea del producto " + e);
        }
    }

    public void guardarExistenciaProducto() {
        try {
            existenciaProductoFacade.create(existenciaProducto);
            lstExistenciaProducto = existenciaProductoFacade.findAll();
            existenciaProducto = new ExistenciaProducto();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Linea de Producto guardado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la linea del producto " + e);
        }
    }
    

        public void listarExistenciaProducto() {
        lstExistenciaProducto = existenciaProductoFacade.findAll();
    }
         

    public ExistenciaProducto getExistenciaProducto(){
        return existenciaProducto;
    }

    public void setExistenciaProducto(ExistenciaProducto existenciaProducto) {
        this.existenciaProducto = existenciaProducto;
    }

    public List<ExistenciaProducto> getLstExistenciaProducto() {
        return lstExistenciaProducto;
    }

    public void setLstExistenciaProducto(List<ExistenciaProducto> lstExistenciaProducto) {
        this.lstExistenciaProducto = lstExistenciaProducto;
    }

    public List<ExistenciaProducto> getLstExistenciaProductoFiltrada() {
        return lstExistenciaProductoFiltrada;
    }

    public void setLstExistenciaProductoFiltrada(List<ExistenciaProducto> lstExistenciaProductoFiltrada) {
        this.lstExistenciaProductoFiltrada = lstExistenciaProductoFiltrada;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    private void listarProducto() {
     lstProducto=productoFacade.findAll();
    }

    public ExistenciaProductoFacade getExistenciaProductoFacade() {
        return existenciaProductoFacade;
    }

    public void setExistenciaProductoFacade(ExistenciaProductoFacade existenciaProductoFacade) {
        this.existenciaProductoFacade = existenciaProductoFacade;
    }

    public ProductoFacade getProductoFacade() {
        return productoFacade;
    }

    public void setProductoFacade(ProductoFacade productoFacade) {
        this.productoFacade = productoFacade;
    }

    public List<Producto> getLstProducto() {
        return lstProducto;
    }

    public void setLstProducto(List<Producto> lstProducto) {
        this.lstProducto = lstProducto;
    }
    

}
