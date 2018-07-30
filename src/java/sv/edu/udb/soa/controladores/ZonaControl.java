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
import sv.edu.udb.soa.entidades.Zona;
import sv.edu.udb.soa.modelos.ZonaFacade;

/**
 *
 * @author Liliana
 */
@ManagedBean (name="zonaControl")
@ViewScoped

public class ZonaControl implements Serializable{

@EJB
private ZonaFacade zonaFacade;

private Zona zona;
private List<Zona> lstZona;
private List<Zona> lstZonaFiltrada;
private String accion;

    public List<Zona> getLstZonaFiltrada() {
        return lstZonaFiltrada;
    }

    public void setLstZonaFiltrada(List<Zona> lstZonaFiltrada) {
        this.lstZonaFiltrada = lstZonaFiltrada;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

@PostConstruct
public void init(){
   zona = new Zona();
   lstZona = new ArrayList<>();
   listarZona();
}

    public void listarZona(){
      lstZona = zonaFacade.findAll();
    }
    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public List<Zona> getLstZona() {
        return lstZona;
    }

    public void setLstZona(List<Zona> lstZona) {
        this.lstZona = lstZona;
    }
    public void doAccion() {
        if (accion.equals("AGREGAR")) {
            guardarZona();
        } else {
            modificarZona();
        }
    }
    public void limpiarZona(){
        zona = new Zona();
    }
     public void guardarZona() {
        try {
            zonaFacade.create(zona);
            lstZona = zonaFacade.findAll();
            zona = new Zona();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Clase de Producto guardado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la clase del producto " + e);
        }
    }


    public void modificarZona() {
        try {
            zonaFacade.edit(zona);
            lstZona = zonaFacade.findAll();
            zona = new Zona();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Clase Producto modificado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la clase del producto " + e);
        }
    }
    public void borrarZona() {
        try {
            zonaFacade.remove(zona);
            lstZona = zonaFacade.findAll();
            zona = new Zona();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Clase de producto borrado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la clase del producto " + e);
        }
    }
}
