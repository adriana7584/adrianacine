package com.adriana.proyectocinema;

import com.adriana.proyectocinema.entidades.Reserva;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelListadoReserva extends JDialog {


    private JLabel lblListadoReservas;

    private JButton btnRecargar;

    private JTextArea listadoReservas;
    private InterfazCine interfazCine;

    public PanelListadoReserva() {
        lblListadoReservas = new JLabel("Listado Reservas");
        listadoReservas = new JTextArea();
        listadoReservas.setPreferredSize(new Dimension(150, 500));
        btnRecargar = new JButton("Recargar");
        Box verticalBox = Box.createVerticalBox();

        btnRecargar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                recargarReservas();
            }
        });

        verticalBox.add(lblListadoReservas);
        verticalBox.add(Box.createVerticalStrut(15));
        verticalBox.add(listadoReservas);
        verticalBox.add(Box.createVerticalStrut(15));
        verticalBox.add(btnRecargar);

        this.setTitle("Ver Reservas");
        this.setLayout(new FlowLayout());
        this.add(verticalBox);
        this.setPreferredSize(new Dimension(300, 800));
        this.pack(); // Forza el tamaño de la ventana
    }

    public InterfazCine getInterfazCine() {
        return interfazCine;
    }

    public void setInterfazCine(InterfazCine interfazCine) {
        this.interfazCine = interfazCine;
    }

    public void recargarReservas() {
        this.listadoReservas.setText("");
        String texto = "";
        for (Reserva reserva : this.interfazCine.getReserva()) {
            texto += reserva.getPelicula().getNombre() + " " + reserva.getPelicula().getNombre() + " " + reserva.getPelicula().getSala() + "\n";
        }
        listadoReservas.setText(texto);
    }

}
