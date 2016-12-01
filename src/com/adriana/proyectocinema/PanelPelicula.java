package com.adriana.proyectocinema;

import com.adriana.proyectocinema.entidades.Pelicula;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class PanelPelicula extends JDialog {

    private JLabel lblNombre;
    private JLabel lblDirector;
    private JLabel lblGenero;
    private JLabel lblSala;
    private JLabel lblError;

    private JButton btnGuardar;

    private JTextField txtNombre;
    private JTextField txtDirector;
    private JComboBox cmbGenero;
    private JComboBox cmbSala;


    private List<Pelicula> peliculas;


    public PanelPelicula() {
        lblNombre = new JLabel("Nombre");
        lblDirector = new JLabel("Director");
        lblGenero = new JLabel("Género");
        lblSala = new JLabel("Sala");
        lblError = new JLabel();
        lblError.setForeground(Color.red);
        txtNombre = new JTextField();
        txtNombre.setPreferredSize(new Dimension(100, 18));
        txtDirector = new JTextField();
        txtDirector.setPreferredSize(new Dimension(100, 18));
        cmbGenero = new JComboBox();
        cmbGenero.addItem("Acción");
        cmbGenero.addItem("Suspenso");
        cmbGenero.addItem("Romance");
        cmbGenero.addItem("Comedia");
        cmbGenero.addItem("Terror");
        cmbGenero.addItem("Drama");
        cmbGenero.addItem("Ficción");
        cmbGenero.addItem("Infantil");
        cmbSala = new JComboBox();
        cmbSala.addItem("1");
        cmbSala.addItem("2");
        cmbSala.addItem("3");

        peliculas = new ArrayList<Pelicula>();

        Box verticalBox = Box.createVerticalBox();

        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (validarPelicula()) {
                    Pelicula pelicula = new Pelicula();
                    pelicula.setNombre(txtNombre.getText());
                    pelicula.setDirector(txtDirector.getText());
                    pelicula.setGenero((String) cmbGenero.getSelectedItem());
                    pelicula.setSala((String) cmbSala.getSelectedItem());
                    peliculas.add(pelicula);
                }
            }
        });


        Box horizontalBox;
        // Nombre
        horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(lblNombre);
        horizontalBox.add(Box.createHorizontalStrut(15));
        horizontalBox.add(txtNombre);
        verticalBox.add(horizontalBox);
        verticalBox.add(Box.createVerticalStrut(15));

        // Director
        horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(lblDirector);
        horizontalBox.add(Box.createHorizontalStrut(15));
        horizontalBox.add(txtDirector);
        verticalBox.add(horizontalBox);
        verticalBox.add(Box.createVerticalStrut(15));

        // Genero
        horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(lblGenero);
        horizontalBox.add(Box.createHorizontalStrut(15));
        horizontalBox.add(cmbGenero);
        verticalBox.add(horizontalBox);
        verticalBox.add(Box.createVerticalStrut(15));

        // Sala
        horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(lblSala);
        horizontalBox.add(Box.createHorizontalStrut(15));
        horizontalBox.add(cmbSala);
        verticalBox.add(horizontalBox);

        verticalBox.add(Box.createVerticalStrut(15));

        // Botones
        horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(btnGuardar);
        horizontalBox.add(Box.createHorizontalStrut(15));
        verticalBox.add(horizontalBox);
        // Error
        verticalBox.add(Box.createVerticalStrut(15));
        horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(lblError);
        verticalBox.add(horizontalBox);
        verticalBox.add(Box.createVerticalStrut(100));
        this.setTitle("Crear Película");
        this.setLayout(new FlowLayout());
        this.add(verticalBox);
        this.setPreferredSize(new Dimension(250, 270));
        this.pack(); // Forza el tamaño de la ventana
    }

    private boolean validarPelicula() {

        // Evita que se guarden valores vacios
        if (txtNombre.getText().isEmpty() || txtDirector.getText().isEmpty()) {
            lblError.setText("Ningún campo debe de quedar vacío");
            return Boolean.FALSE;
        }

        //Evita la pelicula este repetida en el sistema
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getNombre().equals(txtNombre.getText()) &&
                    pelicula.getDirector().equals(txtDirector.getText()) &&
                    pelicula.getGenero().equals((String) cmbGenero.getSelectedItem()) &&
                    pelicula.getSala().equals((String) cmbSala.getSelectedItem())) {
                lblError.setText("La película ya existe");
                return Boolean.FALSE;
            }
        }
        //Ninguna validación fallo
        lblError.setText("Proceso exitoso");
        return Boolean.TRUE;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }
}
