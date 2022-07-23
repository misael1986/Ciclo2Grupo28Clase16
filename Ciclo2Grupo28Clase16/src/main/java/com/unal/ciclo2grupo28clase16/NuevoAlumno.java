package com.unal.ciclo2grupo28clase16;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class NuevoAlumno extends JFrame implements ActionListener {

    public static JLabel labelNombre;
    public JLabel labelApellido;
    public JLabel labelFechaNac;
    public JLabel labelEdad;
    public JLabel labelGrupoSangre;
    public JLabel labelRH;
    public JLabel labelEstadoCivil;

    public JTextField textNombre;
    public JTextField textApellido;
    public JTextField textEdad;

    public JComboBox comboDiaNac;
    public JComboBox comboMesNac;
    public JComboBox comboAnhoNac;
    public JComboBox comboGrupoSangre;
    public JComboBox comboRH;
    public JComboBox comboEstadoCivil;

    public JButton guardarAlumno;

    public JPanel panel;

    public NuevoAlumno() {

        this.setTitle("Nuevo Alumno");

        this.setLayout(null);
        this.panel = new JPanel(null);
        this.setSize(630, 420);

        labelNombre = new JLabel("Nombre:");
        labelApellido = new JLabel("Apellido:");
        labelFechaNac = new JLabel("Fecha de Nacimiento:");
        labelEdad = new JLabel("Edad:");
        labelGrupoSangre = new JLabel("Grupo Sangineo:");
        labelRH = new JLabel("RH:");
        labelEstadoCivil = new JLabel("Estado Civil:");

        textNombre = new JTextField(25);
        textApellido = new JTextField(25);
        textEdad = new JTextField(4);

        String dias[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        comboDiaNac = new JComboBox(dias);
        for (int dia = 11; dia <= 31; dia++) {
            comboDiaNac.addItem(dia);
        }
        comboMesNac = new JComboBox();
        comboMesNac.addItem("Enero");
        comboMesNac.addItem("Febrero");
        comboMesNac.addItem("Marzo");
        comboMesNac.addItem("Abril");
        comboMesNac.addItem("Mayo");
        comboMesNac.addItem("Junio");
        comboMesNac.addItem("Julio");
        comboMesNac.addItem("Agosto");
        comboMesNac.addItem("Septiembre");
        comboMesNac.addItem("Octubre");
        comboMesNac.addItem("Noviembre");
        comboMesNac.addItem("Diciembre");

        comboAnhoNac = new JComboBox();

        int anho = Calendar.getInstance().get(Calendar.YEAR);

        for (int i = 1900; i <= anho; i++) {
            comboAnhoNac.addItem(i);
        }

        String grupos[] = {"A", "B", "AB", "O"};
        comboGrupoSangre = new JComboBox(grupos);
        String rhs[] = {"+", "-"};
        comboRH = new JComboBox(rhs);
        comboEstadoCivil = new JComboBox();
        comboEstadoCivil.addItem("Soltero");
        comboEstadoCivil.addItem("Casado");
        comboEstadoCivil.addItem("Viudo");
        comboEstadoCivil.addItem("Separado");
        comboEstadoCivil.addItem("Union Libre");
        comboEstadoCivil.addItem("Divorciado");

        guardarAlumno = new JButton("Guardar");

        this.panel.add(this.labelNombre);
        labelNombre.setBounds(47, 12, 112, 30);
        this.panel.add(this.textNombre);
        textNombre.setBounds(201, 12, 150, 30);

        this.panel.add(this.labelApellido);
        labelApellido.setBounds(49, 52, 110, 30);
        this.panel.add(this.textApellido);
        textApellido.setBounds(201, 52, 150, 30);

        this.panel.add(this.labelFechaNac);
        labelFechaNac.setBounds(49, 102, 138, 30);
        this.panel.add(this.comboDiaNac);
        comboDiaNac.setBounds(201, 102, 80, 30);
        this.panel.add(this.comboMesNac);
        comboMesNac.setBounds(291, 102, 80, 30);
        this.panel.add(this.comboAnhoNac);
        comboAnhoNac.setBounds(381, 102, 80, 30);

        this.panel.add(this.labelEdad);
        labelEdad.setBounds(49, 152, 110, 30);
        this.panel.add(this.textEdad);
        textEdad.setBounds(201, 152, 80, 30);
        textEdad.setEditable(false);

        this.panel.add(this.labelGrupoSangre);
        labelGrupoSangre.setBounds(49, 202, 138, 30);
        this.panel.add(this.comboGrupoSangre);
        comboGrupoSangre.setBounds(201, 202, 80, 30);
        this.panel.add(this.labelRH);
        labelRH.setBounds(292, 202, 55, 30);
        this.panel.add(this.comboRH);
        comboRH.setBounds(361, 202, 80, 30);

        this.panel.add(this.labelEstadoCivil);
        labelEstadoCivil.setBounds(49, 242, 138, 30);
        this.panel.add(this.comboEstadoCivil);
        comboEstadoCivil.setBounds(201, 242, 170, 30);

        this.panel.add(this.guardarAlumno);
        guardarAlumno.setBounds(245, 292, 150, 50);
        guardarAlumno.addActionListener(this);
        panel.setBounds(0, 0, 600, 400);

        this.add(panel);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int edad = 0;
        boolean delMes = false;
        int anhoActual = Calendar.getInstance().get(Calendar.YEAR);
        int mesActual = Calendar.getInstance().get(Calendar.MONTH);
        int diaActual = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int anhosNacimiento = Integer.parseInt(this.comboAnhoNac.getSelectedItem().toString());
        edad = anhoActual - anhosNacimiento;
        if (mesActual > this.comboAnhoNac.getSelectedIndex()) {
            edad = edad - 1;
        } else if (diaActual < Integer.parseInt(this.comboDiaNac.getSelectedItem().toString())) {
            edad = edad - 1;
        }
        this.textEdad.setText("" + edad);

        Alumno nuevo = new Alumno();
        nuevo.setNombre(this.textNombre.getText());
        nuevo.setApellido(this.textApellido.getText());
        nuevo.setEdad(Integer.parseInt(this.textEdad.getText()));
        nuevo.setFechaNacimiento(new Date(Integer.parseInt(this.comboAnhoNac.getSelectedItem().toString()),
                this.comboMesNac.getSelectedIndex(),
                Integer.parseInt(this.comboDiaNac.getSelectedItem().toString())
        ));
        nuevo.setGrupoSangineo(this.comboGrupoSangre.getSelectedItem().toString());
        nuevo.setRH(this.comboRH.getSelectedItem().toString().charAt(0));
        nuevo.setEstadoCivil(this.comboEstadoCivil.getSelectedItem().toString());
        if (this.GuardarTXT(nuevo)) {
            JOptionPane.showMessageDialog(rootPane, "Exito al guardar");
        } else {
            JOptionPane.showMessageDialog(rootPane, "problema  al guardar");
        }

    }

    public static boolean GuardarTXT(Alumno a) {
        boolean exito = false;

        String fileName = a.getNombre() + "_" + a.getApellido() + ".txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(labelNombre.getText() + a.getNombre() + "\n");
            writer.write("Apellido:" + a.getApellido());
            writer.write("Edad:" + a.getEdad());
            writer.write("Grupo Sangineo:" + a.getGrupoSangineo());
            writer.write("Factor RH:" + a.getRH());
            writer.write("Estado Civil:" + a.getEstadoCivil());

            writer.close();
            exito = true;
        } catch (IOException io) {
            io.printStackTrace();
        }
        return exito;

    }

}
