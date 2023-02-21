package Controller;

import Model.Operations;
import Model.Utilities;
import View.Ventana;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

/**
 * @author Miguel G. Gómez Guzmán
 */
public class MouseEvent{
    private final Ventana interfaz;
    private final Utilities util;
    private final Operations operation;
    DecimalFormat outFormat;
    public MouseEvent(Ventana interfaz){
        
        outFormat = new DecimalFormat("#");
        this.interfaz = interfaz;
        this.util = new Utilities();
        clickOn();
        operation = new Operations();
    }
    
    //funcion que contiene todos los eventos al hacer click en los botones de la calculadora
    private void clickOn(){
        //botones numericos
        this.interfaz.numericButtons[0].addActionListener((ActionEvent e) ->{
            this.interfaz.pantalla.setText(this.interfaz.pantalla.getText()+"0");
        });
        this.interfaz.numericButtons[1].addActionListener((ActionEvent e) ->{
            this.interfaz.pantalla.setText(this.interfaz.pantalla.getText()+"1");
        });
        this.interfaz.numericButtons[2].addActionListener((ActionEvent e) ->{
            this.interfaz.pantalla.setText(this.interfaz.pantalla.getText()+"2");
        });
        this.interfaz.numericButtons[3].addActionListener((ActionEvent e) ->{
            this.interfaz.pantalla.setText(this.interfaz.pantalla.getText()+"3");
        });
        this.interfaz.numericButtons[4].addActionListener((ActionEvent e) ->{
            this.interfaz.pantalla.setText(this.interfaz.pantalla.getText()+"4");
        });
        this.interfaz.numericButtons[5].addActionListener((ActionEvent e) ->{
            this.interfaz.pantalla.setText(this.interfaz.pantalla.getText()+"5");
        });
        this.interfaz.numericButtons[6].addActionListener((ActionEvent e) ->{
            this.interfaz.pantalla.setText(this.interfaz.pantalla.getText()+"6");
        });
        this.interfaz.numericButtons[7].addActionListener((ActionEvent e) ->{
            this.interfaz.pantalla.setText(this.interfaz.pantalla.getText()+"7");
        });
        this.interfaz.numericButtons[8].addActionListener((ActionEvent e) ->{
            this.interfaz.pantalla.setText(this.interfaz.pantalla.getText()+"8");
        });
        this.interfaz.numericButtons[9].addActionListener((ActionEvent e) ->{
            this.interfaz.pantalla.setText(this.interfaz.pantalla.getText()+"9");
        });
        this.interfaz.punto.addActionListener((ActionEvent e) ->{
            var copy = this.interfaz.pantalla.getText();
            
            //si la cadena esta vacia imprimir 0.
            if(copy.length() == 0)this.interfaz.pantalla.setText("0.");
            else{
                if(copy.length() > 0){
                    var c = copy.charAt(copy.length()-1);
                    this.util.DontRepeatSign(this.interfaz.pantalla.getText(), ".");
                    if(!this.util.isDotSign){
                        if(c == '+' || c == 'c' || c == '*' || c == '/'){
                            //si se agrega un punto cuando hay un operador en la posicion de atras del arreglo
                            //se agrega .0
                            this.interfaz.pantalla.setText(this.interfaz.pantalla.getText()+"0.");
                        }else{
                            //simplemente agrega el punto
                            this.interfaz.pantalla.setText(this.interfaz.pantalla.getText()+".");
                        }
                    }
                }
            }
        });
        
        /*botones para operar*/
        //boton para sumar
        this.interfaz.operationButtons[0].addActionListener((ActionEvent e) ->{
            var cadena = this.interfaz.pantalla.getText();
            this.util.DontRepeatSign(cadena, "+");
            boolean p = this.util.DontRepeatOpertors(cadena);
            if(!this.util.isPlusSign){
                if(!p) this.interfaz.pantalla.setText(cadena + "+");
            }
        });
        //boton para restar
        this.interfaz.operationButtons[1].addActionListener((ActionEvent e) ->{
            
            var cadena = this.interfaz.pantalla.getText();
            var c = cadena.charAt(cadena.length()-1);
            this.util.DontRepeatSign(cadena, "-");
            boolean p = this.util.DontRepeatOpertors(cadena);
            if(cadena.length() == 0){
                this.interfaz.pantalla.setText(cadena + "-");
            }else{
                if(c == '/' || c == '*') this.interfaz.pantalla.setText(cadena + "-");
                else if(!p) this.interfaz.pantalla.setText(cadena + "-");
            }
        });
        //boton para multiplicar
        this.interfaz.operationButtons[2].addActionListener((ActionEvent e) ->{
            var cadena = this.interfaz.pantalla.getText();
            this.util.DontRepeatSign(cadena, "*");
            boolean p = this.util.DontRepeatOpertors(cadena);
            //verficamos que el signo * no se repita, de lo contrario lo agregagmos
            if(!this.util.isMultiplicationSign) if(!p) this.interfaz.pantalla.setText(cadena + "*");
        });
        //boton para dividir
        this.interfaz.operationButtons[3].addActionListener((ActionEvent e) ->{
            var cadena = this.interfaz.pantalla.getText();
            this.util.DontRepeatSign(cadena, "/");
            boolean p = this.util.DontRepeatOpertors(cadena);
            //Concatena / si no hay un signo / o * en la ultima posicion de la cadena
            if(!this.util.isDivisionSign) if(!p)this.interfaz.pantalla.setText(cadena + "/");
        });
        
        //limpiar la pantalla
        //boton AC
        this.interfaz.limpiar.addActionListener((ActionEvent e)->{
            this.interfaz.pantalla.setText("");
            this.interfaz.pantalla2.setText("");
        });
        
        //borra el ultimo caracter de la pantalla
        //boton DEL
        this.interfaz.borrar.addActionListener((ActionEvent e)->{
            //Eliminamos un caracter de la pantalla
            String texto = this.interfaz.pantalla.getText();
            texto = this.util.deleteCharEnd(texto);
            this.interfaz.pantalla.setText(texto);
            this.interfaz.pantalla2.setText("");
        });
        
        this.interfaz.resultado.addActionListener((ActionEvent e)->{
            String cadena = this.interfaz.pantalla.getText();
            char c = cadena.charAt(cadena.length()-1);
            if(!"".equals(cadena)){
                if(c == '+' || c == '-' || c == '*' || c == '/' ||c == '.'){
                    
                }else{
                    var suma_resta_array = this.operation.subCadena_suma_resta(cadena); //se crea un arreglo de Strings separando las operciones en suma y resta
                    for(var i = 0; i < suma_resta_array.length; i++){
                        //se separan las operaciones multplicar y dividir
                        var producto_division_array = this.operation.subCadena_producto_division(suma_resta_array[i]);
                        //se obitienen los resultados de dividir y multiplicar
                        var resultado_producto_division = this.operation.resultadoProductoDivision(producto_division_array);
                        //se almacena el resultado de la operacion en la misma posicion del arreglo principal
                        suma_resta_array[i] = resultado_producto_division;
                    }
                    //se obtiene los resultados totales
                    var resultado = this.operation.resultadoSumaResta(suma_resta_array);

                    //se muestra en panalla el resultado total
                    //si el valor es entero, entonces no se imprime en decimal
                    if(resultado % 1 == 0) this.interfaz.pantalla2.setText("= " + outFormat.format(resultado));
                    //imprime el valor en decimal
                    else this.interfaz.pantalla2.setText("= " + Double.toString(resultado));
                }
            }
        });
    }
}