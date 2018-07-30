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
import sv.edu.udb.soa.entidades.ClaseProducto;
import sv.edu.udb.soa.entidades.LineaProducto;
import sv.edu.udb.soa.modelos.ClaseProductoFacade;
import sv.edu.udb.soa.modelos.LineaProductoFacade;

@ManagedBean(name = "lineaProductoControl")
@ViewScoped
public class LineaProductoControl implements Serializable {

    @EJB
    private LineaProductoFacade lineaProductoFacade;
     @EJB
    private ClaseProductoFacade claseProductoFacade;
    private LineaProducto lineaProducto;
    private List<LineaProducto> lstLineaProducto;
    private List<LineaProducto> lstLineaProductoFiltrada;
    private List<ClaseProducto> lstClaseProducto;
    private String accion;

    @PostConstruct
    public void init() {
        lineaProducto = new LineaProducto();
        lstLineaProducto = new ArrayList<>();
        lstClaseProducto = new ArrayList<>();
        listarLineaProducto();
        listarClaseProducto();
       // limpiarLineaProducto();
       
    }
    

    public void doAccion() {
        if (accion.equals("AGREGAR")) {
            guardarLineaProducto();
        } else {
            modificarLineaProducto();
        }
    }
    public void limpiarLineaProducto(){
        lineaProducto = new LineaProducto();
    }
    

    public void modificarLineaProducto() {
        try {
            lineaProductoFacade.edit(lineaProducto);
            lstLineaProducto = lineaProductoFacade.findAll();
            lineaProducto = new LineaProducto();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Linea Producto modificado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la linea del producto " + e);
        }
    }
    public void borrarLineaProducto() {
        try {
            lineaProductoFacade.remove(lineaProducto);
            lstLineaProducto = lineaProductoFacade.findAll();
            lineaProducto = new LineaProducto();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Linea de producto borrado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la linea del producto " + e);
        }
    }

    public void guardarLineaProducto() {
        try {
            lineaProductoFacade.create(lineaProducto);
            lstLineaProducto = lineaProductoFacade.findAll();
            lineaProducto = new LineaProducto();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Linea de Producto guardado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la linea del producto " + e);
        }
    }
    

        public void listarLineaProducto() {
        lstLineaProducto = lineaProductoFacade.findAll();
    }
         

    public LineaProducto getLineaProducto(){
        return lineaProducto;
    }

    public void setLineaProducto(LineaProducto lineaProducto) {
        this.lineaProducto = lineaProducto;
    }

    public List<LineaProducto> getLstLineaProducto() {
        return lstLineaProducto;
    }

    public void setLstLineaProducto(List<LineaProducto> lstLineaProducto) {
        this.lstLineaProducto = lstLineaProducto;
    }

    public List<LineaProducto> getLstLineaProductoFiltrada() {
        return lstLineaProductoFiltrada;
    }

    public void setLstLineaProductoFiltrada(List<LineaProducto> lstLineaProductoFiltrada) {
        this.lstLineaProductoFiltrada = lstLineaProductoFiltrada;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    private void listarClaseProducto() {
     lstClaseProducto=claseProductoFacade.findAll();
    }

    public LineaProductoFacade getLineaProductoFacade() {
        return lineaProductoFacade;
    }

    public void setLineaProductoFacade(LineaProductoFacade lineaProductoFacade) {
        this.lineaProductoFacade = lineaProductoFacade;
    }

    public ClaseProductoFacade getClaseProductoFacade() {
        return claseProductoFacade;
    }

    public void setClaseProductoFacade(ClaseProductoFacade claseProductoFacade) {
        this.claseProductoFacade = claseProductoFacade;
    }

    public List<ClaseProducto> getLstClaseProducto() {
        return lstClaseProducto;
    }

    public void setLstClaseProducto(List<ClaseProducto> lstClaseProducto) {
        this.lstClaseProducto = lstClaseProducto;
    }
    

}
