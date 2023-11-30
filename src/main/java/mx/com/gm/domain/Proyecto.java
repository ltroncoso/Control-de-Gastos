/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.domain;

import java.io.Serializable;
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

@Data
@Entity
@Table(name = "proyecto")
public class Proyecto implements Serializable{
    
    private static final long serialVersionUID=1L; 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProyecto;
    
    @NotEmpty
    @Column(name = "numero_proyecto")
    private String numeroProyecto;
   
    @Column(name = "descripcion")
    private String descripcion;
    
    
    @JoinColumn(name="id_cliente")
    @ManyToOne  
    private Cliente cliente;
    
 
    @Column(name = "presupuesto")
    private Double presupuesto;
     
     @Column(name="gasto")
     private Double gasto;

    
    
}
