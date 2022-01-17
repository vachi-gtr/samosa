package com.vachi.io.historydetails.Entity;

import javax.persistence.*;

@Entity
@Table(name = "history_details")
public class HistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "panNo",unique = true)
    private Long panNo;
    @Column(name = "detailsInfo")
    private String detailsInfo;

    public HistoryEntity() {
    }

    public HistoryEntity(Long panNo, String detailsInfo) {
        this.panNo = panNo;
        this.detailsInfo = detailsInfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPanNo() {
        return panNo;
    }

    public void setPanNo(Long panNo) {
        this.panNo = panNo;
    }

    public String getDetailsInfo() {
        return detailsInfo;
    }

    public void setDetailsInfo(String detailsInfo) {
        this.detailsInfo = detailsInfo;
    }
}
