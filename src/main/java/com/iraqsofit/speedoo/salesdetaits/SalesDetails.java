package com.iraqsofit.speedoo.salesdetaits;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_SALES_DETAILS")
public class SalesDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "T_ID")
    private long id;

    @Column(name = "BILL_BRANCH")
    private String BILL_BRANCH;

    @Column(name = "BILL_NUMBER")
    private long BILL_NUMBER;

    @Column(name = "ITEM_CODE")
    private long ITEM_CODE;

    @Column(name = "ITEM_NAME")
    private String ITEM_NAME;

    @Column(name = "QTY")
    private float QTY;

    @Column(name = "UNIT_NAME")
    private String UNIT_NAME;

    @Column(name = "UNIT_QTY")
    private float UNIT_QTY;

    @Column(name = "STORE_CODE")
    private int STORE_CODE;

    @Column(name = "WAJBA_CODE")
    private long WAJBA_CODE;

    @Column(name = "WAJBA_NAME")
    private String WAJBA_NAME;

    @Column(name = "WAJBA_BALANCE")
    private String WAJBA_BALANCE;

    @Column(name = "CURRANCY_CODE")
    private int CURRANCY_CODE;

    @Column(name = "CURRANCY_EQUAL")
    private float CURRANCY_EQUAL;

    @Column(name = "COST")
    private float COST;

    @Column(name = "PRICE")
    private float PRICE;

    @Column(name = "TOTAL")
    private float TOTAL;

    @Column(name = "DISCOUNT_PERCENT_ITEM")
    private float DISCOUNT_PERCENT_ITEM;

    @Column(name = "DISCOUNT_AMOUNT_ITEM")
    private float DISCOUNT_AMOUNT_ITEM;

    @Column(name = "TOTAL_COST")
    private float TOTAL_COST;

    @Column(name = "NET_TOTAL")
    private float NET_TOTAL;

    @Column(name = "ARBAH_ITEM",insertable = false,updatable = false)
    private float ARBAH_ITEM;

    @Column(name = "C_DATE")
    private Date C_DATE;

    @Column(name = "ACTIVE")
    private boolean ACTIVE;

    public SalesDetails() {
        C_DATE = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBILL_BRANCH() {
        return BILL_BRANCH;
    }

    public void setBILL_BRANCH(String BILL_BRANCH) {
        this.BILL_BRANCH = BILL_BRANCH;
    }

    public long getBILL_NUMBER() {
        return BILL_NUMBER;
    }

    public void setBILL_NUMBER(long BILL_NUMBER) {
        this.BILL_NUMBER = BILL_NUMBER;
    }

    public long getITEM_CODE() {
        return ITEM_CODE;
    }

    public void setITEM_CODE(long ITEM_CODE) {
        this.ITEM_CODE = ITEM_CODE;
    }

    public String getITEM_NAME() {
        return ITEM_NAME;
    }

    public void setITEM_NAME(String ITEM_NAME) {
        this.ITEM_NAME = ITEM_NAME;
    }

    public float getQTY() {
        return QTY;
    }

    public void setQTY(float QTY) {
        this.QTY = QTY;
    }

    public String getUNIT_NAME() {
        return UNIT_NAME;
    }

    public void setUNIT_NAME(String UNIT_NAME) {
        this.UNIT_NAME = UNIT_NAME;
    }

    public float getUNIT_QTY() {
        return UNIT_QTY;
    }

    public void setUNIT_QTY(float UNIT_QTY) {
        this.UNIT_QTY = UNIT_QTY;
    }

    public int getSTORE_CODE() {
        return STORE_CODE;
    }

    public void setSTORE_CODE(int STORE_CODE) {
        this.STORE_CODE = STORE_CODE;
    }

    public long getWAJBA_CODE() {
        return WAJBA_CODE;
    }

    public void setWAJBA_CODE(long WAJBA_CODE) {
        this.WAJBA_CODE = WAJBA_CODE;
    }

    public String getWAJBA_NAME() {
        return WAJBA_NAME;
    }

    public void setWAJBA_NAME(String WAJBA_NAME) {
        this.WAJBA_NAME = WAJBA_NAME;
    }

    public String getWAJBA_BALANCE() {
        return WAJBA_BALANCE;
    }

    public void setWAJBA_BALANCE(String WAJBA_BALANCE) {
        this.WAJBA_BALANCE = WAJBA_BALANCE;
    }

    public int getCURRANCY_CODE() {
        return CURRANCY_CODE;
    }

    public void setCURRANCY_CODE(int CURRANCY_CODE) {
        this.CURRANCY_CODE = CURRANCY_CODE;
    }

    public float getCURRANCY_EQUAL() {
        return CURRANCY_EQUAL;
    }

    public void setCURRANCY_EQUAL(float CURRANCY_EQUAL) {
        this.CURRANCY_EQUAL = CURRANCY_EQUAL;
    }

    public float getCOST() {
        return COST;
    }

    public void setCOST(float COST) {
        this.COST = COST;
    }

    public float getPRICE() {
        return PRICE;
    }

    public void setPRICE(float PRICE) {
        this.PRICE = PRICE;
    }

    public float getTOTAL() {
        return TOTAL;
    }

    public void setTOTAL(float TOTAL) {
        this.TOTAL = TOTAL;
    }

    public float getDISCOUNT_PERCENT_ITEM() {
        return DISCOUNT_PERCENT_ITEM;
    }

    public void setDISCOUNT_PERCENT_ITEM(float DISCOUNT_PERCENT_ITEM) {
        this.DISCOUNT_PERCENT_ITEM = DISCOUNT_PERCENT_ITEM;
    }

    public float getDISCOUNT_AMOUNT_ITEM() {
        return DISCOUNT_AMOUNT_ITEM;
    }

    public void setDISCOUNT_AMOUNT_ITEM(float DISCOUNT_AMOUNT_ITEM) {
        this.DISCOUNT_AMOUNT_ITEM = DISCOUNT_AMOUNT_ITEM;
    }

    public float getTOTAL_COST() {
        return TOTAL_COST;
    }

    public void setTOTAL_COST(float TOTAL_COST) {
        this.TOTAL_COST = TOTAL_COST;
    }

    public float getNET_TOTAL() {
        return NET_TOTAL;
    }

    public void setNET_TOTAL(float NET_TOTAL) {
        this.NET_TOTAL = NET_TOTAL;
    }

    public float getARBAH_ITEM() {
        return ARBAH_ITEM;
    }

    public void setARBAH_ITEM(float ARBAH_ITEM) {
        this.ARBAH_ITEM = ARBAH_ITEM;
    }

    public Date getC_DATE() {
        return C_DATE;
    }

    public void setC_DATE(Date c_DATE) {
        C_DATE = c_DATE;
    }

    public boolean isACTIVE() {
        return ACTIVE;
    }

    public void setACTIVE(boolean ACTIVE) {
        this.ACTIVE = ACTIVE;
    }
}
