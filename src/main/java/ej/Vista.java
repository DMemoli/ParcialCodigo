package ej;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Vista {
    private Modelo m;
    private JButton boton;
    private JFrame f;
    private JTextArea texto, codigo;
    private JScrollPane scrollTexto, scrollCodigo;

    public Vista(Modelo m){
        this.m = m;
        boton = new JButton("Codificar");
        texto = new JTextArea("ingrese el texto a codificar", 10, 30);
        codigo = new JTextArea(10,50);
        scrollTexto = new JScrollPane();
        scrollCodigo = new JScrollPane();
        texto.setLineWrap(true);
        texto.setWrapStyleWord(true);
        texto.setFont(new Font("Monospaced", Font.PLAIN, 16));
        codigo.setLineWrap(true);
        codigo.setWrapStyleWord(true);
        codigo.setFont(new Font("Monospaced", Font.PLAIN, 16));
        scrollTexto.setViewportView(texto);
        scrollCodigo.setViewportView(codigo);

        f = new JFrame("Codificador");
        f.getContentPane().setBackground(Color.BLUE);
        f.getContentPane().setLayout(new FlowLayout());

        f.getContentPane().add(scrollTexto);
        f.getContentPane().add(boton);
        f.getContentPane().add(scrollCodigo);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(930, 270);
        f.setLocationRelativeTo(null);
        f.setVisible(true);


    }
    public void botonCodificar(ActionListener av) {
        boton.addActionListener(av);
    }

    public void codificar(){

        String textoCod = texto.getText();
        String codificado = "";
        for(char c: textoCod.toCharArray()){
            codificado=codificado+m.getCode(c)+" ";
        }
        codigo.setText(codificado);

    }

}
