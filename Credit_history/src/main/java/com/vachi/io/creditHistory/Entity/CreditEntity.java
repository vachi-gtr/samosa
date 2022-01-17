package com.vachi.io.creditHistory.Entity;

import javax.persistence.*;

@Entity
@Table(name="credithistory1")
public class CreditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "panNo", unique = true)
    private Long panNo;

    @Column(name = "address")
    private String address;

    @Column(name = "creditScore")
    private int creditScore;

    public CreditEntity() {
    }

    public CreditEntity(Long id, String firstName, String lastName, Long panNo, String address, int creditScore) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.panNo = panNo;
        this.address = address;
        this.creditScore = creditScore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getPanNo() {
        return panNo;
    }

    public void setPanNo(Long panNo) {
        this.panNo = panNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

}
