
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
import sv.edu.udb.soa.entidades.Cliente;
import sv.edu.udb.soa.entidades.Kardex;
import sv.edu.udb.soa.entidades.Venta;
import sv.edu.udb.soa.modelos.ClienteFacade;
import sv.edu.udb.soa.modelos.KardexFacade;
import sv.edu.udb.soa.modelos.VentaFacade;

/**
 *
 * @author Liliana
 */
@ManagedBean (name = "ventaControl")
@ViewScoped
public class VentaControl implements Serializable{

   @EJB
   private VentaFacade ventaFacade;
   private Venta venta;
   private List<Venta> lstVentas;
   private KardexFacade kardexFacade;
   private ClienteFacade clienteFacade;
   private List<Kardex> lstKardex;
   private List<Cliente> lstCliente;
   private String accion;
   private List<Venta> lstVentaFiltrada;

    public List<Venta> getLstVentaFiltrada() {
        return lstVentaFiltrada;
    }

    public void setLstVentaFiltrada(List<Venta> lstVentaFiltrada) {
        this.lstVentaFiltrada = lstVentaFiltrada;
    }

    public List<Kardex> getLstKardex() {
        return lstKardex;
    }

    public void setLstKardex(List<Kardex> lstKardex) {
        this.lstKardex = lstKardex;
    }

    public List<Cliente> getLstCliente() {
        return lstCliente;
    }

    public void setLstCliente(List<Cliente> lstCliente) {
        this.lstCliente = lstCliente;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
   @PostConstruct
   public void init(){
       venta = new Venta();
       lstVentas =new ArrayList<>();
       listarVentas();
   }
   
   public void listarVentas(){
   lstVentas = ventaFacade.findAll();
   }
   
    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public List<Venta> getLstVentas() {
        return lstVentas;
    }

    public void setLstVentas(List<Venta> lstVentas) {
        this.lstVentas = lstVentas;
    }
    public void doAccion() {
        if (accion.equals("AGREGAR")) {
            guardarVenta();
        } else {
            modificarVenta();
        }
    }
    public void limpiarVenta(){
        venta = new Venta();
    }
    

    public void modificarVenta() {
        try {
            ventaFacade.edit(venta);
            lstVentas = ventaFacade.findAll();
            venta = new Venta();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Linea Producto modificado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la linea del producto " + e);
        }
    }
    public void borrarVenta() {
        try {
            ventaFacade.remove(venta);
            lstVentas = ventaFacade.findAll();
            venta = new Venta();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Linea de producto borrado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la linea del producto " + e);
        }
    }

    public void guardarVenta() {
        try {
            ventaFacade.create(venta);
            lstVentas = ventaFacade.findAll();
            venta = new Venta();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Linea de Producto guardado", "PrimeFaces Rocks."));
        } catch (Exception e) {
            System.out.println("Error al guardar la linea del producto " + e);
        }
    }
   
}
