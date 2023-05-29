package models;

import java.sql.Date;

public class Inventario {
    private int noInventario;
    private int idrefefk;
    private String codempleadofk;
    private int nfacturafk;
    private String ideventofk;
    private Date fechaevento;
    private Double valor;

    public Inventario() {
    }

    public Inventario(int noInventario, int idrefefk, String codempleadofk, int nfacturafk, String ideventofk, Date fechaevento, Double valor) {
        this.noInventario = noInventario;
        this.idrefefk = idrefefk;
        this.codempleadofk = codempleadofk;
        this.nfacturafk = nfacturafk;
        this.ideventofk = ideventofk;
        this.fechaevento = fechaevento;
        this.valor = valor;
    }

    public int getNoInventario() {
        return noInventario;
    }

    public void setNoInventario(int noInventario) {
        this.noInventario = noInventario;
    }

    public int getIdrefefk() {
        return idrefefk;
    }

    public void setIdrefefk(int idrefefk) {
        this.idrefefk = idrefefk;
    }

    public String getCodempleadofk() {
        return codempleadofk;
    }

    public void setCodempleadofk(String codempleadofk) {
        this.codempleadofk = codempleadofk;
    }

    public int getNfacturafk() {
        return nfacturafk;
    }

    public void setNfacturafk(int nfacturafk) {
        this.nfacturafk = nfacturafk;
    }

    public String getIdeventofk() {
        return ideventofk;
    }

    public void setIdeventofk(String ideventofk) {
        this.ideventofk = ideventofk;
    }

    public Date getFechaevento() {
        return fechaevento;
    }

    public void setFechaevento(Date fechaevento) {
        this.fechaevento = fechaevento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    
}
