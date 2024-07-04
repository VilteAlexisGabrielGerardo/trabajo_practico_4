package ar.edu.unju.fi.Collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.model.Alumno;

public class CollectionAlumno {
    private static List<Alumno> alumnos = new ArrayList<>();

    public static List<Alumno> getAlumnos() {
       
        return alumnos;
    }

    public static void agregar(Alumno alumno) {
        alumnos.add(alumno);
    }

    public static void eliminar(int dni) {
        alumnos.removeIf(alumno -> alumno.getDni() == dni);
    }

    public static Alumno buscar(int dni) {
        return alumnos.stream()
            .filter(alumno -> alumno.getDni() == dni)
            .findFirst()
            .orElse(null);
    }

    public static void modificar(Alumno alumnoModificado) {
        for (Alumno alumno : alumnos) {
            if (alumno.getDni() == alumnoModificado.getDni()) {

                alumno.setNombre(alumnoModificado.getNombre());
                alumno.setApellido(alumnoModificado.getApellido());
                alumno.setCarreras(alumnoModificado.getCarreras());
                return; 
            }
        }
        alumnos.add(alumnoModificado);
    }
    public static List<Alumno> listar() {
        return new ArrayList<>(alumnos);
    }
}