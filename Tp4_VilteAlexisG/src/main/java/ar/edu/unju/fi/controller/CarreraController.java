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

    @GetMapping("/listar")
    public String listarCarreras(Model model) {
        model.addAttribute("carreras", CollectionCarrera.listar());
        return "carreras";
    }

    @GetMapping("/nuevo")
    public String nuevaCarreraForm(Model model) {
        model.addAttribute("carrera", new Carrera());
        model.addAttribute("action", "guardar");
        return "carrera";
    }

    @PostMapping("/guardar")
    public ModelAndView guardarCarrera(@ModelAttribute Carrera carrera) {
        CollectionCarrera.agregar(carrera);
        return new ModelAndView("redirect:/carreras/listar");
    }

    @GetMapping("/editar/{id}")
    public String editarCarreraForm(@PathVariable int id, Model model) {
        Carrera carrera = CollectionCarrera.buscar(id);
        model.addAttribute("carrera", carrera);
        model.addAttribute("action", "modificar");
        return "carrera";
    }

    @PostMapping("/modificar")
    public ModelAndView modificarCarrera(@ModelAttribute Carrera carrera) {
        CollectionCarrera.modificar(carrera);
        return new ModelAndView("redirect:/carreras/listar");
    }

    @GetMapping("/eliminar/{id}")
    public ModelAndView eliminarCarrera(@PathVariable int id) {
        CollectionCarrera.eliminar(id);
        return new ModelAndView("redirect:/carreras/listar");
    }
}
