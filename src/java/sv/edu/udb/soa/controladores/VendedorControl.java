package sv.edu.udb.soa.controladores;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import sv.edu.udb.soa.entidades.Vendedor;
import sv.edu.udb.soa.entidades.Zona;
import sv.edu.udb.soa.modelos.VendedorFacade;
import sv.edu.udb.soa.modelos.ZonaFacade;


/**
 *
 * @author Liliana
 */
@ManagedBean (name = "vendedorControl")
@ViewScoped
public class VendedorControl {

@EJB
private VendedorFacade vendedorFacade;
 @EJB
private ZonaFacade zonaFacade;
private Vendedor vendedor;
private List<Vendedor> lstVendedores;
private List<Vendedor> lstVendedorFiltrada;
private List<Zona> lstZona;
private String accion;

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public List<Vendedor> getLstVendedorFiltrada() {
        return lstVendedorFiltrada;
    }

    public void setLstVendedorFiltrada(List<Vendedor> lstVendedorFiltrada) {
        this.lstVendedorFiltrada = lstVendedorFiltrada;
    }

    public List<Zona> getLstZona() {
        return lstZona;
    }

    public void setLstZona(List<Zona> lstZona) {
        this.lstZona = lstZona;
    }

@PostConstruct

public void init(){

    vendedor = new Vendedor();
    lstVendedores = new ArrayList<>();
    listarVendedores();
}
    
    public void listarVendedores(){
    lstVendedores = vendedorFacade.findAll();
    }
    
    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public List<Vendedor> getLstVendedores() {
        return lstVendedores;
    }

    public void setLstVendedores(List<Vendedor> lstVendedores) {
        this.lstVendedores = lstVendedores;
    }
    public void doAccion() {
        if (accion.equals("AGREGAR")) {
            guardarVendedor();
        } else {
            modificarVendedor();
        }
    }
    public void limpiarVendedor(){
        vendedor = new Vendedor();
    }
    

    public void modificarVendedor() {
        try {
            vendedorFacade.edit(vendedor);
            lstVendedores = vendedorFacade.findAll();
            vendedor = new Vendedor();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Linea Producto modificado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la linea del producto " + e);
        }
    }
    public void borrarVendedor() {
        try {
            vendedorFacade.remove(vendedor);
            lstVendedores = vendedorFacade.findAll();
            vendedor = new Vendedor();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Linea de producto borrado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la linea del producto " + e);
        }
    }

    public void guardarVendedor() {
        try {
            vendedorFacade.create(vendedor);
            lstVendedores = vendedorFacade.findAll();
            vendedor = new Vendedor();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Linea de Producto guardado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la linea del producto " + e);
        }
    }
}
