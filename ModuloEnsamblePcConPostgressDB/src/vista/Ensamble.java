package vista;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import models.ItemEnsamble;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class Ensamble extends JPanel {
    private Ventana vtn;
    private JLabel lblTipoDetalle, lblEnsamNoFact;
    private JComboBox cbxTipoDetalle, cbxEnsamNoFact;
    private JButton btnConsultarEnsamb, btnTerminar, btnAceptar, btnVolver;
    private JTable tblDetallEnsam;
    private JScrollPane sp;

    /**
     * @param vtn
     */
    public Ensamble(Ventana vtn) {
        this.vtn = vtn;
        GridBagConstraints gbc;

        this.setLayout(new GridBagLayout());
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(24, 74, 102), 1),
                "Detalle del ensamble",
                TitledBorder.DEFAULT_POSITION, TitledBorder.DEFAULT_JUSTIFICATION, new Font("SansSerif", 1, 20),
                new Color(24, 74, 102)));
        this.setBackground(new Color(83, 153, 176));

        lblTipoDetalle = new JLabel("Tipo detalle");
        lblTipoDetalle.setFont(new Font("SansSerif", 0, 16));
        lblTipoDetalle.setForeground(new Color(24, 74, 102));
        gbc = new GridBagConstraints(0, 0, 3, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(5, 5, 5, 5), 0, 0);
        this.add(lblTipoDetalle, gbc);

        cbxTipoDetalle = new JComboBox<String>();
        gbc = new GridBagConstraints(0, 1, 3, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(5, 5, 5, 5), 0, 0);
        cbxTipoDetalle.setActionCommand("TipoDetalleSelecc");
        cbxTipoDetalle.addActionListener(this.vtn.getCtrl());
        cbxTipoDetalle.addItem("Aca iran resultados");
        this.add(cbxTipoDetalle, gbc);

        lblEnsamNoFact = new JLabel("Ensambles no facturados");
        lblEnsamNoFact.setFont(new Font("SansSerif", 0, 16));
        lblEnsamNoFact.setForeground(new Color(24, 74, 102));
        gbc = new GridBagConstraints(0, 2, 3, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(5, 5, 5, 5), 0, 0);
        this.add(lblEnsamNoFact, gbc);

        cbxEnsamNoFact = new JComboBox<String>();
        gbc = new GridBagConstraints(0, 3, 3, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(5, 5, 5, 5), 0, 0);
        // cbxEnsamNoFact.setActionCommand("EnsamblesNoFact");
        // cbxEnsamNoFact.addActionListener(this.vtn.getCtrl());
        cbxEnsamNoFact.addItem("Aca iran resultados");
        this.add(cbxEnsamNoFact, gbc);

        btnConsultarEnsamb = new JButton("");
        btnConsultarEnsamb.setPreferredSize(new Dimension(60, 60));
        gbc = new GridBagConstraints(0, 4, 3, 1, 0, 0, GridBagConstraints.CENTER,
        GridBagConstraints.NONE,
        new Insets(5, 5, 5, 5), 0, 0);
        ImageIcon imagen1 = new
        ImageIcon(getClass().getResource("/imgs/consulta.jpg"));
        Icon icon1 = new ImageIcon(imagen1.getImage().getScaledInstance(60, 60,
        Image.SCALE_DEFAULT));
        btnConsultarEnsamb.setIcon(icon1);
        btnConsultarEnsamb.setActionCommand("ConsultarEnsamble");
        btnConsultarEnsamb.addActionListener(this.vtn.getCtrl());
        add(btnConsultarEnsamb, gbc);

        JPanel containTbl = new JPanel();
        containTbl.setPreferredSize(new Dimension(420, 150));
        gbc = new GridBagConstraints(0, 5, 3, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(5, 5, 5, 5), 0, 0);
        containTbl.setBackground(new Color(83, 153, 176));
        this.add(containTbl, gbc);

        String data[][] = { { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" } };
        String columns[] = { "item", "tipoDetalle", "refProduc", "cantidad", "precio" };
        tblDetallEnsam = new JTable(data, columns);
        tblDetallEnsam.setPreferredScrollableViewportSize(new Dimension(400, 150));
        tblDetallEnsam.setFillsViewportHeight(true);
        containTbl.add(tblDetallEnsam);

        sp = new JScrollPane(tblDetallEnsam);
        containTbl.add(sp);

        btnVolver = new JButton("");
        btnVolver.setPreferredSize(new Dimension(70, 50));
        gbc = new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(5, 5, 5, 5), 0, 0);
        ImageIcon imagen0 = new ImageIcon(getClass().getResource("/imgs/volver.jpg"));
        Icon icon0 = new ImageIcon(imagen0.getImage().getScaledInstance(70, 45, Image.SCALE_DEFAULT));
        btnVolver.setIcon(icon0);
        btnVolver.setActionCommand("VolverConsultaCli");
        btnVolver.addActionListener(this.vtn.getCtrl());
        add(btnVolver, gbc);

        btnTerminar = new JButton("");
        btnTerminar.setPreferredSize(new Dimension(70, 50));
        gbc = new GridBagConstraints(1, 6, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(5, 5, 5, 5), 0, 0);
        ImageIcon imagen2 = new ImageIcon(getClass().getResource("/imgs/terminar.jpg"));
        Icon icon2 = new ImageIcon(imagen2.getImage().getScaledInstance(80, 50, Image.SCALE_DEFAULT));
        btnTerminar.setIcon(icon2);
        btnTerminar.setActionCommand("Terminar");
        btnTerminar.addActionListener(this.vtn.getCtrl());
        add(btnTerminar, gbc);

        btnAceptar = new JButton("");
        btnAceptar.setPreferredSize(new Dimension(200, 50));
        gbc = new GridBagConstraints(2, 6, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(5, 5, 5, 5), 0, 0);
        ImageIcon imagen3 = new ImageIcon(getClass().getResource("/imgs/aceptar.jpg"));
        Icon icon3 = new ImageIcon(imagen3.getImage().getScaledInstance(270, 50, Image.SCALE_DEFAULT));
        btnAceptar.setIcon(icon3);
        btnAceptar.setActionCommand("Aceptar");
        btnAceptar.addActionListener(this.vtn.getCtrl());
        add(btnAceptar, gbc);

    }

    public Ventana getVtn() {
        return vtn;
    }

    public JLabel getLblTipoDetalle() {
        return lblTipoDetalle;
    }

    public JLabel getLblEnsamNoFact() {
        return lblEnsamNoFact;
    }

    public JComboBox getCbxTipoDetalle() {
        return cbxTipoDetalle;
    }

    public JComboBox getCbxEnsamNoFact() {
        return cbxEnsamNoFact;
    }

    public JTable getTblDetallEnsam() {
        return tblDetallEnsam;
    }

    public JScrollPane getSp() {
        return sp;
    }

    public JButton getBtnConsultarEnsamb() {
        return btnConsultarEnsamb;
    }

    public JButton getBtnTerminar() {
        return btnTerminar;
    }

    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }

    public void limpiarTabla() {
        String data[][] = { { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" },
                { "", "", "", "", "" } };
        String columns[] = { "item", "tipoDetalle", "refProduc", "cantidad", "precio" };

        DefaultTableModel model = new DefaultTableModel(data, columns);
        tblDetallEnsam.setModel(model);
    }

    public void setTabla(ArrayList<ItemEnsamble> item){
        String data[][] = new String[item.size()][5];
        String columns[] = { "item", "tipoDetalle", "refProduc", "cantidad", "precio" };
        for (int i = 0; i < item.size(); i++) {
            data[i][0] = item.get(i).getIdItemEnsamble()+"";
            data[i][1] = item.get(i).getDescTipoElemen()+"";
            data[i][2] = item.get(i).getObsRefencia()+"";
            data[i][3] = 1+"";
            data[i][4] = item.get(i).getValor()+"";
            //de.itemensamble, i.valor, re.obsref, tc.desctipocarac,rc. valorrefcara, te.destipoelemen
        }
        DefaultTableModel model = new DefaultTableModel(data, columns);
        tblDetallEnsam.setModel(model);
    }

    public Boolean isTableEmpty() {
        return tblDetallEnsam.getModel().getRowCount() == 0;
    }

}
