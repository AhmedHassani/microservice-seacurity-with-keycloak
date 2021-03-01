package com.iraqsofit.speedoo.storebox;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_STORE_BOX")
public class StoreBox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "T_ID", updatable = false, nullable = false)
    private long id;
    @Column(name = "BILL_BRANCH")
    private String billBranch;
    @Column(name = "BILL_NUMBER")
    private long BILL_NUMBER;
    @Column(name = "BILL_DATE")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date BILL_DATE;
    @Column(name = "B_CODE")
    private int B_CODE;
    @Column(name = "WAJBA_CODE")
    private long WAJBA_CODE;
    @Column(name = "STORE_CODE")
    private int STORE_CODE;
    @Column(name = "EXP_DATE")
    private Date EXP_DATE;
    @Column(name = "ITEM_CODE")
    private long ITEM_CODE;
    @Column(name = "UNIT_CODE")
    private long UNIT_CODE;
    @Column(name = "ST_IN")
    private float ST_IN;
    @Column(name = "ST_OUT")
    private float ST_OUT;
    @Column(name = "ST_BALANCE",insertable = false, updatable = false)
    private float ST_BALANCE;
    @Column(name = "QTY_UNIT")
    private float QTY_UNIT;
    @Column(name = "IN_M",insertable = false, updatable = false)
    private float IN_M;
    @Column(name = "OUT_M",insertable = false, updatable = false)
    private float OUT_M;
    @Column(name = "BALANCE_M",insertable = false, updatable = false)
    private float BALANCE_M;
    @Column(name = "C_DATE")
    private Date C_DATE;
    @Column(name = "IS_AVG_COST")
    private boolean IS_AVG_COST;
    @Column(name = "AVG_COST")
    private float AVG_COST;
    @Column(name = "ACTIVE")
    private boolean ACTIVE;

    public StoreBox() {
        C_DATE = new Date();

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBillBranch() {
        return billBranch;
    }

    public void setBillBranch(String billBranch) {
        this.billBranch = billBranch;
    }

    public long getBILL_NUMBER() {
        return BILL_NUMBER;
    }

    public void setBILL_NUMBER(long BILL_NUMBER) {
        this.BILL_NUMBER = BILL_NUMBER;
    }

    public Date getBILL_DATE() {
        return BILL_DATE;
    }

    public void setBILL_DATE(Date BILL_DATE) {
        this.BILL_DATE = BILL_DATE;
    }

    public int getB_CODE() {
        return B_CODE;
    }

    public void setB_CODE(int b_CODE) {
        B_CODE = b_CODE;
    }

    public long getWAJBA_CODE() {
        return WAJBA_CODE;
    }

    public void setWAJBA_CODE(long WAJBA_CODE) {
        this.WAJBA_CODE = WAJBA_CODE;
    }

    public int getSTORE_CODE() {
        return STORE_CODE;
    }

    public void setSTORE_CODE(int STORE_CODE) {
        this.STORE_CODE = STORE_CODE;
    }

    public Date getEXP_DATE() {
        return EXP_DATE;
    }

    public void setEXP_DATE(Date EXP_DATE) {
        this.EXP_DATE = EXP_DATE;
    }

    public long getITEM_CODE() {
        return ITEM_CODE;
    }

    public void setITEM_CODE(long ITEM_CODE) {
        this.ITEM_CODE = ITEM_CODE;
    }

    public long getUNIT_CODE() {
        return UNIT_CODE;
    }

    public void setUNIT_CODE(long UNIT_CODE) {
        this.UNIT_CODE = UNIT_CODE;
    }

    public float getST_IN() {
        return ST_IN;
    }

    public void setST_IN(float ST_IN) {
        this.ST_IN = ST_IN;
    }

    public float getST_OUT() {
        return ST_OUT;
    }

    public void setST_OUT(float ST_OUT) {
        this.ST_OUT = ST_OUT;
    }

    public float getST_BALANCE() {
        return ST_BALANCE;
    }


    public float getQTY_UNIT() {
        return QTY_UNIT;
    }

    public void setQTY_UNIT(float QTY_UNIT) {
        this.QTY_UNIT = QTY_UNIT;
    }

    public float getIN_M() {
        return IN_M;
    }

    public float getOUT_M() {
        return OUT_M;
    }

    public float getBALANCE_M() {
        return BALANCE_M;
    }

    public Date getC_DATE() {
        return C_DATE;
    }

    public void setC_DATE(Date c_DATE) {
        C_DATE = c_DATE;
    }

    public boolean isIS_AVG_COST() {
        return IS_AVG_COST;
    }

    public void setIS_AVG_COST(boolean IS_AVG_COST) {
        this.IS_AVG_COST = IS_AVG_COST;
    }

    public float getAVG_COST() {
        return AVG_COST;
    }

    public void setAVG_COST(float AVG_COST) {
        this.AVG_COST = AVG_COST;
    }

    public boolean isACTIVE() {
        return ACTIVE;
    }

    public void setACTIVE(boolean ACTIVE) {
        this.ACTIVE = ACTIVE;
    }
}
