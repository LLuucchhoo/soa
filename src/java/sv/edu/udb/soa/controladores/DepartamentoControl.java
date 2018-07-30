package sv.edu.udb.soa.controladores;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import sv.edu.udb.soa.entidades.Departamento;
import sv.edu.udb.soa.entidades.Zona;
import sv.edu.udb.soa.modelos.DepartamentoFacade;
import sv.edu.udb.soa.modelos.ZonaFacade;


/**
 *
 * @author Liliana
 */
@ManagedBean (name = "departamentoControl")
@ViewScoped
public class DepartamentoControl {

@EJB
private DepartamentoFacade departamentoFacade;
 @EJB
private ZonaFacade zonaFacade;
private Departamento departamento;
private List<Departamento> lstDepartamentoes;
private List<Departamento> lstDepartamentoFiltrada;
private List<Zona> lstZona;
private String accion;

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public List<Departamento> getLstDepartamentoFiltrada() {
        return lstDepartamentoFiltrada;
    }

    public void setLstDepartamentoFiltrada(List<Departamento> lstDepartamentoFiltrada) {
        this.lstDepartamentoFiltrada = lstDepartamentoFiltrada;
    }

    public List<Zona> getLstZona() {
        return lstZona;
    }

    public void setLstZona(List<Zona> lstZona) {
        this.lstZona = lstZona;
    }

@PostConstruct

public void init(){

    departamento = new Departamento();
    lstDepartamentoes = new ArrayList<>();
    listarDepartamentoes();
}
    
    public void listarDepartamentoes(){
    lstDepartamentoes = departamentoFacade.findAll();
    }
    
    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Departamento> getLstDepartamentoes() {
        return lstDepartamentoes;
    }

    public void setLstDepartamentoes(List<Departamento> lstDepartamentoes) {
        this.lstDepartamentoes = lstDepartamentoes;
    }
    public void doAccion() {
        if (accion.equals("AGREGAR")) {
            guardarDepartamento();
        } else {
            modificarDepartamento();
        }
    }
    public void limpiarDepartamento(){
        departamento = new Departamento();
    }
    

    public void modificarDepartamento() {
        try {
            departamentoFacade.edit(departamento);
            lstDepartamentoes = departamentoFacade.findAll();
            departamento = new Departamento();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Linea Producto modificado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la linea del producto " + e);
        }
    }
    public void borrarDepartamento() {
        try {
            departamentoFacade.remove(departamento);
            lstDepartamentoes = departamentoFacade.findAll();
            departamento = new Departamento();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Linea de producto borrado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la linea del producto " + e);
        }
    }

    public void guardarDepartamento() {
        try {
            departamentoFacade.create(departamento);
            lstDepartamentoes = departamentoFacade.findAll();
            departamento = new Departamento();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Linea de Producto guardado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la linea del producto " + e);
        }
    }
}
