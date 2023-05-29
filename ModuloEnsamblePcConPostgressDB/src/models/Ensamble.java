package models;

public class Ensamble {
    private int consecc;
    private String codEmpleadofk;
    private String fechaEnsamble;
    private Boolean facturado;

    public Ensamble() {
    }

    public Ensamble(int consecc, String codEmpleadofk, String fechaEnsamble, Boolean facturado) {
        this.consecc = consecc;
        this.codEmpleadofk = codEmpleadofk;
        this.fechaEnsamble = fechaEnsamble;
        this.facturado = facturado;
    }

    public int getConsecc() {
        return consecc;
    }

    public void setConsecc(int consecc) {
        this.consecc = consecc;
    }

    public String getCodEmpleadofk() {
        return codEmpleadofk;
    }

    public void setCodEmpleadofk(String codEmpleadofk) {
        this.codEmpleadofk = codEmpleadofk;
    }

    public String getFechaEnsamble() {
        return fechaEnsamble;
    }

    public void setFechaEnsamble(String fechaEnsamble) {
        this.fechaEnsamble = fechaEnsamble;
    }

    public Boolean getFacturado() {
        return facturado;
    }

    public void setFacturado(Boolean facturado) {
        this.facturado = facturado;
    }

    
}
