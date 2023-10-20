/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa;

import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

import java.text.*;

/**
 *
 * @author david
 */
   
public class Empresa extends JFrame{

        private JLabel nombreL;
        private JLabel numL;
        private JLabel sueldoL;
        private JLabel sueldoMaxL;
        private JLabel fechaAltaL;
    
        private static String nombreStr = "Nombre: ";
        private static String numStr = "Numero: ";
        private static String sueldoStr = "Sueldo: ";
        private static String sueldoMaxStr = "Sueldo maximo: ";
        private static String fechaAltaStr = "Fecha de alta: ";
        
        private TextField nombreF;
        private TextField numF;
        private TextField sueldoF;
        private TextField sueldoMaxF;
        private TextField fechaAltaF;
        
        public Empresa(){
            super("Empresa");
            
            nombreL = new JLabel(nombreStr);
            numL = new JLabel(numStr);
            sueldoL = new JLabel(sueldoStr);
            sueldoMaxL = new JLabel(sueldoMaxStr);
            fechaAltaL = new JLabel(fechaAltaStr);
            
            nombreF = new TextField(20);
            numF = new TextField(20);
            sueldoF = new TextField(20);
            sueldoMaxF = new TextField(20);
            fechaAltaF = new TextField(20);
            
            nombreF.setText(Empleado.act.getNombre());
            numF.setText(""+Empleado.act.getNum());
            sueldoF.setText(""+Empleado.act.getSueldo());
            sueldoMaxF.setText(""+Empleado.act.getSueldoMax());
            fechaAltaF.setText(""+(Empleado.act.getFechaAlta()).toInstant());
            
            JButton button = new JButton("Anterior");
            JButton button2 = new JButton("Siguiente");
            JButton button3 = new JButton("Crear");
            JButton buttonAccept = new JButton("Aceptar");
            JButton buttonCancel = new JButton("Cancelar");
            
            //Para que el boton de retroceder aparezca desactivado al iniciar el programa
            button.setEnabled(false);
            
            
        JPanel labelP = new JPanel();
        labelP.setBorder(BorderFactory.createEmptyBorder(
                                        30, //arriba
                                        30, //izquierda
                                        10, //abajo
                                        30) //derecha
                                        );
        labelP.setLayout(new GridLayout(0, 1));
        labelP.add(nombreL);
        labelP.add(numL);
        labelP.add(sueldoL);
        labelP.add(sueldoMaxL);
        labelP.add(fechaAltaL);
        
        JPanel fieldP = new JPanel();
        fieldP.setBorder(BorderFactory.createEmptyBorder(
                                        30, //arriba
                                        30, //izquierda
                                        10, //abajo
                                        30) //derecha
                                        );
        fieldP.setLayout(new GridLayout(0, 1));
        fieldP.add(nombreF);
        fieldP.add(numF);
        fieldP.add(sueldoF);
        fieldP.add(sueldoMaxF);
        fieldP.add(fechaAltaF);
        
        JPanel buttonP = new JPanel();
        buttonP.setBorder(BorderFactory.createEmptyBorder(
                                        30, //arriba
                                        30, //izquierda
                                        10, //abajo
                                        30) //derecha
                                        );
        buttonP.setLayout(new GridLayout(0, 1));
        buttonP.add(button2);
        buttonP.add(button);
        buttonP.add(button3);
        
        JPanel botones2 = new JPanel();
        botones2.add(buttonAccept);
        botones2.add(buttonCancel);
        
        JPanel contenido = new JPanel();
        contenido.setBorder(BorderFactory.createEmptyBorder(
                                        50, //arriba
                                        50, //izquierda
                                        50, //abajo
                                        50) //derecha
                                        );
        contenido.setLayout(new BorderLayout());
        contenido.add(labelP, BorderLayout.CENTER);
        contenido.add(fieldP, BorderLayout.EAST);
        contenido.add(buttonP, BorderLayout.SOUTH);
        setContentPane(contenido);
        
        
        //BOTON PARA AVANZAR
            button2.addActionListener(new ActionListener() {  // Evento de boton.
            public void actionPerformed(ActionEvent e) {
                Empleado.avanzar();
                nombreF.setText(Empleado.act.getNombre());
                numF.setText(""+Empleado.act.getNum());
                sueldoF.setText(""+Empleado.act.getSueldo());
                sueldoMaxF.setText(""+Empleado.act.getSueldoMax());
                fechaAltaF.setText(""+(Empleado.act.getFechaAlta()).toInstant());
                
                //CONDICION PARA ACTIVAR/DESACTIVAR LOS BOTONES
                if(Empleado.esUlt() == true)
                {
                    button2.setEnabled(false); //DESACTIVAR AVANZAR
                }
                if(Empleado.esPrimero() == false) 
                {
                    button.setEnabled(true); //ACTIVAR RETROCEDER
                }
            }
        });
            
            //BOTON PARA RETROCEDER
            button.addActionListener(new ActionListener() {  // Evento de boton.
            public void actionPerformed(ActionEvent e) {
                Empleado.retroceder();
                nombreF.setText(Empleado.act.getNombre());
                numF.setText(""+Empleado.act.getNum());
                sueldoF.setText(""+Empleado.act.getSueldo());
                sueldoMaxF.setText(""+Empleado.act.getSueldoMax());
                fechaAltaF.setText(""+(Empleado.act.getFechaAlta()).toInstant());
                
                //CONDICION PARA ACTIVAR/DESACTIVAR LOS BOTONES
                if(Empleado.esPrimero() == true)
                {
                    button.setEnabled(false); //DESACTIVAR RETROCEDER
                }
                if(Empleado.esUlt() == false)
                {
                    button2.setEnabled(true); //ACTIVAR AVANZAR
                }
            }
        });
            
            //BOTON DE CREAR
            button3.addActionListener(new ActionListener() {  // Evento de boton.
            public void actionPerformed(ActionEvent e) {
                //BORRO EL PANEL ANTIGUO
                contenido.remove(buttonP);
                //AÑADO EL NUEVO PANEL
                contenido.add(botones2, BorderLayout.SOUTH);
                //VACIO LOS TEXTFIELDS
                vaciarDatos();
                setContentPane(contenido);
                pack();
                fechaAltaF.setEnabled(false);
            }
        });
           //BOTON DE ACEPTAR 
            buttonAccept.addActionListener(new ActionListener() {  // Evento de boton.
            public void actionPerformed(ActionEvent e) {
                
                if(nombreF.getText().isEmpty() || numF.getText().isEmpty() || sueldoF.getText().isEmpty() || sueldoMaxF.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(contenido, "Debes rellenar todos los campos.");
                }
                else
                {
                    try
                    {
                        new Empleado(nombreF.getText(), Integer.parseInt(numF.getText()), Integer.parseInt(sueldoF.getText()), Integer.parseInt(sueldoMaxF.getText()));
                    }
                    catch(NumberFormatException n)
                    {
                        JOptionPane.showMessageDialog(contenido, "Introduce números en los campos numéricos");
                    }
                    //BORRO LOS BOTONES DE ACEPTAR/CANCELAR
                    contenido.remove(botones2);
                    //AÑADO BOTONES ANTERIOR/CREAR/SIGUIENTE
                    contenido.add(buttonP, BorderLayout.SOUTH);
                    //DESACTIVO BOTON ANTERIOR
                    button.setEnabled(false);
                    //ACTIVO BOTON DE SIGUIENTE
                    button2.setEnabled(true);
                    //MUESTRO LOS EMPLEADOS
                    nombreF.setText(Empleado.act.getNombre());
                    numF.setText(""+Empleado.act.getNum());                
                    sueldoF.setText(""+Empleado.act.getSueldo());
                    sueldoMaxF.setText(""+Empleado.act.getSueldoMax());
                    fechaAltaF.setText(""+(Empleado.act.getFechaAlta()).toInstant());

                    setContentPane(contenido);
                    pack();

                    fechaAltaF.setEnabled(true);
                }
            }
        });
            //BOTON DE CANCELAR
            buttonCancel.addActionListener(new ActionListener() {  // Evento de boton.
            public void actionPerformed(ActionEvent e) {
                //BORRO LOS BOTONES ACEPTAR/CANCELAR
                contenido.remove(botones2);
                //AÑADO BOTONES ANTERIOR/CREAR/SIGUIENTE
                contenido.add(buttonP, BorderLayout.SOUTH);
                
                //MUESTRO LOS EMPLEADOS
                nombreF.setText(Empleado.act.getNombre());
                numF.setText(""+Empleado.act.getNum());
                sueldoF.setText(""+Empleado.act.getSueldo());
                sueldoMaxF.setText(""+Empleado.act.getSueldoMax());
                fechaAltaF.setText(""+(Empleado.act.getFechaAlta()).toInstant());
                
                setContentPane(contenido);
                pack();
                
                fechaAltaF.setEnabled(true);
            }
        });
        
        
        }
        
        
        
        
        
     private void vaciarDatos()
     {
         nombreF.setText("");
         sueldoF.setText("");
         numF.setText("");
         sueldoMaxF.setText("");
         fechaAltaF.setText("");
     }
        
        
        
        
    public static void main(String[] args) 
    {
        Empleado e1 = new Empleado("David", 1, 1400, 2000);
        Empleado e2 = new Empleado("Juan Pablo", 2, 1250, 1700);
        Empleado e3 =new Empleado("Pedro", 3, 1300, 1900);
        Empleado e4 = new Empleado("Antonio", 4, 2000, 2500);
        
        final Empresa app = new Empresa();

        //Lo que pasa si cerramos la ventana
        app.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        app.pack();
        app.setVisible(true);  
    }
}
