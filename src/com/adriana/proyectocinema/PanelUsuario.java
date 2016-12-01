package com.adriana.proyectocinema;

import com.adriana.proyectocinema.entidades.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class PanelUsuario extends JDialog {

    private JLabel lblCedula;
    private JLabel lblNombre;
    private JLabel lblTelefono;
    private JLabel lblError;

    private JButton btnGuardar;

    private JTextField txtCedula;
    private JTextField txtNombre;
    private JTextField txtTelefono;


    private List<Usuario> usuarios;


    public PanelUsuario() {
        lblCedula = new JLabel("Cédula");
        lblNombre = new JLabel("Nombre");
        lblTelefono = new JLabel("Teléfono");
        lblError = new JLabel();
        lblError.setForeground(Color.red);

        txtCedula = new JTextField();
        txtCedula.setPreferredSize(new Dimension(100, 18));
        txtNombre = new JTextField();
        txtNombre.setPreferredSize(new Dimension(100, 18));
        txtTelefono = new JTextField();
        txtTelefono.setPreferredSize(new Dimension(100, 18));

        usuarios = new ArrayList<Usuario>();

        Box verticalBox = Box.createVerticalBox();

        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (validarUsuario()) {
                    Usuario usuario = new Usuario();
                    usuario.setCedula(txtCedula.getText());
                    usuario.setNombre(txtNombre.getText());
                    usuario.setTelefono(txtTelefono.getText());
                    usuarios.add(usuario);
                }
            }
        });


        Box horizontalBox;

        // Cedula
        horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(lblCedula);
        horizontalBox.add(Box.createHorizontalStrut(15));
        horizontalBox.add(txtCedula);
        verticalBox.add(horizontalBox);
        verticalBox.add(Box.createVerticalStrut(15));

        // Nombre
        horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(lblNombre);
        horizontalBox.add(Box.createHorizontalStrut(15));
        horizontalBox.add(txtNombre);
        verticalBox.add(horizontalBox);
        verticalBox.add(Box.createVerticalStrut(15));

        // Teléfono
        horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(lblTelefono);
        horizontalBox.add(Box.createHorizontalStrut(15));
        horizontalBox.add(txtTelefono);
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
        this.setTitle("Crear Usuario");
        this.setLayout(new FlowLayout());
        this.add(verticalBox);
        this.setPreferredSize(new Dimension(250, 270));
        this.pack(); // Forza el tamaño de la ventana
    }

    private boolean validarUsuario() {

        // Evita que se guarden valores vacios
        if (txtCedula.getText().isEmpty() || txtNombre.getText().isEmpty() || txtTelefono.getText().isEmpty()) {
            lblError.setText("Ningún campo debe de quedar vacío");
            return Boolean.FALSE;
        }

        //Evita que el usuario repetido en el sistema
        for (Usuario usuario : usuarios) {
            if (usuario.getCedula().equals(txtCedula.getText()) &&
                    usuario.getNombre().equals(txtNombre.getText()) &&
                    usuario.getTelefono().equals(txtTelefono.getText())) {
                lblError.setText("El usuario ya existe");
                return Boolean.FALSE;
            }
        }
        //Ninguna validación fallo
        lblError.setText("Proceso exitoso");
        return Boolean.TRUE;
    }


    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
