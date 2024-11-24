package br.org.unisenaipr.comercial.subgrupo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.org.unisenaipr.comercial.subgrupo.entity.SubGrupo;
import br.org.unisenaipr.comercial.subgrupo.repositorio.SubGrupoRepository;

@Service
public class SubGrupoService {
	
	private SubGrupoRepository subGrupoRepository;

	public SubGrupoService(SubGrupoRepository subGrupoRepository) {
		this.subGrupoRepository = subGrupoRepository;
	}

	public List<SubGrupo> findAll() {
		return subGrupoRepository.findAll();
	}
	
	public void saveSubGrupo(SubGrupo subGrupo) {
		subGrupoRepository.save(subGrupo);
	}

	public void updateSubGrupo(SubGrupo subGrupo) {
		subGrupoRepository.save(subGrupo);
	}
	
	public void deleteSubGrupo(SubGrupo subGrupo) {
		subGrupoRepository.delete(subGrupo);
	}
	
	public SubGrupo findSubGrupoById(long id) {
	    return subGrupoRepository.findById(id).orElseThrow();
	}

	public SubGrupo findId(long id) {
		
		Optional<SubGrupo> objSubGrupo = subGrupoRepository.findById(id);
		SubGrupo subGrupo = objSubGrupo.get();
		
		return subGrupo;
	}
}
