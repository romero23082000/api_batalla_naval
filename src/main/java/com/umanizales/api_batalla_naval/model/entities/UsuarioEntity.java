package com.umanizales.api_batalla_naval.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "usuario", schema = "public", catalog = "batalla_naval")
public class UsuarioEntity {
    private int id;
    private String correo;
    private String contrasenia;
    private TipoUsuarioEntity tipoUsuarioEntity;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "correo", nullable = false, length = 70)
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Basic
    @Column(name = "contrasenia", nullable = false, length = 10)
    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuarioEntity that = (UsuarioEntity) o;

        if (id != that.id) return false;
        if (correo != null ? !correo.equals(that.correo) : that.correo != null) return false;
        if (contrasenia != null ? !contrasenia.equals(that.contrasenia) : that.contrasenia != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (correo != null ? correo.hashCode() : 0);
        result = 31 * result + (contrasenia != null ? contrasenia.hashCode() : 0);
        return result;
    }



    @ManyToOne
    @JoinColumn(name = "tipo_usuario", referencedColumnName = "codigo", nullable = false)
    public TipoUsuarioEntity getTipoUsuarioEntity() {
        return tipoUsuarioEntity;
    }

    public void setTipoUsuarioEntity(TipoUsuarioEntity tipoUsuarioEntity) {
        this.tipoUsuarioEntity = tipoUsuarioEntity;
    }
}
