package be.vdab.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.persistence.PersistenceException;

import be.vdab.entities.Docent;
import be.vdab.repositories.DocentRepository;

public class DocentService extends AbstractService {
	private final DocentRepository docentRepository = new DocentRepository();
	
	public Optional<Docent> read(long id){
		return docentRepository.read(id);
	}
	
	public void create(Docent docent) {
		beginTransaction();
		try {
			docentRepository.create(docent);
			commit();
		} catch (PersistenceException ex) {
			rollback();
			throw ex;
		}
	}
	
	public void delete(long id) {
		beginTransaction();
		try {
			docentRepository.delete(id);
			commit();
		} catch (PersistenceException ex) {
			rollback();
			throw ex;
		}
	}
	
	public void opslag(long id, BigDecimal percentage) {
		beginTransaction();
		try {
			docentRepository.read(id).ifPresent(docent -> docent.opslag(id, percentage));
			commit();
		} catch (PersistenceException ex) {
			rollback();
			throw ex;
		}
	}
	
	public List<Docent> findByWeddeBetween(BigDecimal van, BigDecimal tot, int vanafRij, int aantalRijen){
		return docentRepository.findByWeddeBetween(van, tot, vanafRij, aantalRijen);
	}
	
	public List<String> findVoornamen() {
		return docentRepository.findVoornamen();
	}
}
