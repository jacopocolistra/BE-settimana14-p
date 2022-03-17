package it.epicode.be.energy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.be.energy.model.Cliente;
import it.epicode.be.energy.repository.ClienteRepository;




@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepo;

	public Cliente save(Cliente cliente) {
		clienteRepo.save(cliente);
		return cliente;

	}
	public void delete(Long id) {
		clienteRepo.deleteById(id);
	}
	public Cliente update(Long id, Cliente cliente) {
		Optional<Cliente> clienteResult = clienteRepo.findById(id);
		if(clienteResult.isPresent()) {
			Cliente update = clienteResult.get();
			update.setRegioneSociale(cliente.getRegioneSociale());
			update.setPartitaIva(cliente.getPartitaIva());
			update.setEmail(cliente.getEmail());
			update.setDataInserimento(cliente.getDataInserimento());
			update.setDataUltimoContatto(cliente.getDataUltimoContatto());
			update.setFatturatoAnnuale(cliente.getFatturatoAnnuale());
			update.setPec(cliente.getPec());
			update.setTelefono(cliente.getTelefono());
			update.setEmailContatto(cliente.getEmailContatto());
			update.setNomeContatto(cliente.getNomeContatto());
			update.setCognomeContatto(cliente.getCognomeContatto());
			update.setTelefonoContatto(cliente.getTelefonoContatto());
			return clienteRepo.save(update);
		}
		return null;
		
	}
	

	public Page<Cliente> findAll(Pageable pageable) {
		return clienteRepo.findAll(pageable);

	}
	
	public List<Cliente> findAll() {
		return clienteRepo.findAll();

	}

	public Optional<Cliente> findById(Long id) {
		return clienteRepo.findById(id);
	}
	
}
