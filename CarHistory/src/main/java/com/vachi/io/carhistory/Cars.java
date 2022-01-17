package com.vachi.io.carhistory;

import javax.persistence.*;

@Entity
@Table(name = "carinfo")
public class Cars{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vin")
    private Long vin;

    @Column(name ="damage_info")
    private String damage_info;

    @Column(name ="date")
    private int date;

    @Column(name = "claim_amount")
    private double claim_amount;

    public Cars(Long id, Long vin, String damage_info, int date, double claim_amount) {
        this.id = id;
        this.vin = vin;
        this.damage_info = damage_info;
        this.date = date;
        this.claim_amount = claim_amount;
    }

    public Cars() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVin() {
        return vin;
    }

    public void setVin(Long vin) {
        this.vin = vin;
    }

    public String getDamage_info() {
        return damage_info;
    }

    public void setDamage_info(String damage_info) {
        this.damage_info = damage_info;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public double getClaim_amount() {
        return claim_amount;
    }

    public void setClaim_amount(double claim_amount) {
        this.claim_amount = claim_amount;
    }
}
