package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.Collections.CollectionMateria;
import ar.edu.unju.fi.model.Materia;

@Controller
@RequestMapping("/materias")
public class MateriaController {

    @GetMapping("/listar")
    public String listarMaterias(Model model) {
        model.addAttribute("materias", CollectionMateria.listar());
        return "materias";
    }

    @GetMapping("/nuevo")
    public String nuevaMateriaForm(Model model) {
        model.addAttribute("materia", new Materia());
        return "materia";
    }

    @PostMapping("/guardar")
    public ModelAndView guardarMateria(@ModelAttribute Materia materia) {
        CollectionMateria.agregar(materia);
        ModelAndView mav = new ModelAndView("materias");
        mav.addObject("materias", CollectionMateria.listar());
        return mav;
    }

    @GetMapping("/editar/{codigo}")
    public String editarMateriaForm(@PathVariable String codigo, Model model) {
        Materia materia = CollectionMateria.buscar(codigo);
        if (materia != null) {
            model.addAttribute("materia", materia);
            return "materia";
        } else {
            return "redirect:/materias/listar";
        }
    }

    @PostMapping("/modificar")
    public String modificarMateria(@ModelAttribute Materia materia) {
        CollectionMateria.modificar(materia);
        return "redirect:/materias/listar";
    }

    @GetMapping("/eliminar/{codigo}")
    public String eliminarMateria(@PathVariable String codigo) {
        CollectionMateria.eliminar(codigo);
        return "redirect:/materias/listar";
    }
}
