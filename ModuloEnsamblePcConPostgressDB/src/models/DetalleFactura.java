package models;

public class DetalleFactura {
    private int item;
    private int nFacturaFk;
    private String idTipoDetalleFk;
    private int conseccfk;
    private int idrefefk;
    private int noinventariofk;
    private int cantidad;
    private int precio;

    public DetalleFactura() {
    }

    public DetalleFactura(int item, int nFacturaFk, String idTipoDetalleFk, int conseccfk, int idrefefk, int noinventariofk, int cantidad, int precio) {
        this.item = item;
        this.nFacturaFk = nFacturaFk;
        this.idTipoDetalleFk = idTipoDetalleFk;
        this.conseccfk = conseccfk;
        this.idrefefk = idrefefk;
        this.noinventariofk = noinventariofk;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getnFacturaFk() {
        return nFacturaFk;
    }

    public void setnFacturaFk(int nFacturaFk) {
        this.nFacturaFk = nFacturaFk;
    }

    public String getIdTipoDetalleFk() {
        return idTipoDetalleFk;
    }

    public void setIdTipoDetalleFk(String idTipoDetalleFk) {
        this.idTipoDetalleFk = idTipoDetalleFk;
    }

    public int getConseccfk() {
        return conseccfk;
    }

    public void setConseccfk(int conseccfk) {
        this.conseccfk = conseccfk;
    }

    public int getIdrefefk() {
        return idrefefk;
    }

    public void setIdrefefk(int idrefefk) {
        this.idrefefk = idrefefk;
    }

    public int getNoinventariofk() {
        return noinventariofk;
    }

    public void setNoinventariofk(int noinventariofk) {
        this.noinventariofk = noinventariofk;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    

}
