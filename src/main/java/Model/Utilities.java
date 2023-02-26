package Model;

/**
 * @author Miguel G.G.G.
 */
public class Utilities {
    
    //atributos
    public boolean isPlusSign; //signo de suma
    public boolean isMinusSign; //signo de resta
    public boolean isMultiplicationSign; //signo de multiplicacíon
    public boolean isDivisionSign; //signo de división
    public boolean isDotSign;  //punto
    
    ///////////////
    
    public Utilities(){ //constructor
        isPlusSign = false;
        isMinusSign = false;
        isMultiplicationSign = false;
        isDivisionSign = false;
        isDotSign = false; 
    }
    //Evitar operadores o signos repetidos
    public void DontRepeatSign(String cadena, String signo){
        //String signos = "+-*/.()";
        int end = cadena.length()-1; //posicion del caracter final del argumento cadena
        switch(signo){
            case "+" -> {
                if(cadena.length() >= 1){
                    isPlusSign = signo.equals(Character.toString(cadena.charAt(end)));

                    isMinusSign = false;
                    isMultiplicationSign = false;
                    isDivisionSign = false;
                    isDotSign = false;
                }
            }
            case "-" -> {
                if(cadena.length() >= 1){
                    isMinusSign = signo.equals(Character.toString(cadena.charAt(end)));
                    
                    isPlusSign = false;
                    isMultiplicationSign = false;
                    isDivisionSign = false;
                    isDotSign = false;
                }
            }
            case "*" -> {
                if(cadena.length() >= 1){
                    isMultiplicationSign = signo.equals(Character.toString(cadena.charAt(end)));
                    
                    isPlusSign = false;
                    isMinusSign = false;
                    isDivisionSign = false;
                    isDotSign = false;
                }
            }
            case "/" -> {
                if(cadena.length() >= 1){
                    isDivisionSign = signo.equals(Character.toString(cadena.charAt(end)));
                    
                    isPlusSign = false;
                    isMinusSign = false;
                    isMultiplicationSign = false;
                    isDotSign = false;
                }
            }
            case "." -> {
                if(cadena.length() >= 1){
                    isDotSign = signo.equals(Character.toString(cadena.charAt(end)));
                    
                    isPlusSign = false;
                    isMinusSign = false;
                    isMultiplicationSign = false;
                    isDivisionSign = false;
                }
            }
        }
    }//fin de DontRepeatSign()

    //elimina el ultimo caracter de la cadena
    //end: caracter final
    //first: cracter primeroDontRepeatSign
    
    public String deleteCharEnd(String arg){
        String retorno = "";
        for(var i  = 0; i< arg.length()-1; i++){
            retorno += Character.toString(arg.charAt(i));
        }
        return retorno;
    }/////////////////////////////////////    
    //Función que evita que el punto se repita en un numero
    public boolean DontRepeatOpertors(String cadena){
        var retorno = false;
        String lista = "+-/*";
        for(int i = 0; i < lista.length(); i++){
            //if(cadena.charAt(cadena.length()-1) == lista.charAt(i)) retorno =  true;
            if(cadena.length() < 1) retorno =  true;
            else{
                if(cadena.charAt(cadena.length()-1) == lista.charAt(i)) retorno =  true;
            }
        }
        return retorno;
    }
    
    public boolean charsAllowed(char c){
        boolean retorno = true;
        String cadena = "0123456789";
        for(var i : cadena.toCharArray()){
            retorno = charAllowed(c, i);
            if(retorno) break;
        }
        return retorno;
    }
    private boolean charAllowed(char c, char d){
        return c == d;
    }
}