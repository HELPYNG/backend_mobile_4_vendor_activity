package br.org.unisenaipr.comercial.subgrupo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.org.unisenaipr.comercial.grupo.entity.Grupo;
import br.org.unisenaipr.comercial.grupo.service.GrupoService;
import br.org.unisenaipr.comercial.subgrupo.entity.SubGrupo;
import br.org.unisenaipr.comercial.subgrupo.service.SubGrupoService;

@Controller
@RequestMapping("/subgrupo")
public class SubGrupoController {
	
	private final SubGrupoService subGrupoService;
	private final GrupoService grupoService;

	public SubGrupoController(SubGrupoService subGrupoService, GrupoService grupoService) {
		this.subGrupoService = subGrupoService;
		this.grupoService = grupoService;
	}

	@PostMapping("/subGrupoIndex")
	public String subGrupoIndex(Model theModel) {
		List<SubGrupo> list = subGrupoService.findAll();
		theModel.addAttribute("subgrupo", list);
		return "subgrupo/list";
	}

	@PostMapping("/subgrupoSave")
	public String subGrupoSave(Model theModel) {
		List<Grupo> grupos = grupoService.findAll();
		theModel.addAttribute("grupos", grupos);
		return "subgrupo/cadastro";
	}

	@PostMapping("/save-subgrupo")
	public String saveSubGrupo(@ModelAttribute SubGrupo subgrupo) {
		subGrupoService.saveSubGrupo(subgrupo);
		return "redirect:/subgrupo/subGrupoIndex";
	}		
	
	@GetMapping("/subgrupoUpdate/{id}")
	public String subGrupoUpdate(@PathVariable long id, Model theModel) {
		List<Grupo> grupos = grupoService.findAll();
		SubGrupo subgrupo = subGrupoService.findId(id);
		theModel.addAttribute("grupos", grupos);
		theModel.addAttribute("subgrupo", subgrupo);
		return "subgrupo/alterar";
	}

	@PostMapping("/alterar-subgrupo/{id}")
	public String updateSubGrupo(@ModelAttribute SubGrupo subgrupo) {
		subGrupoService.updateSubGrupo(subgrupo);
		return "redirect:/subgrupo/subGrupoIndex";
	}	

	@GetMapping("/deletar-subgrupo/{id}")
	public String deleteSubGrupo(@PathVariable long id, Model theModel) {
	    SubGrupo subGrupo = subGrupoService.findSubGrupoById(id);
	    subGrupoService.deleteSubGrupo(subGrupo);
	    return "redirect:/subgrupo/grupoIndex";
	}	
}