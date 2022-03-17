package it.epicode.be.energy.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Fattura {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer anno;
	private Date data;
	private BigDecimal importo;
	private Integer numero;
	private String statoFattura;
	
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id" )
	private Cliente cliente;
}
