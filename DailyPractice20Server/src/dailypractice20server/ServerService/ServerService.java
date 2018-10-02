/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailypractice20server.ServerService;

import com.mysql.jdbc.PreparedStatement;
import dailypractice20api.Entity.Donatur;
import dailypractice20api.ServiceInterface.ServiceInterface;
import dailypractice20server.DatabaseUtilities.Database;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Richard Shiawase
 */
public class ServerService extends UnicastRemoteObject implements ServiceInterface {

    public ServerService() throws RemoteException {

    }

    @Override
    public void insertDonatur(Donatur donatur) throws RemoteException {
        PreparedStatement ps = null;
        try {
            ps = (PreparedStatement) Database.getConnection().prepareStatement(""
                    + "INSERT INTO donasi (nama,donasi,asal) values (?,?,?)");
            ps.setString(1, donatur.getNama());
            ps.setInt(2, donatur.getDonasi());
            ps.setString(3, donatur.getAsal());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServerService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Donatur> getDonatur() throws RemoteException {
        List<Donatur> list = new ArrayList<Donatur>();
        Statement st = null;
        try {

            st = Database.getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM donasi");
            while(rs.next()){
                Donatur donatur = new Donatur();
                donatur.setNama(rs.getString("nama"));
                donatur.setDonasi(rs.getInt("donasi"));
                donatur.setAsal(rs.getString("asal"));
                list.add(donatur);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ServerService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
