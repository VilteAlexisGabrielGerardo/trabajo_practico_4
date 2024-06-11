package ar.edu.unju.fi.Collections;
import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.model.Docente;

public class CollectionDocente {
    private static List<Docente> docentes = new ArrayList<>();

    public static void agregar(Docente docente) {
        docentes.add(docente);
    }

    public static void eliminar(String legajo) {
        docentes.removeIf(docente -> docente.getLegajo().equals(legajo));
    }

    public static Docente buscar(String legajo) {
        return docentes.stream()
            .filter(docente -> docente.getLegajo().equals(legajo))
            .findFirst()
            .orElse(null);
    }

    public static void modificar(Docente docenteModificado) {
        for (Docente docente : docentes) {
            if (docente.getLegajo().equals(docenteModificado.getLegajo())) {
                docente.setNombre(docenteModificado.getNombre());
                docente.setAnosExperiencia(docenteModificado.getAnosExperiencia());
                docente.setMateria(docenteModificado.getMateria());
                docente.setDni(docenteModificado.getDni());
            }
        }
    }

    public static List<Docente> listar() {
        return new ArrayList<>(docentes);
    }
}
