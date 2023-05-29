package models;

public class ClienteVO {
    private String codCliente;
    private String nombreApell;
    private String cedula;
    private String idTipoPersonaFk;
    
    public ClienteVO() {

    }
    
    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public String getNombreApell() {
        return nombreApell;
    }

    public void setNombreApell(String nombreApell) {
        this.nombreApell = nombreApell;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    } 

    public String getIdTipoPersonaFk() {
        return idTipoPersonaFk;
    }

    public void setIdTipoPersonaFk(String idTipoPersonaFk) {
        this.idTipoPersonaFk = idTipoPersonaFk;
    }   
    
}
