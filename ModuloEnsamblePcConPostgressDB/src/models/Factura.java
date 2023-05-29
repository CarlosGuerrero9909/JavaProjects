package models;

import java.sql.Date;

public class Factura {
    private int nFactura;
    private String idFormaPagoFk;
    private String idTipoPersonaFk;
    private String idPersonaFk;
    private String idTipoFacturaFk;
    private String codEmpleadoFk;
    private Date fechaFactura;
    private double valorFactura;

    public Factura() {
    }

    public Factura(int nFactura, String idFormaPagoFk, String idTipoPersonaFk, String idPersonaFk, String idTipoFacturaFk, String codEmpleadoFk, Date fechaFactura, double valorFactura) {
        this.nFactura = nFactura;
        this.idFormaPagoFk = idFormaPagoFk;
        this.idTipoPersonaFk = idTipoPersonaFk;
        this.idPersonaFk = idPersonaFk;
        this.idTipoFacturaFk = idTipoFacturaFk;
        this.codEmpleadoFk = codEmpleadoFk;
        this.fechaFactura = fechaFactura;
        this.valorFactura = valorFactura;
    }

    public int getnFactura() {
        return nFactura;
    }

    public void setnFactura(int nFactura) {
        this.nFactura = nFactura;
    }

    public String getIdFormaPagoFk() {
        return idFormaPagoFk;
    }

    public void setIdFormaPagoFk(String idFormaPagoFk) {
        this.idFormaPagoFk = idFormaPagoFk;
    }

    public String getIdTipoPersonaFk() {
        return idTipoPersonaFk;
    }

    public void setIdTipoPersonaFk(String idTipoPersonaFk) {
        this.idTipoPersonaFk = idTipoPersonaFk;
    }

    public String getIdPersonaFk() {
        return idPersonaFk;
    }

    public void setIdPersonaFk(String idPersonaFk) {
        this.idPersonaFk = idPersonaFk;
    }

    public String getIdTipoFacturaFk() {
        return idTipoFacturaFk;
    }

    public void setIdTipoFacturaFk(String idTipoFacturaFk) {
        this.idTipoFacturaFk = idTipoFacturaFk;
    }

    public String getCodEmpleadoFk() {
        return codEmpleadoFk;
    }

    public void setCodEmpleadoFk(String codEmpleadoFk) {
        this.codEmpleadoFk = codEmpleadoFk;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public double getValorFactura() {
        return valorFactura;
    }

    public void setValorFactura(double valorFactura) {
        this.valorFactura = valorFactura;
    }
}