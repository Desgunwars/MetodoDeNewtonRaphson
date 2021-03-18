
package Models;

import Controls.ClassManager;
import com.singularsys.jep.JepException;
import org.nfunk.jep.*;

public class ProcessCal {
    private ClassManager meClassManager;
    private String funtion = "";
    private double resultado = 0.0;
    private double valorX = 0.0;
    private String error = "";
    
    JEP jep;
    
    public ProcessCal(){
        
    }
    
    public void setFuntion(String funtion){
        this.funtion = funtion;
    }
    
    public void setValorX(double valorX){
        this.valorX = valorX;
    }
    
    public double getResultadoFuntion(){
        return this.resultado = resultado;
    }
    
    public String getError(){
        return this.error ;
    }
    
    private void evaluar() throws JepException{
        jep = new JEP();
        
        this.jep.addStandardFunctions();
        this.jep.addStandardConstants();
        this.jep.addVariable("x", this.valorX);
        this.jep.parseExpression(this.funtion);
        this.resultado = this.jep.getValue();
        
        this.error = (this.jep.hasError()) ? "Existe un Error" : "No hay error";
    }

    public void setClassManager(ClassManager meClassManager) {
        this.meClassManager = meClassManager;
    }
}
