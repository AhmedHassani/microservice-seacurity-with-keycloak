package com.iraqsofit.speedoo.itemuint;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_ITEM_UNIT")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UNIT_GUID", updatable = false, nullable = false)
    private long UNIT_GUID;
    @Column(name = "ITEM_CODE")
    private long itemCode;
    @Column(name = "UNIT_CODE")
    private int UNIT_CODE;
    @Column(name = "UNIT_NAME")
    private String UNIT_NAME;
    @Column(name = "UNIT_QTY")
    private float UNIT_QTY;
    @Column(name = "ON_OFF")
    private boolean ON_OFF;
    @Column(name = "DF_SALE")
    private boolean DF_SALE;
    @Column(name = "DF_BUY")
    private boolean DF_BUY;
    @Column(name = "DF_STORE")
    private boolean DF_STORE;
    @Column(name = "PRICE_BUY")
    private float PRICE_BUY;
    @Column(name = "PRICE_COST")
    private float PRICE_COST;
    @Column(name = "PRICE_SALE_1")
    private float PRICE_SALE_1;
    @Column(name = "PRICE_SALE_2")
    private float PRICE_SALE_2;
    @Column(name = "PRICE_SALE_3")
    private float PRICE_SALE_3;
    @Column(name = "PRICE_AVG_COST")
    private float PRICE_AVG_COST;
    @Column(name = "PRICE_SALE_CUR")
    private float PRICE_SALE_CUR;
    @Column(name = "C_DATE")
    private Date C_DATE;

    public Unit() {
        this.C_DATE=new Date();
    }

    public long getUNIT_GUID() {
        return UNIT_GUID;
    }

    public void setUNIT_GUID(long UNIT_GUID) {
        this.UNIT_GUID = UNIT_GUID;
    }

    public long getITEM_CODE() {
        return this.itemCode;
    }

    public void setITEM_CODE(long ITEM_CODE) {
        this.itemCode = ITEM_CODE;
    }

    public int getUNIT_CODE() {
        return UNIT_CODE;
    }

    public void setUNIT_CODE(int UNIT_CODE) {
        this.UNIT_CODE = UNIT_CODE;
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

    public boolean isON_OFF() {
        return ON_OFF;
    }

    public void setON_OFF(boolean ON_OFF) {
        this.ON_OFF = ON_OFF;
    }

    public boolean isDF_SALE() {
        return DF_SALE;
    }

    public void setDF_SALE(boolean DF_SALE) {
        this.DF_SALE = DF_SALE;
    }

    public boolean isDF_BUY() {
        return DF_BUY;
    }

    public void setDF_BUY(boolean DF_BUY) {
        this.DF_BUY = DF_BUY;
    }

    public boolean isDF_STORE() {
        return DF_STORE;
    }

    public void setDF_STORE(boolean DF_STORE) {
        this.DF_STORE = DF_STORE;
    }

    public float getPRICE_BUY() {
        return PRICE_BUY;
    }

    public void setPRICE_BUY(float PRICE_BUY) {
        this.PRICE_BUY = PRICE_BUY;
    }

    public float getPRICE_COST() {
        return PRICE_COST;
    }

    public void setPRICE_COST(float PRICE_COST) {
        this.PRICE_COST = PRICE_COST;
    }

    public float getPRICE_SALE_1() {
        return PRICE_SALE_1;
    }

    public void setPRICE_SALE_1(float PRICE_SALE_1) {
        this.PRICE_SALE_1 = PRICE_SALE_1;
    }

    public float getPRICE_SALE_2() {
        return PRICE_SALE_2;
    }

    public void setPRICE_SALE_2(float PRICE_SALE_2) {
        this.PRICE_SALE_2 = PRICE_SALE_2;
    }

    public float getPRICE_SALE_3() {
        return PRICE_SALE_3;
    }

    public void setPRICE_SALE_3(float PRICE_SALE_3) {
        this.PRICE_SALE_3 = PRICE_SALE_3;
    }

    public float getPRICE_AVG_COST() {
        return PRICE_AVG_COST;
    }

    public void setPRICE_AVG_COST(float PRICE_AVG_COST) {
        this.PRICE_AVG_COST = PRICE_AVG_COST;
    }

    public float getPRICE_SALE_CUR() {
        return PRICE_SALE_CUR;
    }

    public void setPRICE_SALE_CUR(float PRICE_SALE_CUR) {
        this.PRICE_SALE_CUR = PRICE_SALE_CUR;
    }

    public Date getC_DATE() {
        return C_DATE;
    }

    public void setC_DATE(Date c_DATE) {
        C_DATE = c_DATE;
    }
}
