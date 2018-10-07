/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.udb.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adonay
 */
@Entity
@Table(name = "alimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alimento.findAll", query = "SELECT a FROM Alimento a")
    , @NamedQuery(name = "Alimento.findByIdalimento", query = "SELECT a FROM Alimento a WHERE a.idalimento = :idalimento")
    , @NamedQuery(name = "Alimento.findByNombre", query = "SELECT a FROM Alimento a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Alimento.findByCalorias", query = "SELECT a FROM Alimento a WHERE a.calorias = :calorias")})
public class Alimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_alimento")
    private Integer idalimento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Calorias")
    private double calorias;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idalimento")
    private Collection<Consumo> consumoCollection;
    @JoinColumn(name = "Id_categoria", referencedColumnName = "Id_categoria")
    @ManyToOne(optional = false)
    private Categoria idcategoria;

    public Alimento() {
    }

    public Alimento(Integer idalimento) {
        this.idalimento = idalimento;
    }

    public Alimento(Integer idalimento, String nombre, double calorias) {
        this.idalimento = idalimento;
        this.nombre = nombre;
        this.calorias = calorias;
    }

    public Integer getIdalimento() {
        return idalimento;
    }

    public void setIdalimento(Integer idalimento) {
        this.idalimento = idalimento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    @XmlTransient
    public Collection<Consumo> getConsumoCollection() {
        return consumoCollection;
    }

    public void setConsumoCollection(Collection<Consumo> consumoCollection) {
        this.consumoCollection = consumoCollection;
    }

    public Categoria getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Categoria idcategoria) {
        this.idcategoria = idcategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idalimento != null ? idalimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alimento)) {
            return false;
        }
        Alimento other = (Alimento) object;
        if ((this.idalimento == null && other.idalimento != null) || (this.idalimento != null && !this.idalimento.equals(other.idalimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.udb.model.Alimento[ idalimento=" + idalimento + " ]";
    }
    
}
