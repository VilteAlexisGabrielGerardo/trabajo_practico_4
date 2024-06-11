package ar.edu.unju.fi.Collections;
import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.model.Carrera;

public class CollectionCarrera {
    private static List<Carrera> carreras = new ArrayList<>();

    public static void agregar(Carrera carrera) {
        carreras.add(carrera);
    }

    public static void eliminar(int id) {
        carreras.removeIf(carrera -> carrera.getId() == id);
    }

    public static Carrera buscar(int id) {
        return carreras.stream()
            .filter(carrera -> carrera.getId() == id)
            .findFirst()
            .orElse(null);
    }

    public static void modificar(Carrera carreraModificada) {
        for (Carrera carrera : carreras) {
            if (carrera.getId() == carreraModificada.getId()) {
                carrera.setNombre(carreraModificada.getNombre());
                carrera.setDuracion(carreraModificada.getDuracion());
            }
        }
    }

    public static List<Carrera> listar() {
        return new ArrayList<>(carreras);
    }
}
