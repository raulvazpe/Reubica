package com.reubica.controlador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.reubica.entidad.Protectora;
import com.reubica.interfaceService.IProtectoraService;

@Controller
public class ControladorP {

	@Autowired
	private IProtectoraService servicio;

	// PAGINAS PROTECTORAS

	@GetMapping({ "/protectora" })
	public String listarProtectoras(Model modelo) {
		modelo.addAttribute("protectora", servicio.listarTodasLasProtectoras());
		return "protectora";
	}

	@GetMapping("/detalleprotectora/{idprotectora}")
	public String verProtectora(@PathVariable Long idprotectora, Model modelo) {
		modelo.addAttribute("protectora", servicio.obtenerProtectoraId(idprotectora));
		return "verMasProtectora";
	}

	// ADMINISTRACION DE PROTECTORAS

	@GetMapping({ "/administrar/protectoras"})
		public String listarProtectorasAdm(Model modelo) {
		modelo.addAttribute("protectora", servicio.listarTodasLasProtectoras());
		return "protectorasEdit";   
	}

	@GetMapping("/administrar/protectoras/nueva")
	public String mostrarFormularioDeRegistro(Model modelo) {
		Protectora protectora = new Protectora();
		modelo.addAttribute("protectora", protectora);
		return "crearProtectora";
	}

	@PostMapping("/enviarnuevaprotectora")
	public String guardarProtectora(@ModelAttribute("protectora") Protectora protectora, RedirectAttributes ra,
			@RequestParam("fileImage") MultipartFile multipartFile) throws IOException {

		String FileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		protectora.setImg(FileName);

		if (!multipartFile.isEmpty()) {
			Path uploadPath = Paths.get("src//main//resources//static//protectoras");
			String rutaAbsoluta = uploadPath.toFile().getAbsolutePath();

			try {
				byte[] bytesImg = multipartFile.getBytes();
				Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + multipartFile.getOriginalFilename());
				Files.write(rutaCompleta, bytesImg);

				protectora.setImg(multipartFile.getOriginalFilename());

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		servicio.guardarProtectora(protectora);
		ra.addFlashAttribute("success", "protectora guardado con exito!");
		return "redirect:/administrar/protectoras";
	}

	@GetMapping("/administrar/protectoras/editar/{idprotectora}")
	public String mostrarFormularioEditar(@PathVariable Long idprotectora, Model modelo) {
		modelo.addAttribute("protectora", servicio.obtenerProtectoraId(idprotectora));
		return "editarProtectora";
	}

	@PostMapping("/protectora/{idprotectora}")
	public String actualizarProtectora(@PathVariable Long idprotectora,
			@ModelAttribute("protectora") Protectora protectora, Model modelo) {
		Protectora protectoraExistente = servicio.obtenerProtectoraId(idprotectora);
		protectoraExistente.setIdprotectora(idprotectora);
		protectoraExistente.setNombre(protectora.getNombre());
		protectoraExistente.setCiudad(protectora.getCiudad());
		protectoraExistente.setImg(protectora.getImg());
		protectoraExistente.setMaps(protectora.getMaps());
		protectoraExistente.setDescripcion(protectora.getDescripcion());
		protectoraExistente.setMail(protectora.getMail());

		servicio.actualizarProtectora(protectoraExistente);

		return "redirect:/administrar/protectoras";
	}

	@GetMapping("/administrar/protectoras/eliminar/{idprotectora}")
	public String eliminarProtectora(@PathVariable Long idprotectora) {
		servicio.eliminarProtectora(idprotectora);
		return "redirect:/administrar/protectoras";
	}
}