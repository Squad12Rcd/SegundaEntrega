package com.connectjob.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.connectjob.model.Empresa;
import com.connectjob.model.Usuario;
import com.connectjob.services.EmpresaServices;
import com.connectjob.utils.SenhaUtils;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaServices empresaServices;
	
	//Home Empresa
	@GetMapping
	public String listaEmpresa (Model model) {		
		return "HomeEmpresa";
	}
	
	//Listar
	
//	@GetMapping("/listar")
//	public String listarEmpresas(Model model) {
//		List<Empresa> empresa = empresaServices.getAllEmpresa();
//		model.addAttribute("empresa", empresa);
//		return "perfilempresa";
//	}
//	
	
	//Formulario de cadastro
	@GetMapping("/cadastro")
	public String formCadastroEmpresa(Model model) {
		Empresa empresa = new Empresa();
		model.addAttribute("empresa", empresa);
		return "cadastro-empresa";
	}
		
	//inserir dados do cadastro no banco de dados
	@PostMapping("/cadastrar")
	public String cadastrarUsuario(@ModelAttribute("empresa") Empresa empresa) {	
		empresaServices.saveEmpresa(empresa);					
		return "perfilempresa";
	}
	
	
	//formulario de ediçao
	@GetMapping("editar/{id}")
	public String formEditarEmpresa(@PathVariable Long id, Model model) {
		Empresa empresa = empresaServices.getEmpresaById(id);
		model.addAttribute("empresa", empresa);
		return "editarempresa";
	}
	
	//inserir dados do update no banco de dados
	@PostMapping("/editar/{id}")
	public String editarEmpresa(@PathVariable Long id, @ModelAttribute("empresa") Empresa empresa) {
		empresaServices.updateEmpresa(id, empresa);
		return "perfilempresa";
	}

	//deletar empresa
	@GetMapping("/deletar/{id}")
	public String deletarEmpresa(@PathVariable Long id) {
		empresaServices.deleteEmpresa(id);
		return "index";
	}
}
