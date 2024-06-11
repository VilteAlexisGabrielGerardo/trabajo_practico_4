package ar.edu.unju.fi.model;

public class Carrera {
    private int id; 
    private String codigo;
    private String nombre;
    private int cantidadAnios;
    private String estado;

    public Carrera() {
        // Constructor
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadAnios() {
        return cantidadAnios;
    }

    public void setCantidadAnios(int cantidadAnios) {
        this.cantidadAnios = cantidadAnios;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

	public Object getDuracion() {
	
		return null;
	}

	public void setDuracion(Object duracion) {
		
	}
}