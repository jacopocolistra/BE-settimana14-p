package it.epicode.be.energy.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import it.epicode.be.energy.model.Comuni;
import it.epicode.be.energy.repository.ComuniRepository;

@Service
public class ComuneService {

	@Autowired
	ComuniRepository comuniRepo;
	
	public Comuni save(Comuni comuni) {
		comuniRepo.save(comuni);
		return comuni;
	}
	public void delete(Long id) {
		comuniRepo.deleteById(id);
	}
	public Comuni update(Long id, Comuni comuni) {
		Optional<Comuni> comuniResult = comuniRepo.findById(id);
		if(comuniResult.isPresent()) {
				Comuni update = comuniResult.get();
		update.setId(comuni.getId());
		update.setNome(comuni.getNome());
	}
		return null;
	}
	public Page<Comuni> findAll(Pageable pageable) {
		return comuniRepo.findById(pageable);

	}
	
	public List<Comuni> findAll() {
		return (List<Comuni>) comuniRepo.findAll();

	}

	public Optional<Comuni> findById(Long id) {
		return comuniRepo.findById(id);
	}
}
