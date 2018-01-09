package models;

import javafx.util.Pair;

import java.net.InetAddress;

public class Location extends Address {
    Pair<Double, Double> latLon;
    InetAddress ipaddress;

    public Location() {
        this(null, null);
    }

    public Location(Pair<Double, Double> latLon, InetAddress ipaddress) {
        this.latLon = latLon;
        this.ipaddress = ipaddress;
    }

    public Pair<Double, Double> getLatLon() {
        return latLon;
    }

    public void setLatLon(Pair<Double, Double> latLon) {
        this.latLon = latLon;
    }

    public InetAddress getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(InetAddress ipaddress) {
        this.ipaddress = ipaddress;
    }
}
