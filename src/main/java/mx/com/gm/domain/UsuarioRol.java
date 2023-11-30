/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;




    @Data
    @Entity
    @Table(name="usuario_rol")
public class UsuarioRol implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuarioRol;

    @JoinColumn(name="id_usuario")
    @ManyToOne
    private Usuario usuario;

    @JoinColumn(name="id_rol")
    @ManyToOne
    private Rol rol;
    
        
    }

