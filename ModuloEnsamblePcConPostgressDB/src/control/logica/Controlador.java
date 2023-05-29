package control.logica;

import control.dao.ClienteDAO;
import control.dao.DetalleFacturaDAO;
import control.dao.EmpleadoDAO;
import control.dao.EnsambleDAO;
import control.dao.FacturaDAO;
import control.dao.InventarioDAO;
import control.dao.ItemEnsambleDao;
import control.dao.TipoDetalleDAO;
import models.ClienteVO;
import models.DetalleFactura;
import models.EmpleadoVO;
import models.Ensamble;
import models.Factura;
import models.Inventario;
import models.ItemEnsamble;
import models.TipoDetalle;
import vista.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.sql.Date;
import java.time.ZoneId;


public class Controlador implements ActionListener{
    private EmpleadoDAO empDao;
    private ClienteDAO clienteDao;
    private Ventana vtn;
    private String idTipoPersona;
    private String idPersonaFk;
    private String codEmpleado;
    private Double valTotal = 0.0;
    private int nuevoIdFactura;
    private ArrayList<ItemEnsamble> listaEnsamble;
    private int EnsambleSelec;

    public Controlador(){
        this.vtn = new Ventana(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Registrar")){
            String codEmplea = vtn.getPnlReg().getTxfCodEmp().getText();
            if(validarEmpleado(codEmplea)){
                vtn.renderConsulta();
                vtn.getPnlReg().limpiarCampo();
            }else{
                vtn.mostrarJoptionPane("Empleado NO Registrado");
                vtn.getPnlReg().limpiarCampo();
            }
            
        }

        if(e.getActionCommand().equals("Consultar")){
            String cedCliente = vtn.getPnlCon().getTxfCedClie().getText();
            String nombreCliente = validarCliente(cedCliente);

            if(nombreCliente.equals("")){
                vtn.mostrarJoptionPane("El cliente no se encuentra registrado");
                vtn.getPnlCon().limpiarCampo();
            }else{
                vtn.mostrarJoptionPane("Cliente registrado: " + nombreCliente);
                vtn.getPnlCon().limpiarCampo();
                try {
                    TipoDetalleDAO tipoDetalleDao = new TipoDetalleDAO();
                    ArrayList<TipoDetalle> listaTipoDetalle = tipoDetalleDao.getTipoDetalle();
                    vtn.getPnlEnsamble().getCbxTipoDetalle().removeAllItems();
                    for (TipoDetalle tipoDetalle : listaTipoDetalle) {
                        vtn.getPnlEnsamble().getCbxTipoDetalle().addItem(tipoDetalle.getDescTipoDetalle());
                    }
                } catch (Exception ex) {
                    System.out.println("Error al cargar el combo");
                }
                vtn.renderEnsamble();
                vtn.getPnlEnsamble().limpiarTabla();
            }
        }

        if(e.getActionCommand().equals("TipoDetalleSelecc")){
            try {
                if(((String)vtn.getPnlEnsamble().getCbxTipoDetalle().getSelectedItem()).equals("Ensamble")){
                    vtn.getPnlEnsamble().getCbxEnsamNoFact().removeAllItems();
                    EnsambleDAO ensambleDao = new EnsambleDAO();
                    ArrayList<Ensamble> listaEnsamble = ensambleDao.getEnsambleNoFacturado();
                    for (Ensamble ensamble : listaEnsamble) {
                        vtn.getPnlEnsamble().getCbxEnsamNoFact().addItem(ensamble.getConsecc());
                    }
                }else{
                    vtn.getPnlEnsamble().getCbxEnsamNoFact().removeAllItems();
                    vtn.getPnlEnsamble().limpiarTabla();
                }
            } catch (Exception exe) {
                System.out.println("Error al cargar el combo: "+exe.getMessage());
            }

        }
        if(e.getActionCommand().equals("ConsultarEnsamble")){
            try {
                EnsambleSelec = ((Integer)vtn.getPnlEnsamble().getCbxEnsamNoFact().getSelectedItem());
                ItemEnsambleDao itemEnsambleDao = new ItemEnsambleDao();
                listaEnsamble = itemEnsambleDao.getItemEnsamble(EnsambleSelec);
                vtn.getPnlEnsamble().limpiarTabla();
                vtn.getPnlEnsamble().setTabla(listaEnsamble);
            } catch (Exception ex) {
                System.out.println("Error al consultar los detalles del ensamble: "+ex.getMessage());
            }
        }
        if(e.getActionCommand().equals("VolverConsultaCli")){
            vtn.getPnlEnsamble().limpiarTabla();
            vtn.renderConsulta();
        }
        if(e.getActionCommand().equals("Terminar")){
            if(vtn.getPnlEnsamble().isTableEmpty()){
                vtn.mostrarJoptionPane("Se ha seleccionado ensamble");
            }else{
                MostrarValor();
            }
        }
        if(e.getActionCommand().equals("Aceptar")){
            if(vtn.getPnlEnsamble().isTableEmpty()){
                vtn.mostrarJoptionPane("Se ha seleccionado ensamble");
            }else{
                if(valTotal == 0.0){
                    MostrarValor();
                }
                GenerarFactura();
                InsertarDetallesFactura();
                //actualizar ensamble
                EnsambleDAO ensambleDao = new EnsambleDAO();
                ensambleDao.actualizarEstadoEnsamble(EnsambleSelec);
    
                GenerarRegistrosSoporte();
                vtn.renderPnlReg();
                vtn.mostrarJoptionPane("Factura generada con exito; Se ha hecho inserción en la base de datos");
            }
        }
        if(e.getActionCommand().equals("VolverEnsamble")){
            vtn.renderEnsamble();
            vtn.getPnlTerminar().limpiarCampos();  
        }
        if(e.getActionCommand().equals("Salir")){
            System.exit(0);
        }
        
    }

