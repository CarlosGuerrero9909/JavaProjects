package models;

public class TipoDetalle {
    int idTipoDetalle;
    String descTipoDetalle;
    public TipoDetalle() {
    }
    public TipoDetalle(int idTipoDetalle, String descTipoDetalle) {
        this.idTipoDetalle = idTipoDetalle;
        this.descTipoDetalle = descTipoDetalle;
    }
    public int getIdTipoDetalle() {
        return idTipoDetalle;
    }
    public void setIdTipoDetalle(int idTipoDetalle) {
        this.idTipoDetalle = idTipoDetalle;
    }
    public String getDescTipoDetalle() {
        return descTipoDetalle;
    }
    public void setDescTipoDetalle(String descTipoDetalle) {
        this.descTipoDetalle = descTipoDetalle;
    }
    
}
