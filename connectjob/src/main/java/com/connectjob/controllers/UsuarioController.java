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
import com.connectjob.repositories.UsuarioRepository;
import com.connectjob.services.UsuarioServices;
import com.connectjob.utils.SenhaUtils;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioServices usuarioServices;
	
	private UsuarioRepository usuarioRepository;
	
	//Listar
	@GetMapping("/Listar")
	public String listaUsuarios(Model model) {
		List<Usuario> usuarios = usuarioServices.getAllUsuarios();
		model.addAttribute("usuarios", usuarios);
		return "testes/ListarUsuarios";
	}
	
	// pagina de login 
		@GetMapping("/login")
		public String login(Model model) {		
			return "login";
		}
		
		// página de logado 
		@GetMapping("/logado")
		public String logado(Model model) {		
			return "homelogado";
		}
		
		// página de cursos 
		@GetMapping("/cursos")
		public String cursos(Model model) {		
			return "cursos";
		}
		
		// página de emprego
		@GetMapping("/emprego")
		public String emprego(Model model) {		
			return "emprego";
		}
		
		// página de contatos 
		@GetMapping("/contatos")
		public String contatos(Model model) {		
			return "contatos";
		}	
	
	//formulario de cadastro
	@GetMapping("/cadastro")
	public String formCadastroUsuario(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "cadastro.html";
	}
	
	//inserir dados do cadastro no banco de dados
	@GetMapping("/cadastrar")
	public String cadastrarUsuario(@ModelAttribute("usuario") Usuario usuario) {
		String senhaEncriptada = SenhaUtils.encode(usuario.getSenha());
		usuario.setSenha(senhaEncriptada);
		usuarioServices.saveUsuario(usuario);
		return "redirect:/usuario/cadastro";
	}
	
	//formulario de ediçao
	@GetMapping("/editar/{id}")
	public String formEditarUsuario(@PathVariable Long id, Model model) {
		Usuario usuario = usuarioServices.getUsuarioById(id);
		model.addAttribute("usuario", usuario);
		return "testes/editarUsuario";
	}
	
	//inserir dados do update no banco de dados
	@PostMapping("/editar/{id}")
	public String editarUsuario(@PathVariable Long id, @ModelAttribute("usuario") Usuario usuario) {
		String senhaAtual = usuarioRepository.getOne(id).getSenha();
		usuario.setSenha(senhaAtual);
		usuarioServices.updateUsuario(id, usuario);
		return "redirect:/usuario/Listar";
	}
	
	//deletar usuario
	@GetMapping("/deletar/{id}")
	public String deletarUsuario(@PathVariable Long id) {
		usuarioServices.deleteUsuario(id);
		return "redirect:/cadastro";
	}
}
