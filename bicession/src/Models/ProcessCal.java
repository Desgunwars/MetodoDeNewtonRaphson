
package Models;

import Controls.ClassManager;

import org.nfunk.jep.JEP;

public class ProcessCal {
    private ClassManager meClassManager;
    private String funcionxl = "";
    private String funcionxu = "";
    private String funcionxr = "";
    private double resultado = 0.0;
    private double valorXl = 0.0;
    private double valorXu = 0.0;
    private double valorXr = 0.0;
    private String error = "";
    
    JEP jep;
    
    public ProcessCal(){
        
    }
    
    public void setFuncionxl(String funcionxl){
        this.funcionxl = funcionxl;
    }
    public void setFuncionxu(String funcionxu){
        this.funcionxu = funcionxu;
    }

    public void setFuncionxr(String funcionxr){
        this.funcionxr = funcionxr;
    }
    
    public void setValorXl(double valorXl){
        this.valorXl = valorXl;
    }
    
    public void setValorXu(double valorXu){
        this.valorXu = valorXu;
    }
    public void setValorXr(double valorXr){
        this.valorXr = valorXr;
    }
    
    public double getResultadoFuntionxl(){
        return this.resultado = resultado;
    }
    public double getResultadoFuntionxu(){
        return this.resultado = resultado;
    }
    public double getResultadoFuntionxr(){
        return this.resultado = resultado;
    }
    
    public String getError(){
        return this.error ;
    }
    
    public void evaluarxl(){
        jep = new JEP();
        
        this.jep.addStandardFunctions();
        this.jep.addStandardConstants();
        this.jep.addVariable("x", this.valorXl);
        this.jep.parseExpression(this.funcionxl);
        this.resultado = this.jep.getValue();
        
        this.error = (this.jep.hasError()) ? "Existe un Error" : "No hay error";
    }
    public void evaluarxu(){
        jep = new JEP();
        
        this.jep.addStandardFunctions();
        this.jep.addStandardConstants();
        this.jep.addVariable("x", this.valorXu);
        this.jep.parseExpression(this.funcionxu);
        this.resultado = this.jep.getValue();
        
        this.error = (this.jep.hasError()) ? "Existe un Error" : "No hay error";
    }
   public void evaluarxr(){
        jep = new JEP();
        
        this.jep.addStandardFunctions();
        this.jep.addStandardConstants();
        this.jep.addVariable("x", this.valorXr);
        this.jep.parseExpression(this.funcionxr);
        this.resultado = this.jep.getValue();
        
        this.error = (this.jep.hasError()) ? "Existe un Error" : "No hay error";
    }
   public void setClassManager(ClassManager meClassManager) {
        this.meClassManager = meClassManager;
    }
}
