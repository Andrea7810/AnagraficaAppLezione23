package it.softwareInside.AnagraficaAppLezione23.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Persona {

	@Size(min = 5 , max = 5)
	@Id
	private String codiceFiscale;
	
	
	@Min(15)
	private int eta;
	
	
	@NotEmpty
	@NotNull
	private String nome , cognome;
	
	
}
