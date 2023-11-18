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
import org.springframework.web.bind.annotation.RequestParam;

import com.connectjob.model.Usuario;
import com.connectjob.repositories.UsuarioRepository;
import com.connectjob.services.UsuarioServices;
import com.connectjob.servicesImpl.UsuarioServiceImpl;
import com.connectjob.utils.SenhaUtils;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioServices usuarioServices;
	
	private UsuarioRepository usuarioRepository;
	
	//Home Usuario
	@GetMapping
	public String listaUsuario (Model model) {
		List<Usuario> usuariolocalizado =  usuarioServices.getAllUsuarios();		
		model.addAttribute("usuarios", usuariolocalizado);
		return "homeusuario";
	}
	
	// Visualizar perfil 
	@GetMapping("/visualizar")
	public String visualizarperfil(Model model) {
		List<Usuario> usuariolocalizado =  usuarioServices.getAllUsuarios();		
		model.addAttribute("usuario", usuariolocalizado);
		return "visualizarperfil";
	}
	
	//formulario de cadastro
		@GetMapping("/cadastro")
		public String formCadastroUsuario(Model model) {
			Usuario usuario = new Usuario();
			model.addAttribute("usuario", usuario);
			return "cadastro";
		}
		
		//inserir dados do cadastro no banco de dados
		@PostMapping("/cadastrar")
		public String cadastrarUsuario(@ModelAttribute("usuario") Usuario usuario) {
			String senhaEncriptada = SenhaUtils.encode(usuario.getSenha());
			usuario.setSenha(senhaEncriptada);
			usuarioServices.saveUsuario(usuario);
						
			return "perfilusuario";
		}
		
	//formulario de ediçao
	@GetMapping("/editar/{id}")
	public String formEditarUsuario(@PathVariable Long id, Model model) {
		Usuario usuario = usuarioServices.getUsuarioById(id);
		model.addAttribute("usuario", usuario);
		return "editarUsuario";
	}
	
	//inserir dados do update no banco de dados
	@PostMapping("/editar/{id}")
	public String editarUsuario(@PathVariable Long id, @ModelAttribute("usuario") Usuario usuario) {		
		usuarioServices.updateUsuario(id, usuario);
		return "perfilusuario";
	}
	
	//deletar usuario
	@GetMapping("/deletar/{id}")
	public String deletarUsuario(@PathVariable Long id) {
		usuarioServices.deleteUsuario(id);
		return "index";
	}
}