    //se genera fecha actual
    public Date fechaActual(){

        java.util.Date fechaActual= new java.util.Date(System.currentTimeMillis());
        java.sql.Date fechaSql= java.sql.Date.valueOf(fechaActual.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

        return fechaSql;
    }

    public boolean validarEmpleado(String codEmplea){
        empDao = new EmpleadoDAO();
        ArrayList<EmpleadoVO> empleadosAux = empDao.obtenerEmpleadosAux();

        for (EmpleadoVO empleAux : empleadosAux) {
            if(empleAux.getCodEmple().equals(codEmplea)){
                codEmpleado = empleAux.getCodEmple();
                return true;
            }
        }
        return false;
    }

    public String validarCliente(String cedula){
        clienteDao = new ClienteDAO();
        ArrayList<ClienteVO> clientes = clienteDao.obtenerClientes();

        for (ClienteVO cliente : clientes) {
            if(cliente.getCedula().equals(cedula)){
                idTipoPersona = cliente.getIdTipoPersonaFk();
                idPersonaFk = cliente.getCodCliente();
                return cliente.getNombreApell();
            }
        }
        return "";
    }

    public Double calcularFactura(){
        Double total = 0.0;
        for (int i = 0; i < vtn.getPnlEnsamble().getTblDetallEnsam().getRowCount(); i++) {
            total += Double.parseDouble(vtn.getPnlEnsamble().getTblDetallEnsam().getValueAt(i, 4).toString());
        }
        return total;
    }

    public Double calcIVA(Double total){
        return (Double) (total*0.16);
    }

    public EmpleadoDAO getEmpDao() {
        return empDao;
    }

    public Ventana getVtn() {
        return vtn;
    }
    
    public void GenerarFactura(){
        FacturaDAO facturaDao = new FacturaDAO();
        int ultimaFactura = facturaDao.obtenerUltimaFactura();
        nuevoIdFactura = ultimaFactura + 1;
        //se crea nueva factura
        Factura factura = new Factura();
        factura.setnFactura(nuevoIdFactura);
        factura.setIdFormaPagoFk("4");  
        factura.setIdTipoPersonaFk(idTipoPersona);
        factura.setIdPersonaFk(idPersonaFk);
        factura.setIdTipoFacturaFk("1");
        factura.setCodEmpleadoFk(codEmpleado);
        factura.setFechaFactura(fechaActual());
        factura.setValorFactura(valTotal);

        facturaDao.insertarFactura(factura);
    }

    public void InsertarDetallesFactura(){
        DetalleFacturaDAO detalleFacturaDao = new DetalleFacturaDAO();
        int ultimoDetalle = detalleFacturaDao.obtenerUltimoItem();
        for (ItemEnsamble itemEnsamble : listaEnsamble) {
            ultimoDetalle++;
            DetalleFactura detalleFactura = new DetalleFactura();
            detalleFactura.setItem(ultimoDetalle);
            detalleFactura.setnFacturaFk(nuevoIdFactura);
            detalleFactura.setIdTipoDetalleFk("1");
            detalleFactura.setConseccfk(EnsambleSelec);
            detalleFactura.setIdrefefk(itemEnsamble.getIdrefefk());
            detalleFactura.setNoinventariofk(itemEnsamble.getNoinventario());
            detalleFactura.setCantidad(1);
            detalleFactura.setPrecio( (int) Math.round(itemEnsamble.getValor()) );

            detalleFacturaDao.insertarDetalleFactura(detalleFactura);
        }
    }

    public void GenerarRegistrosSoporte(){
        InventarioDAO inventarioDao = new InventarioDAO();
        int ultimoRegistro = inventarioDao.obtenerUltimoInventario();

        for (ItemEnsamble itemEnsamble : listaEnsamble) {
            ultimoRegistro++;
            Inventario inventario = new Inventario();

            inventario.setNoInventario(ultimoRegistro);
            inventario.setIdrefefk(itemEnsamble.getIdrefefk());
            inventario.setCodempleadofk(codEmpleado);
            inventario.setNfacturafk(nuevoIdFactura);
            inventario.setIdeventofk("2");
            inventario.setFechaevento(fechaActual());
            inventario.setValor(itemEnsamble.getValor());

            inventarioDao.insertarInventario(inventario);
        }
    }

    public void MostrarValor(){
        Double valFactura = calcularFactura();
        Double valIva = calcIVA(valFactura);
        valTotal = valFactura + valIva;
        vtn.renderTerminar();
        vtn.getPnlTerminar().getTxfTotalProSer().setText(valFactura.toString());
        vtn.getPnlTerminar().getTxfIva().setText(valIva.toString());
        vtn.getPnlTerminar().getTxfTotalFact().setText(valTotal.toString());
    }
}
