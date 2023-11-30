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
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "domicilio")
public class Domicilio implements Serializable{
    
    private static final long serialVersionUID=1L; 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDomicilio;
    
    @NotEmpty
    @Column(name="calle")
    private String calle;
    
     @NotEmpty
    @Column(name="no_calle")
    private String noCalle;
     
      @NotEmpty
    @Column(name="localidad")
    private String localidad;
    
    
   
    
}
