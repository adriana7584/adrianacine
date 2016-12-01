package com.adriana.proyectocinema;

import com.adriana.proyectocinema.entidades.Pelicula;
import com.adriana.proyectocinema.entidades.Reserva;
import com.adriana.proyectocinema.entidades.Reserva;
import com.adriana.proyectocinema.entidades.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class PanelReserva extends JDialog {

    private JLabel lblPelicula;
    private JLabel lblUsuario;
    private JLabel lblError;

    private JButton btnGuardar;
    private JButton btnRecargar;

    private JComboBox cmbPelicula;
    private JComboBox cmbUsuario;


    private List<Reserva> reservas;

    private InterfazCine interfazCine;

    public PanelReserva() {
        lblPelicula = new JLabel("Película");
        lblUsuario = new JLabel("Usuario");
        lblError = new JLabel();
        lblError.setForeground(Color.red);
        cmbUsuario = new JComboBox();
        cmbUsuario.setPreferredSize(new Dimension(150, 20));
        cmbPelicula = new JComboBox();
        cmbPelicula.setPreferredSize(new Dimension(150, 20));

        reservas = new ArrayList<Reserva>();

        Box verticalBox = Box.createVerticalBox();

        btnGuardar = new JButton("Guardar");
        btnRecargar = new JButton("Recargar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (validarReserva()) {
                    Reserva reserva = new Reserva();
                    reserva.setPelicula((Pelicula) cmbPelicula.getSelectedItem());
                    reserva.setUsuario((Usuario) cmbUsuario.getSelectedItem());
                    reservas.add(reserva);
                }
            }
        });

        btnRecargar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                recargarUsuariosPeliculas();
            }
        });


        Box horizontalBox;


        // Película
        horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(lblPelicula);
        horizontalBox.add(Box.createHorizontalStrut(15));
        horizontalBox.add(cmbPelicula);
        verticalBox.add(horizontalBox);
        verticalBox.add(Box.createVerticalStrut(15));

        // Usuarios
        horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(lblUsuario);
        horizontalBox.add(Box.createHorizontalStrut(15));
        horizontalBox.add(cmbUsuario);
        verticalBox.add(horizontalBox);

        verticalBox.add(Box.createVerticalStrut(15));

        // Botones
        horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(btnGuardar);
        horizontalBox.add(Box.createHorizontalStrut(15));
        horizontalBox.add(btnRecargar);

        verticalBox.add(horizontalBox);

        // Error
        verticalBox.add(Box.createVerticalStrut(15));
        horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(lblError);
        verticalBox.add(horizontalBox);
        verticalBox.add(Box.createVerticalStrut(100));

        this.setTitle("Crear Reservas");
        this.setLayout(new FlowLayout());
        this.add(verticalBox);
        this.setPreferredSize(new Dimension(300, 250));
        this.pack(); // Forza el tamaño de la ventana
    }

    private boolean validarReserva() {
        //Evita la reserva este repetida en el sistema
        for (Reserva reserva : reservas) {
            if (reserva.getUsuario().equals(cmbUsuario.getSelectedItem()) &&
                    reserva.getPelicula().equals(cmbPelicula.getSelectedItem())) {
                lblError.setText("La reserva ya existe");
                return Boolean.FALSE;
            }
        }
        //Ninguna validación fallo
        lblError.setText("Proceso exitoso");
        return Boolean.TRUE;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public InterfazCine getInterfazCine() {
        return interfazCine;
    }

    public void setInterfazCine(InterfazCine interfazCine) {
        this.interfazCine = interfazCine;
    }

    public void recargarUsuariosPeliculas() {
        this.cmbPelicula.removeAllItems();
        this.cmbUsuario.removeAllItems();
        for (Pelicula pelicula : this.interfazCine.getPelicula()) {
            cmbPelicula.addItem(pelicula);
        }
        for (Usuario usuario : this.interfazCine.getUsuarios()) {
            cmbUsuario.addItem(usuario);
        }
    }

}
