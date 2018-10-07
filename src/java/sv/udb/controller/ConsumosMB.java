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
import sv.udb.model.Consumo;
import sv.udb.model.Alimento;
import sv.udb.model.facade.ConsumoFacade;
import sv.udb.model.facade.AlimentoFacade;

/**
 *
 * @author Adonay
 */
@Named(value = "consumosMB")
@RequestScoped
public class ConsumosMB {

    /**
     * @return the consumos
     */
    public Consumo getConsumos() {
        return consumos;
    }

    /**
     * @param consumos the consumos to set
     */
    public void setConsumos(Consumo consumos) {
        this.consumos = consumos;
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

    @EJB 
    ConsumoFacade consumosFacade;
    
    @EJB
    AlimentoFacade alimentosFacede;
    
    
    
    private Consumo consumos;
    private Alimento alimentos;
    
    
    
    
    /**
     * Creates a new instance of ConsumosMB
     */
    public ConsumosMB() {
        consumos =  new Consumo();
        alimentos = new Alimento();
        consumos.setIdalimento(alimentos);
    }
    
      public String insert(){
        consumosFacade.create(getConsumos());
        consumos = new Consumo();
        getConsumos().setIdalimento(new Alimento());
        return "Insert Exitoso ";
    }
    
    public List<Consumo> getConsumoList(){
    
    return consumosFacade.findAll();
    
    }
    
    public List<Alimento> getAlimentosList(){
    return alimentosFacede.findAll();
    }
    
    
}
