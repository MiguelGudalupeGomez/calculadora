package Controller;

import Model.Operations;
import View.Ventana;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Model.Utilities;
import java.text.DecimalFormat;

/**
 * @Miguel G.G.G.
 */
public class KeyboardEvent implements KeyListener{
    private String cadGlobal;
    private final Ventana interfaz;
    private final Operations operation;
    private final Utilities util;
    private final DecimalFormat outFormat;
    public KeyboardEvent(Ventana interfaz){
        this.interfaz = interfaz;
        util = new Utilities();
        operation = new Operations();
        outFormat = new DecimalFormat("#");
        cadGlobal = "";
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
        
    @Override
    public void keyPressed(KeyEvent e) {
        var cadena = this.interfaz.pantalla.getText();
        
        var B =  e.getKeyChar();
        var other = e.getKeyCode();
        ////
        if(util.charsAllowed(B)){//------------------------------>teclas para numeros y operadores
            this.interfaz.pantalla.setText(cadena + B);
            this.interfaz.pantalla2.setText("");
        }else if(other == KeyEvent.VK_ENTER){//------------------>Tecla ENTER para realizar la operación
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
            
        }else if(other == KeyEvent.VK_BACK_SPACE){ //------------>tecla BACK SPACE para borrar un caracter
            cadena = this.util.deleteCharEnd(cadena);
            this.interfaz.pantalla.setText(cadena);
            this.interfaz.pantalla2.setText("");
        }else if(other == KeyEvent.VK_ESCAPE){//----------------->tecla ESCAPE para limpira la pantalla
            this.interfaz.pantalla.setText("");
            this.interfaz.pantalla2.setText("");
        }
        else if(other == KeyEvent.VK_PLUS || other == 107){//---->tecla +
            
            this.util.DontRepeatSign(cadena, "+");
            boolean p = this.util.DontRepeatOpertors(cadena);
            if(!this.util.isPlusSign){
                if(!p) this.interfaz.pantalla.setText(cadena + "+");
            }
        }else if(other == KeyEvent.VK_MINUS || other == 109){//-->recla -
            
            char c = 00;
            if(cadena.length() > 0) c = cadena.charAt(cadena.length()-1);
            this.util.DontRepeatSign(cadena, "-");
            boolean p = this.util.DontRepeatOpertors(cadena);
            if(cadena.length() == 0){
                this.interfaz.pantalla.setText(cadena + "-");
            }else{
                if(c == '/' || c == '*') this.interfaz.pantalla.setText(cadena + "-");
                else if(!p) this.interfaz.pantalla.setText(cadena + "-");
            }
        }
        else if(other == KeyEvent.VK_MULTIPLY){//---------------->tecla de multiplicacion
            
            this.util.DontRepeatSign(cadena, "*");
            boolean p = this.util.DontRepeatOpertors(cadena);
            //verficamos que el signo * no se repita, de lo contrario lo agregagmos
            if(!this.util.isMultiplicationSign) if(!p) this.interfaz.pantalla.setText(cadena + "*");
        }
        else if(other == KeyEvent.VK_DIVIDE){//------------------>tecla de división
            
            this.util.DontRepeatSign(cadena, "/");
            boolean p = this.util.DontRepeatOpertors(cadena);
            //Concatena / si no hay un signo / o * en la ultima posicion de la cadena
            if(!this.util.isDivisionSign) if(!p)this.interfaz.pantalla.setText(cadena + "/");
        }else if(other == KeyEvent.VK_PERIOD){//------------------>tecla punto
            //si la cadena esta vacia imprimir 0.
            if(cadena.length() == 0)this.interfaz.pantalla.setText("0.");
            else{
                if(cadena.length() > 0){
                    var c = cadena.charAt(cadena.length()-1);
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
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
}
