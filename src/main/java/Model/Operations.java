package Model;
/**
 * @author Miguel G.G.G.
 */
public class Operations {
    //Obtener tamaño del arreglo
    private int sizeForArray(String str){
        var retorno = 0;
        if(str.charAt(0) != '+' || str.charAt(0) != '-') retorno++;
        for(var i = 0; i < str.length(); i++){
            var c = str.charAt(i);
            boolean d = false;
            if(i>0) d = str.charAt(i-1) == '*' || str.charAt(i-1) == '/';
            if('+' == c || '-' == c)if(!d)retorno++;
        }
        return retorno;
    }//fin de la funcion
    //separar cadena en terminos de suma o resta, mientras el caracter anterior no sea signo de division o multiplicacion
    //paso #1
    public String[] subCadena_suma_resta(String str){
        var counter = 0;
        var size = sizeForArray(str);
        String[] retorno = new String[size];
        for(var i = 0; i < size; i++){retorno[i] = "";} //rellenamos el arreglo con un string vacio
        
        for(var i = 0; i < str.length(); i++){
            var c = str.charAt(i);
            boolean d = false;
            if(i>0) d = str.charAt(i-1) == '*' || str.charAt(i-1) == '/';
            if('+' == c || '-' == c){
                if(!d){
                    counter++;
                    retorno[counter] += Character.toString(c);
                }else retorno[counter] += Character.toString(c);
            } else retorno[counter] += Character.toString(c);
        }
        return retorno;
    }//fin de la funcion
    
    //Función para separar la cadena en términos de division y multiplicacion
    //devuelve un arreglo almacenando en cada posicion un numero y un operador de division o multiplicacion en la
    //por ejemplo:
    //Sring str = "6/4*-8";
    //resultado:
    //          array[0] = "6"
    //          array[1] = "/"
    //          array[2] = "4"
    //          array[3] = "*"
    //          array[4] = "-8"
    //siguiente posicion y asi sucesivamente
    //paso #2
    public String[] subCadena_producto_division(String str){
        var count = 0;
        for(var i : str.toCharArray()){if(i == '*' || i == '/') count += 2; } //obtenemos el tamaño para el nuero arreglo
        var retorno = new String[count+1];//se crea un arreglo para almacenar los componentes deseados
        for(var i = 0; i<= count; i++) retorno[i] = ""; //se rellena el arreglo con una cadena vacía para no guardar el valor null
        
        count = 0; //variable para llevar el conteo para almacenar corretamente los valores
        for(var i : str.toCharArray()){
            if(i == '*' || i == '/'){
                count++;
                retorno[count] += Character.toString(i);//se guarda un operador de division o multiplicacion en una sola posicion del arreglo
                count++;
            } else retorno[count] += Character.toString(i);
        }
        return retorno;   
    }
    //funcion para resolver multiplicaciones y divisiones
    //devuelve el resultado en cadena
    //paso #3
    public String resultadoProductoDivision(String[] cadena){
       for(var i = 0; i < cadena.length; i++){
           if(i > 0 || i <cadena.length && !"".equals(cadena[i])){//condicion para no intentar leer posiciones del arreglo que no existen
               switch(cadena[i]){
                   case "*" -> {
                       try{
                           //el numero anterior se multiplica por el numero siguiente y se guarda en una variable temporal
                           var resultadoTemporal = Double.parseDouble(cadena[i-1]) * Double.parseDouble(cadena[i+1]);
                           //la variable temporal se convierte a cadena y se almacena en la posicion siguioente
                           cadena[i+1] = Double.toString(resultadoTemporal);
                       }catch(ArithmeticException e){
                           cadena[cadena.length-1] = "Syntaxis error";
                           break;
                       }
                   }
                   case "/" ->{
                       try{
                           var resultadoTemporal  = Double.parseDouble(cadena[i-1]) / Double.parseDouble(cadena[i+1]);
                           cadena[i+1] = Double.toString(resultadoTemporal);
                       }catch(ArithmeticException e){
                           cadena[cadena.length-1] = "Syntaxis error";
                           break;
                       }
                   }
               }//fin del switch
           }//fin del if
        }//fin del for
        return cadena[cadena.length-1];//rettorna el resultado obtenido
    }
    //Suma y resta el arreglo de numeros str: paso final
    public double resultadoSumaResta(String[] cadena){
        double retorno = 0;
        for(var i = 0; i < cadena.length; i++){
            if(!"".equals(cadena[i])){
                if(i == 0) retorno = Double.parseDouble(cadena[0]);
                else retorno += Double.parseDouble(cadena[i]);
            }
        }
        return retorno;
    }
}