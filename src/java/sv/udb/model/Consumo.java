/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.udb.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adonay
 */
@Entity
@Table(name = "consumo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consumo.findAll", query = "SELECT c FROM Consumo c")
    , @NamedQuery(name = "Consumo.findByIdconsumo", query = "SELECT c FROM Consumo c WHERE c.idconsumo = :idconsumo")
    , @NamedQuery(name = "Consumo.findByFechaHora", query = "SELECT c FROM Consumo c WHERE c.fechaHora = :fechaHora")})
public class Consumo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_consumo")
    private Integer idconsumo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaHora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;
    @JoinColumn(name = "Id_alimento", referencedColumnName = "Id_alimento")
    @ManyToOne(optional = false)
    private Alimento idalimento;

    public Consumo() {
    }

    public Consumo(Integer idconsumo) {
        this.idconsumo = idconsumo;
    }

    public Consumo(Integer idconsumo, Date fechaHora) {
        this.idconsumo = idconsumo;
        this.fechaHora = fechaHora;
    }

    public Integer getIdconsumo() {
        return idconsumo;
    }

    public void setIdconsumo(Integer idconsumo) {
        this.idconsumo = idconsumo;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Alimento getIdalimento() {
        return idalimento;
    }

    public void setIdalimento(Alimento idalimento) {
        this.idalimento = idalimento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconsumo != null ? idconsumo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consumo)) {
            return false;
        }
        Consumo other = (Consumo) object;
        if ((this.idconsumo == null && other.idconsumo != null) || (this.idconsumo != null && !this.idconsumo.equals(other.idconsumo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.udb.model.Consumo[ idconsumo=" + idconsumo + " ]";
    }
    
}
