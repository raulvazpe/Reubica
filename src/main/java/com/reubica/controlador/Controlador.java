package com.reubica.controlador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.reubica.entidad.Perro;
import com.reubica.interfaceService.IperroService;

@Controller
public class Controlador {

	
	
	@Autowired
	private IperroService servicio;
	
	
	@RequestMapping({ "/" })
	public String listarPerros(Model modelo) {
		List<Perro> listaPerros = servicio.listAll();
		modelo.addAttribute("perros", listaPerros);

		return "index";
	}
	
	
	@RequestMapping({ "/administrar/perros"})
	public String listarPerrosAdm(Model modelo) {
		List<Perro> listaPerros = servicio.listAll();
		modelo.addAttribute("perros", listaPerros);

		return "perrosEdit";
	}
	
	
	@GetMapping("/administrar/perros/nuevo")
	public String mostrarFormularioDeRegistro(Model modelo) {
		Perro perro = new Perro();
		modelo.addAttribute("perro", perro);
		return "crearPerros";
	}
	

	@PostMapping("/enviarnuevoperro")
	public String guardarPerro(@ModelAttribute("perro") Perro perro, RedirectAttributes ra,
			@RequestParam("fileImage") MultipartFile multipartFile) throws IOException {

		String FileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		perro.setImg(FileName);

		if (!multipartFile.isEmpty()) {
			Path uploadPath = Paths.get("src//main//resources//static//perritos");
			String rutaAbsoluta = uploadPath.toFile().getAbsolutePath();

			try {
				byte[] bytesImg = multipartFile.getBytes();
				Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + multipartFile.getOriginalFilename());
				Files.write(rutaCompleta, bytesImg);

				perro.setImg(multipartFile.getOriginalFilename());

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		servicio.guardarPerro(perro);
		ra.addFlashAttribute("success", "perro guardado con exito!");
		return "redirect:/administrar/perros";
	}

	@GetMapping("/detalleperro/{id}")
	public String mostrarFormularioEditar(@PathVariable Integer id, Model modelo) {
		modelo.addAttribute("perro", servicio.obtenerPerroId(id));
		return "verMas";
	}
	
	@GetMapping("/administrar/perros/editar/{id}")
	public String editarPerro(@PathVariable Integer id, Model modelo) {
		modelo.addAttribute("perro", servicio.obtenerPerroId(id));
		return "editarPerros";
	}
	
	

	@PostMapping("/perros/{id}")
	public String actualizarPerro(@PathVariable Integer id, @ModelAttribute("perro") Perro perro, Model modelo) {
		Perro perroExistente = servicio.obtenerPerroId(id);
		perroExistente.setIdPerro(id);
		perroExistente.setNombre(perro.getNombre());
		perroExistente.setEdad(perro.getEdad());
		perroExistente.setCaracter(perro.getCaracter());
		perroExistente.setDescripcion(perro.getDescripcion());
		perroExistente.setSexo(perro.getSexo());
		perroExistente.setTamano(perro.getTamano());
		perroExistente.setImg(perro.getImg());
		perroExistente.setProtectora_idprotectora(perro.getProtectora_idprotectora());

		servicio.actualizarPerro(perroExistente);

		return "redirect:/administrar/perros";
	}

	@GetMapping("/administrar/perros/eliminar/{id}")
	public String eliminarPerro(@PathVariable Integer id) {
		servicio.eliminarPerro(id);
		return "redirect:/administrar/perros";
	}

	@GetMapping("/faq")
	public String faq() {
		return "faq";
	}
	
	@GetMapping("/aviso-cookies")
	public String avisoCookies() {
		return "aviso-cookies";
	}


	@GetMapping("/porque-adoptar")
	public String porque_adoptar() {
		return "porque_adoptar";
	}
}
