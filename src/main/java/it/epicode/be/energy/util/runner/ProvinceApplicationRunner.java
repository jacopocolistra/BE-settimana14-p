package it.epicode.be.energy.util.runner;

import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;

import it.epicode.be.energy.model.Comuni;

import it.epicode.be.energy.repository.ProvinceRepository;



@Component
public class ProvinceApplicationRunner implements CommandLineRunner {

	@Autowired
	ProvinceRepository provinceRepo;

	@Override
	public void run(String... args) throws Exception {
		
		try (CSVReader csvReader = new CSVReader(new FileReader("province-italiane.csv"));) {
			String[] values = null;
			csvReader.readNext(); 
			while ((values = csvReader.readNext()) != null) {
				
				provinceRepo.save(new Comuni(values[0], values[1]));
			}
		}
	}

}
