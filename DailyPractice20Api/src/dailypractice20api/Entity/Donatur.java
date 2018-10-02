/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailypractice20api.Entity;

import java.io.Serializable;

/**
 *
 * @author Richard Shiawase
 */
public class Donatur implements Serializable {
    private String nama;
    private int donasi;
    private String asal;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getDonasi() {
        return donasi;
    }

    public void setDonasi(int donasi) {
        this.donasi = donasi;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }
    
}
