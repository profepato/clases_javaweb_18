package model;

public class Ciudad {
    private int id;
    private String nombre;
    private int fkRegion;

    public Ciudad() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFkRegion() {
        return fkRegion;
    }

    public void setFkRegion(int fkRegion) {
        this.fkRegion = fkRegion;
    }
    
    
}
