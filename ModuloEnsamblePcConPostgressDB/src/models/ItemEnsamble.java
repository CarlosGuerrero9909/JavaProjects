package models;

public class ItemEnsamble {
    private int idItemEnsamble;
    private Double valor;
    private String ObsRefencia;
    private String DescTipoCarac;
    private String valorRefCarac;
    private String DescTipoElemen;
    private int noinventario;
    private int idrefefk;

    public ItemEnsamble() {
    }

    public ItemEnsamble(int idItemEnsamble, Double valor, String obsRefencia, String descTipoCarac, String valorRefCarac, String descTipoElemen) {
        this.idItemEnsamble = idItemEnsamble;
        this.valor = valor;
        ObsRefencia = obsRefencia;
        DescTipoCarac = descTipoCarac;
        this.valorRefCarac = valorRefCarac;
        DescTipoElemen = descTipoElemen;
    }
    
    public int getIdItemEnsamble() {
        return idItemEnsamble;
    }

    public void setIdItemEnsamble(int idItemEnsamble) {
        this.idItemEnsamble = idItemEnsamble;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getObsRefencia() {
        return ObsRefencia;
    }

    public void setObsRefencia(String obsRefencia) {
        ObsRefencia = obsRefencia;
    }

    public String getDescTipoCarac() {
        return DescTipoCarac;
    }

    public void setDescTipoCarac(String descTipoCarac) {
        DescTipoCarac = descTipoCarac;
    }

    public String getValorRefCarac() {
        return valorRefCarac;
    }

    public void setValorRefCarac(String valorRefCarac) {
        this.valorRefCarac = valorRefCarac;
    }

    public String getDescTipoElemen() {
        return DescTipoElemen;
    }

    public void setDescTipoElemen(String descTipoElemen) {
        DescTipoElemen = descTipoElemen;
    }

    public int getNoinventario() {
        return noinventario;
    }

    public void setNoinventario(int noinventario) {
        this.noinventario = noinventario;
    }

    public int getIdrefefk() {
        return idrefefk;
    }

    public void setIdrefefk(int idrefefk) {
        this.idrefefk = idrefefk;
    }   
}
