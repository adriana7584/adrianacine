package com.adriana.proyectocinema;

import com.adriana.proyectocinema.entidades.Pelicula;
import com.adriana.proyectocinema.entidades.Reserva;
import com.adriana.proyectocinema.entidades.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class InterfazCine extends JFrame {


    private PanelPelicula panelPelicula;
    private PanelUsuario panelUsuario;
    private PanelReserva panelReserva;
    private PanelListadoReserva panelListadoReserva;

    private JButton btnCrearPelicula;
    private JButton btnCrearUsuario;
    private JButton btnCrearReserva;
    private JButton btnVerReservas;

    public InterfazCine() {
        // Organizar el panel principal
        this.setTitle("Manejo Sala de Cine");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(800, 500));
        this.setContentPane(new Panel());
        this.pack(); // Le cambia el tamaño a la ventana

        panelPelicula = new PanelPelicula();
        panelUsuario = new PanelUsuario();
        panelReserva = new PanelReserva();
        panelListadoReserva = new PanelListadoReserva();
        panelReserva.setInterfazCine(this);
        panelListadoReserva.setInterfazCine(this);

        // Boton crear pelicula
        btnCrearPelicula = new JButton("Crear Película");
        btnCrearPelicula.setPreferredSize(new Dimension(140, 25));
        //Boton crear usuario
        btnCrearUsuario = new JButton("Crear Usuario");
        btnCrearUsuario.setPreferredSize(new Dimension(140, 25));
        // Boton crear reserva
        btnCrearReserva = new JButton("Crear Reserva");
        btnCrearReserva.setPreferredSize(new Dimension(140, 25));
        // Boton Ver reservas
        btnCrearReserva = new JButton("Crear Reserva");
        btnCrearReserva.setPreferredSize(new Dimension(140, 25));
        // Boton Ver reservas
        btnVerReservas = new JButton("Ver Reservas");
        btnVerReservas.setPreferredSize(new Dimension(140, 25));


        btnCrearPelicula.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                panelPelicula.setVisible(true);
            }
        });

        btnCrearUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                panelUsuario.setVisible(true);
            }
        });


        btnCrearReserva.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                panelReserva.setVisible(true);
                panelReserva.recargarUsuariosPeliculas();
            }
        });

        btnVerReservas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                panelListadoReserva.setVisible(true);
                panelListadoReserva.recargarReservas();
            }
        });


        Box horizontalBox = Box.createHorizontalBox();
        // Boton crear pelicula
        horizontalBox.add(btnCrearPelicula);
        horizontalBox.add(Box.createHorizontalStrut(15));
        // Boton crear usuario
        horizontalBox.add(btnCrearUsuario);
        horizontalBox.add(Box.createHorizontalStrut(15));
        // Boton crear reserva
        horizontalBox.add(btnCrearReserva);
        horizontalBox.add(Box.createHorizontalStrut(15));
        horizontalBox.add(btnVerReservas);
        this.setState(Frame.NORMAL);
        this.add(horizontalBox);
    }

    public static void main(String[] args) {
        InterfazCine interfazCine = new InterfazCine();
        interfazCine.setVisible(true);
    }

    public List<Usuario> getUsuarios() {
        return this.panelUsuario.getUsuarios();
    }

    public List<Pelicula> getPelicula() {
        return this.panelPelicula.getPeliculas();
    }

    public List<Reserva> getReserva() {
        return this.panelReserva.getReservas();
    }


}
