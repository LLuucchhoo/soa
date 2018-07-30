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
import sv.edu.udb.soa.entidades.Cliente;
import sv.edu.udb.soa.entidades.Municipio;
import sv.edu.udb.soa.entidades.TipoCliente;
import sv.edu.udb.soa.modelos.ClienteFacade;
import sv.edu.udb.soa.modelos.MunicipioFacade;
import sv.edu.udb.soa.modelos.TipoClienteFacade;

/**
 *
 * @author Liliana
 */
@ManagedBean(name = "clienteControl")
@ViewScoped
public class ClienteControl implements Serializable{

  @EJB
  private ClienteFacade clienteFacade;
  
  @EJB
  private TipoClienteFacade tipoClienteFacade;
  
  @EJB
  private MunicipioFacade municipioFacade;
  
  private Cliente cliente;
  private List<Cliente> lstClientes;
  private List<Municipio> lstMunicipios;
  private List<TipoCliente> lstTipoClientes;
  private List<Cliente> lstClientesFilter;
  private String proceso;
   
  
  @PostConstruct
  public void init(){
   cliente = new Cliente();
   lstClientes = new ArrayList<>();
   listarClientes();
   listarTipoCliente();
   listarMunicipios();
  }

   public void listarClientes(){
    lstClientes = clienteFacade.findAll();
   }
   
   public void listarTipoCliente(){
    lstTipoClientes = tipoClienteFacade.findAll();
   }
   
   public void listarMunicipios(){
    lstMunicipios = municipioFacade.findAll();
   }
   
   public void doProcess(){
    if(proceso.equals("AGREGAR"))
    {
     guardarCliente();
    }
    else{
     modificarCliente();
    }
   }
   
   public void guardarCliente(){
       try {
           clienteFacade.create(cliente);
           lstClientes = clienteFacade.findAll();
           cliente = new Cliente();
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente Guardado!!!.", "Mensaje"));
       } catch (Exception e) {
           System.out.println("Registro no puede ser guardado"+e);
       }  
   }
   
   public void modificarCliente(){
       try {
           clienteFacade.edit(cliente);
           lstClientes = clienteFacade.findAll();
           cliente = new Cliente();
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente Actualizado!!!.", "Mensaje"));
       } catch (Exception e) {
           System.out.println("Registro no puede ser modificado"+e);
       }  
   }
   
      public void borrarCliente(){
       try {
           clienteFacade.remove(cliente);
           //lstClientes = clienteFacade.findAll();          
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente eliminado!!!.", "Mensaje"));
       } catch (Exception e) {
           System.out.println("Registro no puede ser eliminado"+e);
       }  
   }
   
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getLstClientes() {
        return lstClientes;
    }

    public void setLstClientes(List<Cliente> lstClientes) {
        this.lstClientes = lstClientes;
    }

    public List<Municipio> getLstMunicipios() {
        return lstMunicipios;
    }

    public void setLstMunicipios(List<Municipio> lstMunicipios) {
        this.lstMunicipios = lstMunicipios;
    }

    public List<TipoCliente> getLstTipoClientes() {
        return lstTipoClientes;
    }

    public void setLstTipoClientes(List<TipoCliente> lstTipoClientes) {
        this.lstTipoClientes = lstTipoClientes;
    }

    public List<Cliente> getLstClientesFilter() {
        return lstClientesFilter;
    }

    public void setLstClientesFilter(List<Cliente> lstClientesFilter) {
        this.lstClientesFilter = lstClientesFilter;
    }
    
     public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }
  
}
