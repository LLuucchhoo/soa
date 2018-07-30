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
import sv.edu.udb.soa.entidades.TipoTransaccion;
import sv.edu.udb.soa.modelos.TipoTransaccionFacade;

/**
 *
 * @author chernandez
 */
@ManagedBean(name = "tipoTransaccionControl")
@ViewScoped
public class TipoTransaccionControl implements Serializable{
    @EJB
    private TipoTransaccionFacade tipoTransaccionFacade;
    private TipoTransaccion tipoTransaccion;
    private List<TipoTransaccion> lstTipoTransaccion;
    private List<TipoTransaccion> lstTpoTransaccionFiltrada;
    
    private String accion;

    @PostConstruct
    public void init() {
        tipoTransaccion = new TipoTransaccion();
        lstTipoTransaccion = new ArrayList<>();
        listarTipos();
    }
    
    public void doAccion(){
        if(accion.equals("MODIFICAR"))
            modificarTpoTransaccion();
        else
            guardarTpoTransaccion();
    }
    
    public void limpiar(){
        tipoTransaccion = new TipoTransaccion();
    }
    
    public void guardarTpoTransaccion(){
        try {
            tipoTransaccionFacade.create(tipoTransaccion);
            lstTipoTransaccion = tipoTransaccionFacade.findAll();
            tipoTransaccion = new TipoTransaccion();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tipo transacción guardada", "Tipo transacción guardada."));
        } catch (Exception e) {
            System.out.println("Error al guardar tipo transacción." + e);
        }
    }
    
    public void modificarTpoTransaccion(){
        try {
            tipoTransaccionFacade.edit(tipoTransaccion);
            lstTipoTransaccion = tipoTransaccionFacade.findAll();
            tipoTransaccion = new TipoTransaccion();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tipo transacción modificada", "Tipo transacción modificada."));
        } catch (Exception e) {
            System.out.println("Error al modificar tipo transacción." + e);
        }
    }
    
    public void borrarTpoTransaccion(){
        try {
            tipoTransaccionFacade.remove(tipoTransaccion);
            lstTipoTransaccion = tipoTransaccionFacade.findAll();
            tipoTransaccion = new TipoTransaccion();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tipo transacción eliminada", "Tipo transacción eliminada."));
        } catch (Exception e) {
            System.out.println("Error al eliminar tipo transacción." + e);
        }
    }
    
    public void listarTipos() {
        lstTipoTransaccion = tipoTransaccionFacade.findAll();
    }
    
    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion TipoTransaccion) {
        this.tipoTransaccion = TipoTransaccion;
    }

    public List<TipoTransaccion> getLstTipoTransaccion() {
        return lstTipoTransaccion;
    }

    public void setLstTipoTransaccion(List<TipoTransaccion> lstTipoTransaccion) {
        this.lstTipoTransaccion = lstTipoTransaccion;
    }

    public List<TipoTransaccion> getLstTpoTransaccionFiltrada() {
        return lstTpoTransaccionFiltrada;
    }

    public void setLstTpoTransaccionFiltrada(List<TipoTransaccion> lstTpoTransaccionFiltrada) {
        this.lstTpoTransaccionFiltrada = lstTpoTransaccionFiltrada;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
    
    
    
}
