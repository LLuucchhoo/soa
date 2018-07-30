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
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import sv.edu.udb.soa.entidades.TipoDocumento;
import sv.edu.udb.soa.modelos.TipoDocumentoFacade;

/**
 *
 * @author chernandez
 */
@ManagedBean(name = "tipoDocumentoControl")
@ViewScoped
public class TipoDocumentoControl implements Serializable{
    @EJB
    private TipoDocumentoFacade tipoDocumentoFacade;
    private TipoDocumento tipoDocumento;
    private List<TipoDocumento> lstTipoDocumento;
    private List<TipoDocumento> lstTipoDocumentoFiltrada;
    private String accion;

    public TipoDocumentoFacade getTipoDocumentoFacade() {
        return tipoDocumentoFacade;
    }

    public void setTipoDocumentoFacade(TipoDocumentoFacade tipoDocumentoFacade) {
        this.tipoDocumentoFacade = tipoDocumentoFacade;
    }

    public List<TipoDocumento> getLstTipoDocumentoFiltrada() {
        return lstTipoDocumentoFiltrada;
    }

    public void setLstTipoDocumentoFiltrada(List<TipoDocumento> lstTipoDocumentoFiltrada) {
        this.lstTipoDocumentoFiltrada = lstTipoDocumentoFiltrada;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
    

    @PostConstruct
    public void init() {
        tipoDocumento = new TipoDocumento();
        lstTipoDocumento = new ArrayList<>();
        listarTipos();
    }
    public void doAccion() {
        if (accion.equals("AGREGAR")) {
            guardarTipoDocumento();
        } else {
            modificarTipoDocumento();
        }
    }
    public void listarTipos() {
        lstTipoDocumento = tipoDocumentoFacade.findAll();
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public List<TipoDocumento> getLstTipoDocumento() {
        return lstTipoDocumento;
    }

    public void setLstTipoDocumento(List<TipoDocumento> lstTipoDocumento) {
        this.lstTipoDocumento = lstTipoDocumento;
    }

    private void guardarTipoDocumento() {
        try {
            tipoDocumentoFacade.create(tipoDocumento);
            lstTipoDocumento = tipoDocumentoFacade.findAll();
            tipoDocumento = new TipoDocumento();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tipo de Documento guardado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar el tipo de documento " + e);
        }
    }

    private void modificarTipoDocumento() {
        try {
            tipoDocumentoFacade.edit(tipoDocumento);
            lstTipoDocumento = tipoDocumentoFacade.findAll();
            tipoDocumento = new TipoDocumento();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tipo Documento modificado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar el tipo de documento " + e);
        }
    }

    
    
}
