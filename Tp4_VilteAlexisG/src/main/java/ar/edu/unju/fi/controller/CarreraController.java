package ar.edu.unju.fi.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.Collections.CollectionCarrera;
import ar.edu.unju.fi.model.Carrera;

@Controller
@RequestMapping("/carreras")
public class CarreraController {

	/*
	@SuppressWarnings("unused")
	@Autowired
	private Materia materia; 
	*/
	
    @GetMapping("/listar")
    public String listarCarreras(Model model) {
        model.addAttribute("carreras", CollectionCarrera.listar());
        return "carreras";
    }

    @GetMapping("/nuevo")
    public String nuevaCarreraForm(Model model) {
        model.addAttribute("carrera", new Carrera());
        return "carrera";
    }

    @PostMapping("/guardar")
    public ModelAndView guardarCarrera(@ModelAttribute Carrera carrera) {
        CollectionCarrera.agregar(carrera);
        ModelAndView mav = new ModelAndView("carreras");
        mav.addObject("carreras", CollectionCarrera.listar());
        return mav;
    }

    @GetMapping("/editar/{id}")
    public String editarCarreraForm(@PathVariable int id, Model model) {
        Carrera carrera = CollectionCarrera.buscar(id);
        model.addAttribute("carrera", carrera);
        return "carrera"; 
    }

    @PostMapping("/modificar")
    public String modificarCarrera(@ModelAttribute Carrera carrera) {
        CollectionCarrera.modificar(carrera);
        return "redirect:/carreras/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCarrera(@PathVariable int id) {
        CollectionCarrera.eliminar(id);
        return "redirect:/carreras/listar"; 
    }
}