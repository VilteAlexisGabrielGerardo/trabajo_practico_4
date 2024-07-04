package ar.edu.unju.fi.Collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.model.Materia;

public class CollectionMateria {
    private static List<Materia> materias = new ArrayList<>();

    public static List<Materia> getMaterias() {
        return materias;
    }

    public static void agregar(Materia materia) {
        materias.add(materia);
    }

    public static void eliminar(String codigo) {
        materias.removeIf(materia -> materia.getCodigo().equals(codigo));
    }

    public static Materia buscar(String codigo) {
        return materias.stream()
            .filter(materia -> materia.getCodigo().equals(codigo))
            .findFirst()
            .orElse(null);
    }

    public static void modificar(Materia materiaModificada) {
        for (Materia materia : materias) {
            if (materia.getCodigo().equals(materiaModificada.getCodigo())) {
                materia.setNombre(materiaModificada.getNombre());
                materia.setCurso(materiaModificada.getCurso());
                materia.setCantidadh(materiaModificada.getCantidadh());
                materia.setModalidad(materiaModificada.getModalidad());
                materia.setDocente(materiaModificada.getDocente());
                materia.setCarrera(materiaModificada.getCarrera());
                return;
            }
        }
        materias.add(materiaModificada);
    }

    public static List<Materia> listar() {
        return new ArrayList<>(materias);
    }
}