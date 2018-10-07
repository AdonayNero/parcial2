/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.udb.controller;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import sv.udb.model.Categoria;
import sv.udb.model.facade.CategoriaFacade;

/**
 *
 * @author Adonay
 */
@Named(value = "categoriasMB")
@RequestScoped
public class CategoriasMB {

    /**
     * @return the categorias
     */
    public Categoria getCategorias() {
        return categorias;
    }

    /**
     * @param categorias the categorias to set
     */
    public void setCategorias(Categoria categorias) {
        this.categorias = categorias;
    }

       @EJB
    CategoriaFacade categoriasFacade;
       
      private Categoria categorias;
    
    
    /**
     * Creates a new instance of CategoriasMB
     */
    public CategoriasMB() {
         categorias = new Categoria();
        
    }
     public String insert(){
        categoriasFacade.create(getCategorias());
        categorias = new Categoria();
        
        return "";
    }
     
     
      public List<Categoria> getCategoriasList(){
        return categoriasFacade.findAll();
    }
    
    //pras
    
}
