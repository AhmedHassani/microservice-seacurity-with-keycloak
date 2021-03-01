package com.iraqsofit.speedoo.buydetails;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_BUY_DETAILS")
public class BuyDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "T_ID",insertable = false,updatable = false)
    private long id;

    @Column(name = "BILL_BRANCH")
    private String BILL_BRANCH;

    @Column(name = "BILL_NUMBER")
    private long BILL_NUMBER;

    @Column(name = "ITEM_CODE")
    private long ITEM_CODE;

    @Column(name = "QTY")
    private float QTY;

    @Column(name = "UNIT_NAME")
    private String UNIT_NAME;

    @Column(name = "UNIT_QTY")
    private float UNIT_QTY;

    @Column(name = "STORE_CODE")
    private int STORE_CODE;

    @Column(name = "EXP_DATE")
    private String EXP_DATE;

    @Column(name = "PRICE_BUY")
    private float PRICE_BUY;

    @Column(name = "CURRANCY_EQUAL")
    private float CURRANCY_EQUAL;

    @Column(name = "PRICE")
    private float PRICE;

    @Column(name = "TOTAL")
    private float TOTAL;

    @Column(name = "EXPENSES")
    private float EXPENSES;

    @Column(name = "TOTAL_EXPENSES")
    private float TOTAL_EXPENSES;

    @Column(name = "COST")
    private float COST;

    @Column(name = "TOTAL_COST")
    private float TOTAL_COST;

    @Column(name = "SELL1")
    private float SELL1;

    @Column(name = "SELL2")
    private float SELL2;

    @Column(name = "C_DATE")
    private Date C_DATE;

    @Column(name = "ACTIVE")
    private boolean ACTIVE;

    public BuyDetails() {
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

    public String getEXP_DATE() {
        return EXP_DATE;
    }

    public void setEXP_DATE(String EXP_DATE) {
        this.EXP_DATE = EXP_DATE;
    }

    public float getPRICE_BUY() {
        return PRICE_BUY;
    }

    public void setPRICE_BUY(float PRICE_BUY) {
        this.PRICE_BUY = PRICE_BUY;
    }

    public float getCURRANCY_EQUAL() {
        return CURRANCY_EQUAL;
    }

    public void setCURRANCY_EQUAL(float CURRANCY_EQUAL) {
        this.CURRANCY_EQUAL = CURRANCY_EQUAL;
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

    public float getEXPENSES() {
        return EXPENSES;
    }

    public void setEXPENSES(float EXPENSES) {
        this.EXPENSES = EXPENSES;
    }

    public float getTOTAL_EXPENSES() {
        return TOTAL_EXPENSES;
    }

    public void setTOTAL_EXPENSES(float TOTAL_EXPENSES) {
        this.TOTAL_EXPENSES = TOTAL_EXPENSES;
    }

    public float getCOST() {
        return COST;
    }

    public void setCOST(float COST) {
        this.COST = COST;
    }

    public float getTOTAL_COST() {
        return TOTAL_COST;
    }

    public void setTOTAL_COST(float TOTAL_COST) {
        this.TOTAL_COST = TOTAL_COST;
    }

    public float getSELL1() {
        return SELL1;
    }

    public void setSELL1(float SELL1) {
        this.SELL1 = SELL1;
    }

    public float getSELL2() {
        return SELL2;
    }

    public void setSELL2(float SELL2) {
        this.SELL2 = SELL2;
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
