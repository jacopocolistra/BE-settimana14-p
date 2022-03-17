package it.epicode.be.energy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import it.epicode.be.energy.model.Province;

import it.epicode.be.energy.repository.ProvinceRepository;

@Service
public class ProvinciaService {

	@Autowired
	ProvinceRepository provinceRepo;

	public Province save(Province province) {
		provinceRepo.save(province);
		return province;

	}
	public void delete(Long id) {
		provinceRepo.deleteById(id);
	}
	
	public Province update(Long id, Province province) {
		Optional<Province> provinceResult = provinceRepo.findById(id);
		if(provinceResult.isPresent()) {
			Province update = provinceResult.get();
			update.setId(province.getId());
			update.setSigla(province.getSigla());
			update.setNome(province.getNome());
			update.setRegione(province.getRegione());
}
		return null;
	}
	public Page<Province> findAll(Pageable pageable) {
		return provinceRepo.findById(pageable);

	}
	
	public List<Province> findAll() {
		return (List<Province>) provinceRepo.findAll();

	}

	public Optional<Province> findById(Long id) {
		return provinceRepo.findById(id);
	}
	
}
