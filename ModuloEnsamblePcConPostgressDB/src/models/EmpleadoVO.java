package models;

public class EmpleadoVO {
    private String codEmple;
    private String nombreApell;
    private String cargo;

    public EmpleadoVO() {
        
    }

    public String getCodEmple() {
        return codEmple;
    }

    public void setCodEmple(String codEmple) {
        this.codEmple = codEmple;
    }

    public String getNombreApell() {
        return nombreApell;
    }

    public void setNombreApell(String nombreApell) {
        this.nombreApell = nombreApell;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

}
