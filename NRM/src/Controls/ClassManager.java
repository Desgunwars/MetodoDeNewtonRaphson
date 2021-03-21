
package Controls;

import Models.ProcessCal;
import Views.MainWindow;


public class ClassManager {
    private MainWindow mePrincipalWindow;
    private ProcessCal meProcessCal;
    
    public void setMePrincipalWindow(MainWindow mePrincipalWindow) {
        this.mePrincipalWindow = mePrincipalWindow;
    }
    
    public MainWindow getMePrincipalWindow(){
        return this.mePrincipalWindow;
    }

    public void setMeProcessCal(ProcessCal meProcessCal) {
        this.meProcessCal = meProcessCal;
    }
    
    public ProcessCal getProcessCal(){
        return this.meProcessCal;
    }

    public String FuntionsCals(String text, String text0, String text1) {
        return "";
    }
    
    

   
}
