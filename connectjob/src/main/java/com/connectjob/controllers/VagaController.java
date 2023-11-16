package com.connectjob.controllers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.connectjob.model.Empresa;
import com.connectjob.model.Vaga;
import com.connectjob.services.EmpresaServices;
import com.connectjob.services.VagaServices;



@Controller
@RequestMapping("/vaga")
public class VagaController {

	@Autowired
	private VagaServices vagaServices;
	
	@Autowired
	private EmpresaServices empresaServices;
	
	//listar vagas
	@GetMapping("/listar")
	public String listarVagas(Model model) {
		List<Vaga> vagas = vagaServices.getAllVaga();
		model.addAttribute("vagas", vagas);
		return "testes/ListarVagas";
	}
	
	//form cadastro
	@GetMapping("/cadastro")
	public String formVaga(Model model) {

		Vaga vaga = new Vaga();

		model.addAttribute("vaga", vaga);
		return "testes/CadastroVaga";
	}
	
	// inserir dados no banco
	@GetMapping("/cadastrar")
	public String cadastrarVaga(@ModelAttribute("vaga") Vaga vaga, @RequestParam Long empresa) {
		vagaServices.saveVaga(vaga);
		return "redirect:/vaga/cadastro";
	}
	
	//formuladrio edicao
	@GetMapping("/editar/{id}")
	public String formEditarVaga(@PathVariable Long id, Model model) {
		Vaga vaga = vagaServices.getVagaById(id);
		model.addAttribute("vaga", vaga);
		return "testes/editarVaga";
	}
	
	//inserir dados no banco
	@PostMapping("/editar/{id}")
	public String editarVaga(@PathVariable Long id, @ModelAttribute("vaga") Vaga vaga ) {
		vagaServices.updateVaga(id, vaga);
		return "redirect:/vaga/listar";
	}
	
	//deletar vaga
	@GetMapping("/deletar/{id}")
	public String deletarVaga(@PathVariable Long id) {
		vagaServices.deleteVaga(id);
		return "redirect:/vaga/listar";
	}
}
