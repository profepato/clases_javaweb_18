package model;

import java.sql.Timestamp;

public class Voto {
    private String id;
    private String fkSistemaOperativo;
    private Timestamp fecha;

    public Voto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFkSistemaOperativo() {
        return fkSistemaOperativo;
    }

    public void setFkSistemaOperativo(String fkSistemaOperativo) {
        this.fkSistemaOperativo = fkSistemaOperativo;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
    
    
}
