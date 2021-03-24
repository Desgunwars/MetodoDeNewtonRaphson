
package Views;

import Controls.ClassManager;
import Models.ProcessCal;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MainWindow extends JFrame implements ActionListener{
    
    private ClassManager meClassManager;
    private JPanel mePanel;
    private JLabel labelTitle;
    private JLabel labelValueXl;
    private JLabel labelValueXu;
    private JLabel labelTitleFunction;
    private JTextField textValueXl;
    private JTextField textValueXu;
    private JTextField meFunctionTextFlield;
    private JButton meButtonCal;
    private JButton meButtonExit;
    
    public MainWindow(){
        /* Creating the Newton Raphson Window */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(620,620);
        setTitle("Bisseccion Method");
        setLocationRelativeTo(null);
            
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
        
        /*------- Tag Value Xl ---------------*/
        labelValueXl = new JLabel();
        labelValueXl.setText("Ingrese el Valor de Xl:");
        labelValueXl.setForeground(Color.BLACK);
        labelValueXl.setHorizontalAlignment(SwingConstants.CENTER);
        labelValueXl.setBounds(50, 145, 220, 30);
        labelValueXl.setFont(new Font("Time New Roman", Font.BOLD, 16));
        /*Add ValueXl add mePanel */
        mePanel.add(labelValueXl);
        
        /*------------- TextsField Value Xl -------------*/
        textValueXl = new JTextField();
        textValueXl.setLayout(null);
        textValueXl.setBorder(BorderFactory.createBevelBorder(12));
        textValueXl.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        textValueXl.setBackground(Color.LIGHT_GRAY);
        textValueXl.setBounds(250, 150,200, 20);
        /*Add textValueXl a mePanel*/
        mePanel.add(textValueXl);
        
         /*------- Tag Value Xu ---------------*/
        labelValueXu = new JLabel();
        labelValueXu.setText("Ingrese el Valor de Xu:");
        labelValueXu.setForeground(Color.BLACK);
        labelValueXu.setHorizontalAlignment(SwingConstants.CENTER);
        labelValueXu.setBounds(12 , 185, 220, 30);
        labelValueXu.setFont(new Font("Time New Roman", Font.BOLD, 16));
        /*Add ValueXiuadd mePanel */
        mePanel.add(labelValueXu);
        
        /*------------- TextsField Value Xu -------------*/
        textValueXu = new JTextField();
        textValueXu.setLayout(null);
        textValueXu.setBorder(BorderFactory.createBevelBorder(12));
        textValueXu.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        textValueXu.setBackground(Color.LIGHT_GRAY);
        textValueXu.setBounds(250, 185,200, 20);
        /*Add textValueXu a mePanel*/
        mePanel.add(textValueXu);
        
        /*------- Tag TitleFuntion -------*/
        labelTitleFunction = new JLabel();
        labelTitleFunction.setText("Ingrese la Funcion:");
        labelTitleFunction.setForeground(Color.BLACK);
        labelTitleFunction.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitleFunction.setBounds(50, 225, 220, 30);
        labelTitleFunction.setFont(new Font("Time New Roman", Font.BOLD, 16));
        /*Add LabelTitleFuntion */
        mePanel.add(labelTitleFunction);
        
        /*------------- TextsField Function -------------*/
        meFunctionTextFlield = new JTextField();
        meFunctionTextFlield.setLayout(null);
        meFunctionTextFlield.setBorder(BorderFactory.createBevelBorder(12));
        meFunctionTextFlield.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        meFunctionTextFlield.setBackground(Color.LIGHT_GRAY);
        meFunctionTextFlield.setBounds(250, 230,200, 20);
        /*Add TextField a mePanel*/
        mePanel.add(meFunctionTextFlield);
        
        
        
        /*-------------- Btn Calculate ------------------*/
        meButtonCal = new JButton();
        meButtonCal.setText("Calcular Raíz");
        meButtonCal.setHorizontalAlignment(SwingConstants.CENTER);
        meButtonCal.setLayout(null);
        meButtonCal.setBorder(BorderFactory.createBevelBorder(20));
        meButtonCal.setBackground(Color.GRAY);
        meButtonCal.setBounds(250, 270, 90, 40);
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
        meButtonExit.setBounds(360, 270, 90, 40);
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
            /*--------------Almacena el valor de Xl digitado--------------*/
            double xl = Double.parseDouble(textValueXl.getText());
            
            /*--------------Almacena el valor de Xu digitado--------------*/
            double xu = Double.parseDouble(textValueXu.getText());

            /*--------------Almacena la funcion digitada--------------*/
            String expresion = meFunctionTextFlield.getText();
            
            
                ProcessCal vxl= new ProcessCal();
                vxl.setFuncionxl(expresion);
                vxl.setValorXl(xl);
                vxl.evaluarxl();
                
                ProcessCal vxu= new ProcessCal();
                vxu.setFuncionxu(expresion);
                vxu.setValorXu(xu);
                vxu.evaluarxu();
                
                double fxlfxu = vxl.getResultadoFuntionxl()*vxu.getResultadoFuntionxu();
                
                
                double xr = (xl+xu)/2;

                ProcessCal vxr= new ProcessCal();
                vxr.setFuncionxr(expresion);
                vxr.setValorXr(xr);
                vxr.evaluarxr();
                
                
                double fxrfxl = vxr.getResultadoFuntionxr()*vxl.getResultadoFuntionxl();
                
                
                double errorABS = Math.abs((xr-xu)/xr)*100;
                
                
                DefaultTableModel modelo = new DefaultTableModel();
                JTable tabla = new JTable();
                modelo.addColumn("n");
                modelo.addColumn("Xl");
                modelo.addColumn("Xu");
                modelo.addColumn("F(Xl)");
                modelo.addColumn("F(Xu)");
                modelo.addColumn("F(Xl)*F(Xu)");
                modelo.addColumn("Xr");
                modelo.addColumn("F(Xr)");
                modelo.addColumn("f(Xr)*F(Xl)");
                modelo.addColumn("Error");
                
                tabla.setModel(modelo);
                int n = 0;
                Object [] datos = {n,
                    xl,
                    xu,
                    vxl.getResultadoFuntionxl(),
                    vxu.getResultadoFuntionxu(),
                    fxlfxu,
                    xr,
                    vxr.getResultadoFuntionxr(),
                    fxrfxl,
                    errorABS};    
                
                modelo.addRow(datos);
                
               n=1;
            /*--------------Ciclo que se repetira varias veces miestras sea mayor a 0.05 para encontrar la raiz--------------*/
            n = 1;
                
                while(errorABS>0.05){
                
                   //xu = xr;
                    if(fxrfxl<0){
                        xu = xr;
                        xl = xl;
                    }
                    
                    else if(fxrfxl>0){
                        xl = xr;
                        xu = xu;
                    }
                    
                   
                     
                    vxl.setFuncionxl(expresion);
                    vxl.setValorXl(xl);
                    vxl.evaluarxl();



                    vxu.setFuncionxu(expresion);
                    vxu.setValorXu(xu);
                    vxu.evaluarxu();
                    
                    
                    fxlfxu = vxl.getResultadoFuntionxl()*vxu.getResultadoFuntionxu();
                    
                    xr = (xl+xu)/2;
                    
                    vxr.setFuncionxr(expresion);
                    vxr.setValorXr(xr);
                    vxr.evaluarxr();
                    fxrfxl = vxr.getResultadoFuntionxr()*vxl.getResultadoFuntionxl();
                    
                    errorABS = Math.abs((xr-xu)/xr)*100;
                
                    
                    

                    
                    Object [] datos2 = {n,
                    xl,
                    xu,
                    vxl.getResultadoFuntionxl(),
                    vxu.getResultadoFuntionxu(),
                    fxlfxu,
                    xr,
                    vxr.getResultadoFuntionxr(),
                    fxrfxl,
                    errorABS};       
                
                    modelo.addRow(datos2);
                    n++;
                        
                }
                
               
                
                JScrollPane scroll = new JScrollPane(tabla);
                scroll.setBounds(40,400,700,200);
                mePanel.add(scroll);
                JOptionPane.showMessageDialog(null,"La raiz encontrada es: "+xr);
            
        }else{
            dispose();
        }
    }
}
