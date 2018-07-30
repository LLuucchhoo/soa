package sv.edu.udb.soa.controladores;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import sv.edu.udb.soa.entidades.Municipio;
import sv.edu.udb.soa.entidades.Departamento;
import sv.edu.udb.soa.modelos.MunicipioFacade;
import sv.edu.udb.soa.modelos.DepartamentoFacade;


/**
 *
 * @author Liliana
 */
@ManagedBean (name = "municipioControl")
@ViewScoped
public class MunicipioControl {

@EJB
private MunicipioFacade municipioFacade;
 @EJB
private DepartamentoFacade departamentoFacade;
private Municipio municipio;
private List<Municipio> lstMunicipioes;
private List<Municipio> lstMunicipioFiltrada;
private List<Departamento> lstDepartamento;
private String accion;

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public List<Municipio> getLstMunicipioFiltrada() {
        return lstMunicipioFiltrada;
    }

    public void setLstMunicipioFiltrada(List<Municipio> lstMunicipioFiltrada) {
        this.lstMunicipioFiltrada = lstMunicipioFiltrada;
    }

    public List<Departamento> getLstDepartamento() {
        return lstDepartamento;
    }

    public void setLstDepartamento(List<Departamento> lstDepartamento) {
        this.lstDepartamento = lstDepartamento;
    }

@PostConstruct

public void init(){

    municipio = new Municipio();
    lstMunicipioes = new ArrayList<>();
    listarMunicipioes();
}
    
    public void listarMunicipioes(){
    lstMunicipioes = municipioFacade.findAll();
    }
    
    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public List<Municipio> getLstMunicipioes() {
        return lstMunicipioes;
    }

    public void setLstMunicipioes(List<Municipio> lstMunicipioes) {
        this.lstMunicipioes = lstMunicipioes;
    }
    public void doAccion() {
        if (accion.equals("AGREGAR")) {
            guardarMunicipio();
        } else {
            modificarMunicipio();
        }
    }
    public void limpiarMunicipio(){
        municipio = new Municipio();
    }
    

    public void modificarMunicipio() {
        try {
            municipioFacade.edit(municipio);
            lstMunicipioes = municipioFacade.findAll();
            municipio = new Municipio();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Linea Producto modificado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la linea del producto " + e);
        }
    }
    public void borrarMunicipio() {
        try {
            municipioFacade.remove(municipio);
            lstMunicipioes = municipioFacade.findAll();
            municipio = new Municipio();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Linea de producto borrado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la linea del producto " + e);
        }
    }

    public void guardarMunicipio() {
        try {
            municipioFacade.create(municipio);
            lstMunicipioes = municipioFacade.findAll();
            municipio = new Municipio();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Linea de Producto guardado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la linea del producto " + e);
        }
    }
}
