
package Models;

import Controls.ClassManager;

import org.nfunk.jep.JEP;

public class ProcessCal {
    private ClassManager meClassManager;
    private String funtion = "";
    private String funtionD = "";
    private String funtionDD = "";
    private double resultado = 0.0;
    private double valorX = 0.0;
    private String error = "";
    
    JEP jep;
    
    public ProcessCal(){
        
    }
    
    public void setFuntion(String funtion){
        this.funtion = funtion;
    }
    
    public void setFuntionD(String funtionD){
        this.funtionD = funtionD;
    }
     
    public void setFuntionDD(String funtionDD){
        this.funtionDD = funtionDD;
    }
    
    public void setValorX(double valorX){
        this.valorX = valorX;
    }
    
    public double getResultadoFuntion(){
        return this.resultado = resultado;
    }
    
    public double getResultadoFuntionD(){
        return this.resultado = resultado;
    }
    
    public double getResultadoFuntionDD(){
        return this.resultado = resultado;
    }
    
    public String getError(){
        return this.error ;
    }
    
    public void evaluar(){
        jep = new JEP();
        
        this.jep.addStandardFunctions();
        this.jep.addStandardConstants();
        this.jep.addVariable("x", this.valorX);
        this.jep.parseExpression(this.funtion);
        this.resultado = this.jep.getValue();
        
        this.error = (this.jep.hasError()) ? "Existe un Error" : "No hay error";
    }
    public void evaluarD(){
        jep = new JEP();
        
        this.jep.addStandardFunctions();
        this.jep.addStandardConstants();
        this.jep.addVariable("x", this.valorX);
        this.jep.parseExpression(this.funtionD);
        this.resultado = this.jep.getValue();
        
        this.error = (this.jep.hasError()) ? "Existe un Error" : "No hay error";
    }
    
    public void evaluarDD(){
        jep = new JEP();
        
        this.jep.addStandardFunctions();
        this.jep.addStandardConstants();
        this.jep.addVariable("x", this.valorX);
        this.jep.parseExpression(this.funtionDD);
        this.resultado = this.jep.getValue();
        
        this.error = (this.jep.hasError()) ? "Existe un Error" : "No hay error";
    }

    public void setClassManager(ClassManager meClassManager) {
        this.meClassManager = meClassManager;
    }
}
