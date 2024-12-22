/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thogakade.model;

/**
 *
 * @author sandhanu
 */
public class Orders {

    private String OrdeId;
    private String date;
    private String CustomerId;

    public Orders() {
    }

    public Orders(String OrdeId, String date, String CustomerId) {
        this.OrdeId = OrdeId;
        this.date = date;
        this.CustomerId = CustomerId;
    }

    /**
     * @return the OrdeId
     */
    public String getOrdeId() {
        return OrdeId;
    }

    /**
     * @param OrdeId the OrdeId to set
     */
    public void setOrdeId(String OrdeId) {
        this.OrdeId = OrdeId;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the CustomerId
     */
    public String getCustomerId() {
        return CustomerId;
    }

    /**
     * @param CustomerId the CustomerId to set
     */
    public void setCustomerId(String CustomerId) {
        this.CustomerId = CustomerId;
    }

}
