package it.epicode.be.energy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import it.epicode.be.energy.model.Comuni;
import it.epicode.be.energy.model.Province;



public interface ProvinceRepository extends CrudRepository<Province, Long>{

	Page<Province> findById(Pageable pageable);

	void save(Comuni comuni);

}
