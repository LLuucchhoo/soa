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
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import sv.edu.udb.soa.entidades.Kardex;
import sv.edu.udb.soa.modelos.KardexFacade;

/**
 *
 * @author chernandez
 */
@ManagedBean(name = "kardexControl")
@ViewScoped
public class KardexControl implements Serializable{
    @EJB
    private KardexFacade kardexFacade;
    private Kardex kardex;
    private List<Kardex> lstKardex;
    private List<Kardex> lstKardexFiltrada;
    private String accion;

    public List<Kardex> getLstKardexFiltrada() {
        return lstKardexFiltrada;
    }

    public void setLstKardexFiltrada(List<Kardex> lstKardexFiltrada) {
        this.lstKardexFiltrada = lstKardexFiltrada;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public KardexFacade getKardexFacade() {
        return kardexFacade;
    }

    public void setKardexFacade(KardexFacade kardexFacade) {
        this.kardexFacade = kardexFacade;
    }
    
    @PostConstruct
    public void init() {
        kardex = new Kardex();
        lstKardex = new ArrayList<>();
        listarKardex();
        limpiarKardex();
    }

    public void listarKardex() {
        lstKardex = kardexFacade.findAll();
    }


    public Kardex getKardex() {
        return kardex;
    }

    public void setKardex(Kardex kardex) {
        this.kardex = kardex;
    }

    public List<Kardex> getLstKardex() {
        return lstKardex;
    }

    public void setLstKardex(List<Kardex> lstKardex) {
        this.lstKardex = lstKardex;
    }
    public void doAccion() {
        if (accion.equals("AGREGAR")) {
            guardarKardex();
        } else {
            modificarKardex();
        }
    }
    public void limpiarKardex(){
        kardex = new Kardex();
    }

    public void modificarKardex() {
        try {
            kardexFacade.edit(kardex);
            lstKardex = kardexFacade.findAll();
            kardex = new Kardex();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Linea Kardex modificado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la linea del kardex " + e);
        }
    }
    public void borrarKardex() {
        try {
            kardexFacade.remove(kardex);
            lstKardex = kardexFacade.findAll();
            kardex = new Kardex();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Linea de kardex borrado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la linea del kardex " + e);
        }
    }

    public void guardarKardex() {
        try {
            kardexFacade.create(kardex);
            lstKardex = kardexFacade.findAll();
            kardex = new Kardex();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Linea de Kardex guardado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la linea del kardex " + e);
        }
    }

    
}
