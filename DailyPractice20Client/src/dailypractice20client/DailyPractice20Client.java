/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailypractice20client;

import dailypractice20api.ServiceInterface.ServiceInterface;
import dailypractice20client.Form.MainForm;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author Richard Shiawase
 */
public class DailyPractice20Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, NotBoundException {
        // TODO code application logic here
        Registry cli = LocateRegistry.getRegistry("localhost", 6789);
        ServiceInterface sv = (ServiceInterface) cli.lookup("service");
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                try {
                    MainForm mf =new MainForm(sv);
                    mf.setVisible(true);
                } catch (RemoteException ex) {
                    Logger.getLogger(DailyPractice20Client.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        });
    }
    
}
