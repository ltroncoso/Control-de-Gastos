/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = "roles")
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
    
    private static final long serialVersionUID=1L; 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    
    @NotEmpty
    @Column(name = "nombre")
    private String nombre;
    
    @NotEmpty
    @Column(name = "apellido")
    private String apellido;
    
    @NotEmpty
    @Column(name = "usuario")
    private String username;
    
    @NotEmpty
    @Column(name = "password")
    private String password;
    
    
    @JoinColumn(name = "id_contacto")
    @ManyToOne(cascade = CascadeType.ALL)
    private Contacto contacto;
    
    @JoinColumn(name = "id_domicilio")
    @ManyToOne(cascade = CascadeType.ALL)
    private Domicilio domicilio;
    
    @JoinColumn(name = "id_departamento")
    @ManyToOne(cascade = CascadeType.ALL)
    private Departamento departamento;
    
    @OneToMany
    @JoinColumn(name="id_usuario")
    private List<UsuarioRol> roles;

    
}
