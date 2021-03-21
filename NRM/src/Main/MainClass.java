
package Main;


import Controls.ClassManager;
import Models.ProcessCal;
import Views.MainWindow;


public class MainClass {
    
    MainWindow  mePrincipalWindow;
    ClassManager meClassManager;
    ProcessCal meProcessCal;

    
    
    public static void main(String[] args) {
        MainClass principalWindow = new MainClass();
        principalWindow.start();
    }
    
    private void start(){
        mePrincipalWindow = new MainWindow();
        meClassManager = new ClassManager();
        meProcessCal = new ProcessCal();
        
        // Creation of relationships between views and models with the ClassManager
        mePrincipalWindow.setClassManager(meClassManager);
        meProcessCal.setClassManager(meClassManager);
        
        // Creation of relationship between ClassManager with views and models
        meClassManager.setMePrincipalWindow(mePrincipalWindow);
        meClassManager.setMeProcessCal(meProcessCal);
        
        mePrincipalWindow.setVisible(true);
    }
    
}
