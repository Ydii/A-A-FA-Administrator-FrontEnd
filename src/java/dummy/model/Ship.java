/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dummy.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Thomas
 */
public abstract class Ship implements Serializable{
    private long shipId;
    private int passengerCapacity;
    private String name;
    private Date lastMaintenance;

    public Ship(long shipId, int passengerCapacity, String name, Date lastMaintenance) {
        this.shipId = shipId;
        this.passengerCapacity = passengerCapacity;
        this.name = name;
        this.lastMaintenance = lastMaintenance;
    }

    public long getShipId() {
        return shipId;
    }

    public void setShipId(long shipId) {
        this.shipId = shipId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int PassengerCapacity) {
        this.passengerCapacity = PassengerCapacity;
    }

    public Date getLastMaintenance() {
        return lastMaintenance;
    }

    public void setLastMaintenance(Date lastMaintenance) {
        this.lastMaintenance = lastMaintenance;
    }
    
    public abstract String getShipDescription();
}
