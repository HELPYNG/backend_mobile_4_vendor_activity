package br.org.unisenaipr.comercial.grupo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.unisenaipr.comercial.grupo.entity.Grupo;
import br.org.unisenaipr.comercial.grupo.repositorio.GrupoRepository;

@Service
public class GrupoService {
	private GrupoRepository grupoRepository;
	
	@Autowired
	public GrupoService(GrupoRepository grupoRepository) {
		this.grupoRepository = grupoRepository;
	}

	public Grupo saveGrupo(Grupo grupo) {
		return grupoRepository.save(grupo);
	}

	public Grupo updateGrupo(Grupo grupo) {
		return grupoRepository.save(grupo);
	}
	
	public void deleteGrupo(Grupo grupo) {
		grupoRepository.delete(grupo);
	}
	
	public List<Grupo> findAll() {
		return grupoRepository.findAll();
	}
	
	public Grupo findId(long id) {
		
		Optional<Grupo> obj = grupoRepository.findById(id);
		return obj.get();
	}
}
