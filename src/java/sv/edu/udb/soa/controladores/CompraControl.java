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
import sv.edu.udb.soa.entidades.Proveedor;
import sv.edu.udb.soa.entidades.Kardex;
import sv.edu.udb.soa.entidades.Compra;
import sv.edu.udb.soa.modelos.ProveedorFacade;
import sv.edu.udb.soa.modelos.KardexFacade;
import sv.edu.udb.soa.modelos.CompraFacade;

/**
 *
 * @author Liliana
 */
@ManagedBean (name = "compraControl")
@ViewScoped
public class CompraControl implements Serializable{

   @EJB
   private CompraFacade compraFacade;
   private Compra compra;
   private List<Compra> lstCompras;
   private KardexFacade kardexFacade;
   private ProveedorFacade proveedorFacade;
   private List<Kardex> lstKardex;
   private List<Proveedor> lstProveedor;
   private String accion;
   private List<Compra> lstCompraFiltrada;

    public List<Compra> getLstCompraFiltrada() {
        return lstCompraFiltrada;
    }

    public void setLstCompraFiltrada(List<Compra> lstCompraFiltrada) {
        this.lstCompraFiltrada = lstCompraFiltrada;
    }

    public List<Kardex> getLstKardex() {
        return lstKardex;
    }

    public void setLstKardex(List<Kardex> lstKardex) {
        this.lstKardex = lstKardex;
    }

    public List<Proveedor> getLstProveedor() {
        return lstProveedor;
    }

    public void setLstProveedor(List<Proveedor> lstProveedor) {
        this.lstProveedor = lstProveedor;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
   @PostConstruct
   public void init(){
       compra = new Compra();
       lstCompras =new ArrayList<>();
       listarCompras();
   }
   
   public void listarCompras(){
   lstCompras = compraFacade.findAll();
   }
   
    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public List<Compra> getLstCompras() {
        return lstCompras;
    }

    public void setLstCompras(List<Compra> lstCompras) {
        this.lstCompras = lstCompras;
    }
    public void doAccion() {
        if (accion.equals("AGREGAR")) {
            guardarCompra();
        } else {
            modificarCompra();
        }
    }
    public void limpiarCompra(){
        compra = new Compra();
    }
    

    public void modificarCompra() {
        try {
            compraFacade.edit(compra);
            lstCompras = compraFacade.findAll();
            compra = new Compra();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Linea Producto modificado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la linea del producto " + e);
        }
    }
    public void borrarCompra() {
        try {
            compraFacade.remove(compra);
            lstCompras = compraFacade.findAll();
            compra = new Compra();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Linea de producto borrado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la linea del producto " + e);
        }
    }

    public void guardarCompra() {
        try {
            compraFacade.create(compra);
            lstCompras = compraFacade.findAll();
            compra = new Compra();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Linea de Producto guardado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la linea del producto " + e);
        }
    }
   
}
