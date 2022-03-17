package it.epicode.be.energy.model;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Comuni {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	
	
	@OneToOne(mappedBy  = "comuni")
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id" )
	private Comuni comuni;


	@Override
	public String toString() {
		return "Comuni [id=" + id + ", nome=" + nome + "]";
	}


	public Comuni(String string, String string2) {

	}


}




