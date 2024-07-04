package ar.edu.unju.fi.Collections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import ar.edu.unju.fi.model.Carrera;

public class CollectionCarrera {
    private static List<Carrera> carreras = new ArrayList<>();
    private static final AtomicInteger idCounter = new AtomicInteger(0);

    public static List<Carrera> listar() {
        return carreras;
    }

    public static void agregar(Carrera carrera) {
        carrera.setId(idCounter.incrementAndGet());
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
                carrera.setAnio(carreraModificada.getAnio());
                break;
            }
        }
    }
}
