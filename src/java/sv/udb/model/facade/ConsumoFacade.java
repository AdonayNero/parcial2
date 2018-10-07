/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.udb.model.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.udb.model.Consumo;

/**
 *
 * @author Adonay
 */
@Stateless
public class ConsumoFacade extends AbstractFacade<Consumo> {

    @PersistenceContext(unitName = "NutricionPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConsumoFacade() {
        super(Consumo.class);
    }
    
}
