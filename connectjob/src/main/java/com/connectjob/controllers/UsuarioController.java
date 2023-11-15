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

import com.connectjob.model.Usuario;
import com.connectjob.services.UsuarioServices;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioServices usuarioServices;
	
	//Listar
	@GetMapping
	public String listaUsuarios(Model model) {
		List<Usuario> usuarios = usuarioServices.getAllUsuarios();
		model.addAttribute("usuarios", usuarios);
		return "ListarUsuarios";
	}
	
	//formulario de cadastro
	@GetMapping("/novo")
	public String formCadastroUsuario(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "cadastro.html";
	}
	
	//inserir dados do cadastro no banco de dados
	@GetMapping("/save")
	public String cadastrarUsuario(@ModelAttribute("usuario") Usuario usuario) {
		usuarioServices.saveUsuario(usuario);
		return "redirect:/usuario/novo";
	}
	
	//formulario de ediçao
	@GetMapping("/editar/{id}")
	public String formEditarUsuario(@PathVariable Long id, Model model) {
		Usuario usuario = usuarioServices.getUsuarioById(id);
		model.addAttribute("usuario", usuario);
		return "editarUsuario";
	}
	
	//inserir dados do update no banco de dados
	@PostMapping("/editar{id}")
	public String editarUsuario(@PathVariable Long id, @ModelAttribute("usuario") Usuario usuario) {
		usuarioServices.updateUsuario(id, usuario);
		return "redirect:/cadastro";
	}
	
	//deletar usuario
	@GetMapping("/deletar/{id}")
	public String deletarUsuario(@PathVariable Long id) {
		usuarioServices.deleteUsuario(id);
		return "redirect:/cadastro";
	}
}