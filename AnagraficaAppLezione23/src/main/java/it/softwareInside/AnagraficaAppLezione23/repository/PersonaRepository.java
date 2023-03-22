package it.softwareInside.AnagraficaAppLezione23.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.softwareInside.AnagraficaAppLezione23.model.Persona;

public interface PersonaRepository extends CrudRepository<Persona, String>{

	
	
	@Query(value = "SELECT * FROM Persona Where eta > 25" , nativeQuery = true)
	List<Persona> getAllPersoneMaggioriDi25();
	
	
	@Query(value = "SELECT * FROM Persona Where eta > ?1" , nativeQuery = true)
	List<Persona> getAllPersoneMaggiori(int etaInserita);
	
	
	
}
