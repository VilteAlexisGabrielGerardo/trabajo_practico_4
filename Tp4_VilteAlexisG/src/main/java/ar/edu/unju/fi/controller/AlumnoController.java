package ar.edu.unju.fi.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.Collections.CollectionAlumno;
import ar.edu.unju.fi.model.Alumno;
@Controller
@RequestMapping("/alumnos")
public class AlumnoController {
	
	/*
	@SuppressWarnings("unused")
	@Autowired
	private Materia materia; 
	*/
	
    @GetMapping("/listar")
    public String listarAlumnos(Model model) {
        model.addAttribute("alumnos", CollectionAlumno.listar());
        return "listar";
    }

    @GetMapping("/nuevo")
    public String nuevoAlumnoForm(Model model) {
        model.addAttribute("alumno", new Alumno());
        return "form";
    }

    @PostMapping("/guardar")
    public ModelAndView guardarAlumno(@ModelAttribute Alumno alumno) {
        CollectionAlumno.agregar(alumno);
        ModelAndView mav = new ModelAndView("listar");
        mav.addObject("alumnos", CollectionAlumno.listar());
        return mav;
    }

    @GetMapping("/editar/{dni}")
    public String editarAlumnoForm(@PathVariable int dni, Model model) {
        Alumno alumno = CollectionAlumno.buscar(dni);
        model.addAttribute("alumno", alumno);
        return "form"; // Corregido
    }
    @PostMapping("/modificar")
    public String modificarAlumno(@ModelAttribute Alumno alumno) {
    	CollectionAlumno.modificar(alumno);
        return "redirect:/alumnos/listar";
    }

    @GetMapping("/eliminar/{dni}")
    public String eliminarAlumno(@PathVariable int dni) {
        CollectionAlumno.eliminar(dni);
        return "redirect:/alumnos/listar"; // Corregido
    }
	    
}