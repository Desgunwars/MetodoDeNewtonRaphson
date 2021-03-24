
package bicession;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Bicession {


    public static void main(String[] args) {
        JFrame ventana = new JFrame();
        JPanel panel = new JPanel();
        
        ventana.setSize(700,500);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(panel);
        panel.setLayout(null);
        
        // acerca del ingreso de la funcion
        JTextField f = new JTextField();
        JLabel lf = new JLabel();
        lf.setText("Ingresa la funcion");
        lf.setBounds(20,10,300,100);
        f.setBounds(20,90,100,20);
        
        
        // acerca del ingreso del valor de x
        JTextField valorxl = new JTextField();
        JLabel lxl = new JLabel();
        lxl.setText("Ingresa el valor de Xl");
        lxl.setBounds(200,10,300,100);
        valorxl.setBounds(200,90,100,20);
        
        // acerca del ingreso de la derivada
        JTextField valorxu = new JTextField();
        JLabel lxu = new JLabel();
        lxu.setText("Ingresa el valor de Xu");
        lxu.setBounds(400,10,300,100);
        valorxu.setBounds(400,90,100,20);
        
        
        // resultado
        
        
        
        JTextField resultfxl = new JTextField();
        resultfxl.setBounds(20,200,100,20);
        JLabel lresultfxl = new JLabel();
        lresultfxl.setText("resultado de f(xl)");
        lresultfxl.setBounds(20,170,100,20);
        
        
        JTextField resultfxu = new JTextField();
        resultfxu.setBounds(200,200,100,20);
        JLabel lresultfxu = new JLabel();
        lresultfxu.setText("resultado de f(xu)");
        lresultfxu.setBounds(200,170,100,20);
        
        
        JTextField resultfxlfxu = new JTextField();
        resultfxlfxu.setBounds(380,200,100,20);
        JLabel lresultfxlfxu = new JLabel();
        lresultfxlfxu .setText("resultado de f(xu)*f(xl)");
        lresultfxlfxu .setBounds(380,170,100,20);
        
        
        
        
        
        ActionListener calculo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String expresion = f.getText();
                double xl = Double.parseDouble(valorxl.getText());
                double xu = Double.parseDouble(valorxu.getText());
                
                funcion vxl= new funcion();
                vxl.setFuncionxl(expresion);
                vxl.setValorXl(xl);
                vxl.evaluarxl();
                resultfxl.setText(vxl.getResultadoFuntionxl()+"");
                
                funcion vxu= new funcion();
                vxu.setFuncionxu(expresion);
                vxu.setValorXu(xu);
                vxu.evaluarxu();
                resultfxu.setText(vxu.getResultadoFuntionxu()+"");
                
                double fxlfxu = vxl.getResultadoFuntionxl()*vxu.getResultadoFuntionxu();
                resultfxlfxu.setText(fxlfxu+"");
                
                
                double xr = (xl+xu)/2;

                funcion vxr= new funcion();
                vxr.setFuncionxr(expresion);
                vxr.setValorXr(xr);
                vxr.evaluarxr();
                
                
                double fxrfxl = vxr.getResultadoFuntionxr()*vxl.getResultadoFuntionxl();
                
                
                double error = Math.abs((xr-xu)/xr)*100;
                
                
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
                    error};    
                
                modelo.addRow(datos);

                
                n = 1;
                
                while(error>0.05){
                
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
                    
                    error = Math.abs((xr-xu)/xr)*100;
                
                    
                    

                    
                    Object [] datos2 = {n,
                    xl,
                    xu,
                    vxl.getResultadoFuntionxl(),
                    vxu.getResultadoFuntionxu(),
                    fxlfxu,
                    xr,
                    vxr.getResultadoFuntionxr(),
                    fxrfxl,
                    error};       
                
                    modelo.addRow(datos2);
                    n++;
                        
                }
                
               
                
                JScrollPane scroll = new JScrollPane(tabla);
                scroll.setBounds(40,400,700,200);
                panel.add(scroll);
            }
            
            
            
        };
        
                
                
        
        
        
        
        
        
        JButton calcular = new JButton();
        
        
        
        
        
        calcular.setText("calcular");
        calcular.setBounds(20,250,100,20);
        calcular.addActionListener(calculo);
        
        panel.add(f);
        panel.add(lf);
        panel.add(lxl);
        panel.add(valorxl);
        panel.add(lxu);
        panel.add(valorxu);
        
        panel.add(resultfxl);
        panel.add(lresultfxl);
        panel.add(resultfxu);
        panel.add(lresultfxu);
        
        panel.add(resultfxlfxu);
        panel.add(lresultfxlfxu);
        
        panel.add(calcular);
    }
    
}
