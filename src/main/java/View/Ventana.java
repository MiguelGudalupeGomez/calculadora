package View;
import javax.swing.ImageIcon;

/**
 * @author Miguel G.G.G.
 */

public class Ventana extends javax.swing.JFrame{
    //propiedades de la ventana
    public java.awt.Label pantalla;//panel donde se mostrara los resultados
    public java.awt.Label pantalla2;
    public javax.swing.JButton[] numericButtons = new javax.swing.JButton[10]; //botones numericos
    public javax.swing.JButton[] operationButtons = new javax.swing.JButton[4]; //botones para las operaciones
    public javax.swing.JButton borrar, limpiar, resultado, punto;
    
    private final ImageIcon img;
    //metodos de la ventana
    public Ventana(){ //constructor
        this.setSize(535, 430);
        img = new ImageIcon("C:\\Users\\PC\\Documents\\NetBeansProjects\\Calculadora_v01\\src\\Resources\\image.png");
        this.setIconImage(img.getImage());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//permie que se termine la ejecucion del programa cuando se cierra la ventana
        this.setLocationRelativeTo(null);//centra la ventana
        this.setVisible(true);//hace visible la ventana
        this.repaint();
        this.setLayout(null);
        this.setResizable(false);//evita que el usuario cambie el tamaño de la pantalla
        //el constructor inicializa los componentes del programa
        initComponents();//componentes del programa
        this.repaint();
    }
    private void initComponents(){
        //pantalla.setAlignment(javax.swing.JLabel.RIGHT);
        this.setTitle("Calculadora :3");
        this.getContentPane().setBackground(new java.awt.Color(90, 117, 120));//establece el color de fondo del JFrame
        pantalla = new java.awt.Label();
        pantalla2 = new java.awt.Label();
        
        pantalla.setAlignment(java.awt.Label.RIGHT);//alinea el texto del JLabel a la derecha
        pantalla2.setAlignment(java.awt.Label.RIGHT);//alinea el texto del JLabel a la derecha
        
        pantalla.setBounds(20, 10, 480, 25);
        pantalla2.setBounds(20, 35, 480, 25);
        
        
        pantalla.setBackground(new java.awt.Color(255, 255, 255));//establece el color de fondo del Label
        pantalla2.setBackground(new java.awt.Color(255, 255, 255));
        
        pantalla.setFont(new java.awt.Font("arial",java.awt.Font.PLAIN, 18));//establece fuente, tipo, y tamaño
        pantalla2.setFont(new java.awt.Font("arial",java.awt.Font.PLAIN, 18));//establece fuente, tipo, y tamaño
        

        String num = "0123456789";
        for(int i = 0; i<=9; i++){
            //Se crean los botones numericos y le asignamos su numero correspondiente
            numericButtons[i] = new javax.swing.JButton(Character.toString(num.charAt(i)));
            numericButtons[i].setFocusable(false);
            numericButtons[i].setFont(new java.awt.Font("arial", java.awt.Font.PLAIN, 18));
        }
        
        
        punto = new javax.swing.JButton(".");
        punto.setFocusable(false);
        punto.setFont(new java.awt.Font("arial", java.awt.Font.PLAIN, 40));
        borrar = new javax.swing.JButton("DEL");
        borrar.setFocusable(false);
        borrar.setFont(new java.awt.Font("arial", java.awt.Font.PLAIN, 18));
        borrar.setBackground(new java.awt.Color(148,128,247));
        limpiar = new javax.swing.JButton("AC");
        limpiar.setFocusable(false);
        limpiar.setBackground(new java.awt.Color(148,128,247));
        limpiar.setFont(new java.awt.Font("arial", java.awt.Font.PLAIN, 18));
        resultado = new javax.swing.JButton("=");
        resultado.setFocusable(false);
        resultado.setFont(new java.awt.Font("arial", java.awt.Font.PLAIN, 18));
        
        String oper = "+-*/";
        for(int i = 0; i<=3; i++){
            operationButtons[i] = new javax.swing.JButton(Character.toString(oper.charAt(i)));
            operationButtons[i].setFocusable(false);
            operationButtons[i].setFont(new java.awt.Font("arial", java.awt.Font.PLAIN, 25));
        }
        
        //establecer tamaño de los botones y posicion
        numericButtons[7].setBounds(20, 70, 80, 60);
        numericButtons[8].setBounds(120, 70, 80, 60);
        numericButtons[9].setBounds(220, 70, 80, 60);
        borrar.setBounds(320, 70, 80, 60);
        limpiar.setBounds(420, 70, 80, 60);
        
        numericButtons[4].setBounds(20, 150, 80, 60);
        numericButtons[5].setBounds(120, 150, 80, 60);
        numericButtons[6].setBounds(220, 150, 80, 60);
        operationButtons[0].setBounds(320, 150, 80, 60);
        operationButtons[1].setBounds(420, 150, 80, 60);
        
        numericButtons[1].setBounds(20, 230, 80, 60);
        numericButtons[2].setBounds(120, 230, 80, 60);
        numericButtons[3].setBounds(220, 230, 80, 60);
        operationButtons[2].setBounds(320, 230, 80, 60);
        operationButtons[3].setBounds(420, 230, 80, 60);
        
        numericButtons[0].setBounds(20, 310, 130, 60);
        punto.setBounds(170, 310, 130, 60);
        resultado.setBounds(320, 310, 180, 60);
        
        //agregar elementos a la pantalla
        this.add(pantalla);
        this.add(pantalla2);
        for(int i = 0; i<=9; i++){
            //Se añaden los botones
            this.add(numericButtons[i]);
        }
        this.add(borrar);
        this.add(limpiar);
        for(int i = 0; i<=3; i++){
            this.add(operationButtons[i]);                    
        }
        this.add(punto);
        this.add(resultado);     
    }
}