/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.domain;

import java.io.Serializable;
import java.time.LocalDate;
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
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "viatico")
public class Viatico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idViatico;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha")
    private LocalDate fecha;
    
    @JoinColumn(name = "id_tipo")
    @ManyToOne
    private Tipo tipo;
    
    @JoinColumn(name = "id_proyecto")
    @ManyToOne
    private Proyecto proyecto;
    
    @Column(name = "monto")
    private double monto;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @JoinColumn(name = "id_usuario")
    @ManyToOne
    private Usuario usuario;
            
   
    
    
    
    

}
