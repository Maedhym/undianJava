/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailypractice20server;

import dailypractice20server.ServerService.ServerService;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Richard Shiawase
 */
public class DailyPractice20Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException {
        // TODO code application logic here
        Registry server = LocateRegistry.createRegistry(6789);
        ServerService sv = new ServerService();
        server.rebind("service", sv);
        System.out.println("Server berjalan..");
    }
    
}
