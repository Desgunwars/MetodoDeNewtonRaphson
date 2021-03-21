package Views;

import Controls.ClassManager;
import Main.MainClass;
import Models.ProcessCal;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainWindow extends JFrame implements ActionListener{
    
    private ClassManager meClassManager;
    private JPanel mePanel;
    private JLabel labelTitle;
    private JLabel labelValueXi;
    private JLabel labelTitleFunction;
    private JLabel labelTitleFunctionD;
    private JLabel labelTitleFunctionDD;
    private JTextField textValueXi;
    private JTextField meFunctionTextFlield;
    private JTextField meFunctionDTextFlield;
    private JTextField meFunctionDDTextFlield;
    private JButton meButtonCal;
    private JButton meButtonExit;
    
    public MainWindow(){
        /* Creating the Newton Raphson Window */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(620,620);
        setTitle("Newton Raphson Method");
        setLocationRelativeTo(null);
        setResizable(false);
        
        /* -------- Panel -------- */
        mePanel = new JPanel();
        mePanel.setLayout(null);
        mePanel.setSize(620,620);
        this.getContainerListeners();
        add(mePanel);
        
        /*---------- Tag Title Method ----------*/
        labelTitle = new JLabel();
        labelTitle.setText("Ingrese la Funcion a Evaluar");
        labelTitle.setForeground(Color.BLACK);
        labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitle.setBounds(190, 70, 220, 30);
        labelTitle.setFont(new Font("Time New Roman", Font.BOLD, 16));
        /*Add LabelTitle a mePanel*/
        mePanel.add(labelTitle);
        
        /*------- Tag Value Xi ---------------*/
        labelValueXi = new JLabel();
        labelValueXi.setText("Ingrese el Valor de Xi:");
        labelValueXi.setForeground(Color.BLACK);
        labelValueXi.setHorizontalAlignment(SwingConstants.CENTER);
        labelValueXi.setBounds(50, 145, 220, 30);
        labelValueXi.setFont(new Font("Time New Roman", Font.BOLD, 16));
        /*Add ValueXi add mePanel */
        mePanel.add(labelValueXi);
        
        /*------------- TextsField Value Xi -------------*/
        textValueXi = new JTextField();
        textValueXi.setLayout(null);
        textValueXi.setBorder(BorderFactory.createBevelBorder(12));
        textValueXi.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        textValueXi.setBackground(Color.LIGHT_GRAY);
        textValueXi.setBounds(250, 150,200, 20);
        /*Add textValueXi a mePanel*/
        mePanel.add(textValueXi);
        
        /*------- Tag TitleFuntion -------*/
        labelTitleFunction = new JLabel();
        labelTitleFunction.setText("La Funcion:");
        labelTitleFunction.setForeground(Color.BLACK);
        labelTitleFunction.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitleFunction.setBounds(12 , 185, 220, 30);
        labelTitleFunction.setFont(new Font("Time New Roman", Font.BOLD, 16));
        /*Add LabelTitleFuntion */
        mePanel.add(labelTitleFunction);
        
        /*------------- TextsField Function -------------*/
        meFunctionTextFlield = new JTextField();
        meFunctionTextFlield.setLayout(null);
        meFunctionTextFlield.setBorder(BorderFactory.createBevelBorder(12));
        meFunctionTextFlield.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        meFunctionTextFlield.setBackground(Color.LIGHT_GRAY);
        meFunctionTextFlield.setBounds(250, 185,200, 20);
        /*Add TextField a mePanel*/
        mePanel.add(meFunctionTextFlield);
        
        /*------------ TextField FunctionD ------------*/
        
        labelTitleFunctionD = new JLabel();
        labelTitleFunctionD.setText("Funcion Derivada Xi:");
        labelTitleFunctionD.setForeground(Color.BLACK);
        labelTitleFunctionD.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitleFunctionD.setBounds(50, 225, 220, 30);
        labelTitleFunctionD.setFont(new Font("Time New Roman", Font.BOLD, 16));
        /*Add TextField FunctionD a mePanel*/
        mePanel.add(labelTitleFunctionD);
        
        
        
        /*------------- TextsField FunctionD -------------*/
        meFunctionDTextFlield = new JTextField();
        meFunctionDTextFlield.setLayout(null);
        meFunctionDTextFlield.setBorder(BorderFactory.createBevelBorder(12));
        meFunctionDTextFlield.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        meFunctionDTextFlield.setBackground(Color.LIGHT_GRAY);
        meFunctionDTextFlield.setBounds(250, 230,200, 20);
        /*Add TextField a mePanel*/
        mePanel.add(meFunctionDTextFlield);
        
        
        
        labelTitleFunctionDD = new JLabel();
        labelTitleFunctionDD.setText("Funcion Segunda Derivada Xi:");
        labelTitleFunctionDD.setForeground(Color.BLACK);
        labelTitleFunctionDD.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitleFunctionDD.setBounds(70, 260, 250, 30);
        labelTitleFunctionDD.setFont(new Font("Time New Roman", Font.BOLD, 16));
        /*Add TextField FunctionD a mePanel*/
        mePanel.add(labelTitleFunctionDD);
        
        
        meFunctionDDTextFlield = new JTextField();
        meFunctionDDTextFlield.setLayout(null);
        meFunctionDDTextFlield.setBorder(BorderFactory.createBevelBorder(12));
        meFunctionDDTextFlield.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        meFunctionDDTextFlield.setBackground(Color.LIGHT_GRAY);
        meFunctionDDTextFlield.setBounds(320, 265,200, 20);
        /*Add TextField a mePanel*/
        mePanel.add(meFunctionDDTextFlield);
        
        
        
        /*-------------- Btn Calculate ------------------*/
        meButtonCal = new JButton();
        meButtonCal.setText("Calcular Raíz");
        meButtonCal.setHorizontalAlignment(SwingConstants.CENTER);
        meButtonCal.setLayout(null);
        meButtonCal.setBorder(BorderFactory.createBevelBorder(20));
        meButtonCal.setBackground(Color.GRAY);
        meButtonCal.setBounds(250, 310, 90, 40);
        /* Add Button a mePanel */
        mePanel.add(meButtonCal);
        /*Add ActionEvent Button Cal */
        meButtonCal.addActionListener(this);
        
        /*-------------- Btn Exit ------------------*/
        meButtonExit = new JButton();
        meButtonExit.setText("Salir");
        meButtonExit.setHorizontalAlignment(SwingConstants.CENTER);
        meButtonExit.setLayout(null);
        meButtonExit.setBorder(BorderFactory.createBevelBorder(20));
        meButtonExit.setBackground(Color.GRAY);
        meButtonExit.setBounds(360, 310, 90, 40);
        /* Add Button a mePanel */
        mePanel.add(meButtonExit);
        /*Add ActionEvent Button Exit */
        meButtonExit.addActionListener(this);
        
            
    }

    public void setClassManager(ClassManager meClassManager) {
        this.meClassManager = meClassManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == meButtonCal){
            /*--------------Almacena la funcion digitada--------------*/
            String expresionFuntion = meFunctionTextFlield.getText();
            
            /*--------------Almacena la funcion derivada digitada--------------*/
            String expresionFuctionD = meFunctionDTextFlield.getText();
            
            /*--------------Almacena la funcion segunda derivada digitada--------------*/
            String expresionFuctionDD = meFunctionDDTextFlield.getText();
            
            /*--------------Almacena el valor de x digitado--------------*/
            double x = Double.parseDouble(textValueXi.getText());
            
            
            
            /*--------------Calcula la funcion--------------*/
            ProcessCal funcion = new ProcessCal();
            funcion.setFuntion(expresionFuntion);
            funcion.setValorX(x);
            funcion.evaluar();
           // result.setText(funcion.getResultadoFuntion()+"");
            
           /*--------------Calcula la derivada--------------*/
            ProcessCal funcionD = new ProcessCal();
            funcionD.setFuntionD(expresionFuctionD);
            funcionD.setValorX(x);
            funcionD.evaluarD();
             //resultdf.setText(dfuncion.getResultadoFuntion()+"");
            //String calFuntions = meClassManager.FuntionsCals(textValueXi.getText(),meFunctionTextFlield.getText(), meFunctionDTextFlield.getText());
            
            
            /*--------------Calcula la segunda derivada--------------*/
            ProcessCal funcionDD = new ProcessCal();
            funcionDD.setFuntionDD(expresionFuctionDD);
            funcionDD.setValorX(x);
            funcionDD.evaluarDD();
            
            /*--------------Calcula el metodo de newton rapson y el error absoluto--------------*/
            double Raphson = x-((funcion.getResultadoFuntion()*funcionD.getResultadoFuntionD())/(Math.pow(funcionD.getResultadoFuntionD(), 2)-(funcionD.getResultadoFuntion()*funcionDD.getResultadoFuntionDD())));
            double errorABS = Math.abs((Raphson-x)/Raphson)*100;
            
            
            /*--------------Ciclo que se repetira varias veces miestras sea mayor a 0.05 para encontrar la raiz--------------*/
            while(errorABS>0.05){
            
                /*--------------El valor de x va a hacer el valor del rapson anterior--------------*/
                x = Raphson;
                
                /*--------------Calcula la funcion--------------*/
                funcion.setFuntion(expresionFuntion);
                funcion.setValorX(x);
                funcion.evaluar();
                
                /*--------------Calcula la derivada--------------*/
                funcionD.setFuntionD(expresionFuctionD);
                funcionD.setValorX(x);
                funcionD.evaluarD();
                
                /*--------------Calcula la segunda derivada--------------*/
                funcionDD.setFuntionDD(expresionFuctionDD);
                funcionDD.setValorX(x);
                funcionDD.evaluarDD();
                
                Raphson = x-((funcion.getResultadoFuntion()*funcionD.getResultadoFuntionD())/(Math.pow(funcionD.getResultadoFuntionD(), 2)-(funcion.getResultadoFuntion()*funcionDD.getResultadoFuntionDD())));
                errorABS = Math.abs((Raphson-x)/Raphson)*100;
            }
            
            JOptionPane.showMessageDialog(null,"La raiz encontrada es: "+Raphson);
            
            /*
            textValueXi.setText("");
            meFunctionTextFlield.setText("");
            meFunctionDTextFlield.setText("");*/
        }

        else{
            dispose();
        }
    }
}
