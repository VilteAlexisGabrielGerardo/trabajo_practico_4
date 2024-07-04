package ar.edu.unju.fi.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.Collections.CollectionAlumno;
import ar.edu.unju.fi.model.Alumno;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

    @GetMapping("/listar")
    public String listarAlumnos(Model model) {
        model.addAttribute("alumnos", CollectionAlumno.listar());
        return "listar";
    }

    @GetMapping("/nuevo")
    public String nuevoAlumnoForm(Model model) {
        model.addAttribute("alumno", new Alumno());
        model.addAttribute("listaCarreras", obtenerListaCarreras()); // Agregar lista de carreras al modelo
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
        if (alumno != null) {
            model.addAttribute("alumno", alumno);
            model.addAttribute("listaCarreras", obtenerListaCarreras()); // Asegúrate de agregar la lista de carreras
            return "form";
        } else {
            // Manejar caso en que el alumno no se encuentre
            return "redirect:/alumnos/listar";
        }
    }
    @PostMapping("/modificar")
    public String modificarAlumno(@ModelAttribute Alumno alumno) {
        CollectionAlumno.modificar(alumno);
        return "redirect:/alumnos/listar";
    }
    @GetMapping("/eliminar/{dni}")
    public String eliminarAlumno(@PathVariable int dni) {
        CollectionAlumno.eliminar(dni);
        return "redirect:/alumnos/listar";
    }
    private List<String> obtenerListaCarreras() {
        List<String> carreras = new ArrayList<>();
        carreras.add("Ingeniería");
        carreras.add("Medicina");
        carreras.add("Filosofia");
        carreras.add("Derecho");
        return carreras;
    }
}