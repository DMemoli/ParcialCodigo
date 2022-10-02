package ej;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

public class Controlador {
    Modelo m;
    Vista v;

    public Controlador(Modelo m, Vista v){
        this.m = m;
        this.v = v;
    }
    public void ejecutar(){
        v.botonCodificar(new CodificarListener());
    }
    private class CodificarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            v.codificar();
        }
    }
}
