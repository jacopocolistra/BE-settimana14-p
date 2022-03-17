package it.epicode.be.energy.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Province {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String sigla;
	private String nome;
	private String regione;
	
	@OneToMany(mappedBy = "provincie")
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id" )
	private List<Comuni> comuni;

	@Override
	public String toString() {
		return "Province [id=" + id + ", sigla=" + sigla + ", nome=" + nome + ", regione=" + regione + "]";
	}
	
	
	
}
