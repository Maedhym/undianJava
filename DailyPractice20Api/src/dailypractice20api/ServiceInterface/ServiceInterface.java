/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailypractice20api.ServiceInterface;

import dailypractice20api.Entity.Donatur;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Richard Shiawase
 */
public interface ServiceInterface extends Remote {

    void insertDonatur(Donatur donatur) throws RemoteException;

    List<Donatur> getDonatur() throws RemoteException;

}
