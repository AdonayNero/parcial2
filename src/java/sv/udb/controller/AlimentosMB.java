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
import javax.enterprise.context.RequestScoped;

import sv.udb.model.Categoria;
import sv.udb.model.Alimento;
import sv.udb.model.facade.CategoriaFacade;
import sv.udb.model.facade.AlimentoFacade;


/**
 *
 * @author Adonay
 */
@Named(value = "alimentosMB")
@RequestScoped
public class AlimentosMB {

    /**
     * Creates a new instance of AlimentosMB
     */
    
    @EJB
    private AlimentoFacade alimentosFacade;
    
    @EJB
    private CategoriaFacade categoriaFacede;
    
    private Alimento alimentos;
    private Categoria categorias;
    
    
    public AlimentosMB() {
        alimentos = new Alimento();
        categorias = new Categoria();
        alimentos.setIdcategoria(categorias);
    }
     public String insert(){
        alimentosFacade.create(getAlimentos());
        alimentos = new Alimento();
        getAlimentos().setIdcategoria(new Categoria());
        return "";
    }
    
       public List<Alimento> getAlimentosList(){
        return alimentosFacade.findAll();
    }
       
       public List<Categoria> getCategoriasList(){
        return categoriaFacede.findAll();
    }
     
    
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     

    /**
     * @return the alimentosFacade
     */
    public AlimentoFacade getAlimentosFacade() {
        return alimentosFacade;
    }

    /**
     * @param alimentosFacade the alimentosFacade to set
     */
    public void setAlimentosFacade(AlimentoFacade alimentosFacade) {
        this.alimentosFacade = alimentosFacade;
    }

    /**
     * @return the categoriaFacede
     */
    public CategoriaFacade getCategoriaFacede() {
        return categoriaFacede;
    }

    /**
     * @param categoriaFacede the categoriaFacede to set
     */
    public void setCategoriaFacede(CategoriaFacade categoriaFacede) {
        this.categoriaFacede = categoriaFacede;
    }

    /**
     * @return the alimentos
     */
    public Alimento getAlimentos() {
        return alimentos;
    }

    /**
     * @param alimentos the alimentos to set
     */
    public void setAlimentos(Alimento alimentos) {
        this.alimentos = alimentos;
    }

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
    
}
