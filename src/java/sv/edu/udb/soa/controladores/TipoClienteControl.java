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
import sv.edu.udb.soa.entidades.TipoCliente;
import sv.edu.udb.soa.modelos.TipoClienteFacade;



@ManagedBean(name = "tipoClienteControl")
@ViewScoped
public class TipoClienteControl implements Serializable {

    @EJB
    private TipoClienteFacade tipoClienteFacade;
    
    private TipoCliente tipoCliente;
    private List<TipoCliente> lstTipoCliente;
    private List<TipoCliente> lstTipoClienteFiltrada;
    private String accion;

    @PostConstruct
    public void init() {
        tipoCliente = new TipoCliente();
        lstTipoCliente = new ArrayList<>();
        listarTipoCliente();
       // limpiarTipoCliente();
       
    }

    public void doAccion() {
        if (accion.equals("AGREGAR")) {
            guardarTipoCliente();
        } else {
            modificarTipoCliente();
        }
    }
    public void limpiarTipoCliente(){
        tipoCliente = new TipoCliente();
    }
     public void guardarTipoCliente() {
        try {
            tipoClienteFacade.create(tipoCliente);
            lstTipoCliente = tipoClienteFacade.findAll();
            tipoCliente = new TipoCliente();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Clase de Producto guardado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la clase del producto " + e);
        }
    }


    public void modificarTipoCliente() {
        try {
            tipoClienteFacade.edit(tipoCliente);
            lstTipoCliente = tipoClienteFacade.findAll();
            tipoCliente = new TipoCliente();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Clase Producto modificado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la clase del producto " + e);
        }
    }
    public void borrarTipoCliente() {
        try {
            tipoClienteFacade.remove(tipoCliente);
            lstTipoCliente = tipoClienteFacade.findAll();
            tipoCliente = new TipoCliente();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Clase de producto borrado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la clase del producto " + e);
        }
    }

   
        public void listarTipoCliente() {
        lstTipoCliente = tipoClienteFacade.findAll();
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public List<TipoCliente> getLstTipoCliente() {
        return lstTipoCliente;
    }

    public void setLstTipoCliente(List<TipoCliente> lstTipoCliente) {
        this.lstTipoCliente = lstTipoCliente;
    }

    public List<TipoCliente> getLstTipoClienteFiltrada() {
        return lstTipoClienteFiltrada;
    }

    public void setLstTipoClienteFiltrada(List<TipoCliente> lstTipoClienteFiltrada) {
        this.lstTipoClienteFiltrada = lstTipoClienteFiltrada;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

}
