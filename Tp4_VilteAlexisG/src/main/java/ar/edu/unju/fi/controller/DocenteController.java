package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.Collections.CollectionDocente;
import ar.edu.unju.fi.model.Docente;

@Controller
@RequestMapping("/docentes")
public class DocenteController {
	
    @GetMapping("/listar")
    public String listarDocentes(Model model) {
        model.addAttribute("docentes", CollectionDocente.listar());
        return "docentes";
    }

    @GetMapping("/nuevo")
    public String nuevoDocenteForm(Model model) {
        model.addAttribute("docente", new Docente());
        return "docente";
    }

    @PostMapping("/guardar")
    public ModelAndView guardarDocente(@ModelAttribute Docente docente) {
        CollectionDocente.agregar(docente);
        ModelAndView mav = new ModelAndView("redirect:/docentes/listar");
        return mav;
    }

    @GetMapping("/editar/{legajo}")
    public String editarDocenteForm(@PathVariable String legajo, Model model) {
        Docente docente = CollectionDocente.buscar(legajo);
        if (docente != null) {
            model.addAttribute("docente", docente);
            return "docente";
        }
        return "redirect:/docentes/listar";
    }

    @PostMapping("/modificar")
    public String modificarDocente(@ModelAttribute Docente docente) {
        CollectionDocente.modificar(docente);
        return "redirect:/docentes/listar";
    }

    @GetMapping("/eliminar/{legajo}")
    public String eliminarDocente(@PathVariable String legajo) {
        CollectionDocente.eliminar(legajo);
        return "redirect:/docentes/listar";
    }
}
