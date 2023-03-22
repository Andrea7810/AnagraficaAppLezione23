package it.softwareInside.AnagraficaAppLezione23.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.softwareInside.AnagraficaAppLezione23.model.Persona;
import it.softwareInside.AnagraficaAppLezione23.repository.PersonaRepository;
import jakarta.validation.Valid;

@Service
public class PersonaService {

	
	@Autowired 
	PersonaRepository personaRepository;
	
	
	
	/**
	 * Prende in input una Persona e torna true se riesce ad aggiungerla al 
	 * database , false se da eccezzione.
	 * @param persona
	 * @return
	 */
	public boolean addPersona (@Valid Persona persona) {
		
		try {
			personaRepository.save(persona);
			return true;
			
		} catch (Exception e) {

			return false;
		}
	}
	
	
	/**
	 * Prende in input un codice fiscale e elimina la persona con quel codice fiscale,
	 * tornando la persona eliminata.
	 * @param codiceFiscale
	 * @return
	 */
	public Persona deletePersonaByCf (@Valid String codiceFiscale) {
		
		try {
			Persona p = personaRepository.findById(codiceFiscale).get();
			personaRepository.deleteById(codiceFiscale);
			return p;
			
		} catch (Exception e) {
			
			return null;
		}
	}
	
	
	
	/**
	 * Prende in input una password, se inserita corretta elimina tutte le persone
	 * dal database e torna true, altrimenti torna false.
	 * @param password
	 * @return
	 */
	public boolean deleteAll (String password) {
		
		String pass = "password1234";
		
		try {
			
			if (password.equals(pass)) {
				
				personaRepository.deleteAll();
				return true;
			} else
				return false;
			
		} catch (Exception e) {
			
			return false;
		}	
	}


	
	
	/**
	 * prende in input una persona e se il codice fiscale risulta presente
	 * aggiorna quella persona con i nuovi parametri
	 * @param persona
	 * @return
	 */
	public boolean updatePersona (@Valid Persona persona) {
		
		return addPersona(persona);
	}
	
	
	
	
	/**
	 * Torna tutte le persone presenti nel database
	 * @return
	 */
	public Iterable<Persona> stampaPersona () {
		
		return personaRepository.findAll();
	}
	
	
	
	
	/**
	 * Prende in input un codice fiscale e trova la persona con lo stesso codice fiscale
	 * ritornandola, se non è presente quel codice fiscale torna null.
	 * @param codiceFiscale
	 * @return
	 */
	public Persona findPeopleByCf (@Valid String codiceFiscale) {
		
		try {
			
			return personaRepository.findById(codiceFiscale).get();
			
		} catch (Exception e) {
			
			return null;
		}
		
	}
	
	
	
	/**
	 * Ritorna una List di persone presenti nel database
	 * che hanno un età superiore ai 25 anni.
	 * @return
	 */
	public List<Persona> allPeopleUp25 () {
		
		try {
			
			return personaRepository.getAllPersoneMaggioriDi25();
			
		} catch (Exception e) {
			return null;
		}
	}
	
	
	
	/**
	 * Ritorna una List di persone presenti nel database
	 * che hanno un età superiore all'età inserita.
	 * 
	 * @param eta
	 * @return
	 */
	public List<Persona> allPeopleUpEta (@Valid int eta) {
		
		try {
			
			return personaRepository.getAllPersoneMaggiori(eta);
			
		} catch (Exception e) {
			return null;
		}
	}
	
	
	
	
	
	
	
}
