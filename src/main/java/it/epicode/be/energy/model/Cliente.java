package it.epicode.be.energy.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String regioneSociale;
	private Integer partitaIva;
	private String email;
	private Date dataInserimento;
	private Date dataUltimoContatto;
	private Integer fatturatoAnnuale;
	private String pec;
	private Integer telefono;
	private String emailContatto;
	private String nomeContatto;
	private String cognomeContatto;
	private Integer telefonoContatto;
	
	@ManyToOne
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id" )
	private Cliente cliente;
	
}
