package com.enanaroja.calculadora_v01;

import Controller.KeyboardEvent;
import Controller.MouseEvent;
import View.Ventana;
import java.awt.EventQueue;
/**
 * @author Miguel G.G.G.
 */
public class Calculadora_v01 {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var interfaz = new Ventana();
            var key = new KeyboardEvent(interfaz);
            interfaz.addKeyListener(key);
            var mouse = new MouseEvent(interfaz);
            mouse.clickOn();//inicia los componentes del teclado
        });
    }
}
