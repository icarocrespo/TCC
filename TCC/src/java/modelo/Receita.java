/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author icaro
 */
@Entity
@Table(name = "receita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Receita.findAll", query = "SELECT r FROM Receita r")
    , @NamedQuery(name = "Receita.findById", query = "SELECT r FROM Receita r WHERE r.id = :id")
    , @NamedQuery(name = "Receita.findByCategoria", query = "SELECT r FROM Receita r WHERE r.categoria = :categoria")
    , @NamedQuery(name = "Receita.findByTempoPreparo", query = "SELECT r FROM Receita r WHERE r.tempoPreparo = :tempoPreparo")
    , @NamedQuery(name = "Receita.findByDescricao", query = "SELECT r FROM Receita r WHERE r.descricao = :descricao")
    , @NamedQuery(name = "Receita.findByServe", query = "SELECT r FROM Receita r WHERE r.serve = :serve")})
public class Receita implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "categoria")
    private int categoria;
    @Basic(optional = false)
    @Column(name = "tempo_preparo")
    @Temporal(TemporalType.DATE)
    private Date tempoPreparo;
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "serve")
    private int serve;
    @JoinColumn(name = "subcategoria", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Subcategoria subcategoria;
    @JoinColumn(name = "usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receita")
    private List<Favorito> favoritoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receita")
    private List<Comentario> comentarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receita")
    private List<Medidaingrediente> medidaingredienteList;

    public Receita() {
    }

    public Receita(Integer id) {
        this.id = id;
    }

    public Receita(Integer id, int categoria, Date tempoPreparo, int serve) {
        this.id = id;
        this.categoria = categoria;
        this.tempoPreparo = tempoPreparo;
        this.serve = serve;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public Date getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(Date tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getServe() {
        return serve;
    }

    public void setServe(int serve) {
        this.serve = serve;
    }

    public Subcategoria getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(Subcategoria subcategoria) {
        this.subcategoria = subcategoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public List<Favorito> getFavoritoList() {
        return favoritoList;
    }

    public void setFavoritoList(List<Favorito> favoritoList) {
        this.favoritoList = favoritoList;
    }

    @XmlTransient
    public List<Comentario> getComentarioList() {
        return comentarioList;
    }

    public void setComentarioList(List<Comentario> comentarioList) {
        this.comentarioList = comentarioList;
    }

    @XmlTransient
    public List<Medidaingrediente> getMedidaingredienteList() {
        return medidaingredienteList;
    }

    public void setMedidaingredienteList(List<Medidaingrediente> medidaingredienteList) {
        this.medidaingredienteList = medidaingredienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receita)) {
            return false;
        }
        Receita other = (Receita) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Receita[ id=" + id + " ]";
    }
    
}
