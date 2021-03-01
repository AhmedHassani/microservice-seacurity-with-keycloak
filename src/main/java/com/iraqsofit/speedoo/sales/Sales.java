package com.iraqsofit.speedoo.sales;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_SALES")
public class Sales {
    @Id
    @Column(name = "BILL_BRANCH",insertable = true,updatable = false)
    private String id;

    @Column(name = "BILL_NUMBER")
    private long BILL_NUMBER;

    @Column(name = "BILL_INVOICE")
    private String BILL_INVOICE;

    @Column(name = "BILL_DATE")
    private Date BILL_DATE;

    @Column(name = "OFFER_CODE")
    private int OFFER_CODE;

    @Column(name = "CURRANCY_CODE")
    private int CURRANCY_CODE;

    @Column(name = "CURRANCY_EQUAL")
    private float CURRANCY_EQUAL;

    @Column(name = "CLIENT_CODE")
    private long CLIENT_CODE;

    @Column(name = "CLIENT_NAME")
    private String  CLIENT_NAME;

    @Column(name = "CLIENT_PHONE")
    private String  CLIENT_PHONE;

    @Column(name = "CLIENT_ADRESS")
    private String  CLIENT_ADRESS;

    @Column(name = "MANDOOB_CODE")
    private int  MANDOOB_CODE;

    @Column(name = "DESCRIPTION")
    private String  DESCRIPTION;

    @Column(name = "TYPE_PRICE_SELL")
    private int  TYPE_PRICE_SELL;

    @Column(name = "STORE_CODE")
    private int  STORE_CODE;

    @Column(name = "USER_CREATE")
    private String  USER_CREATE;

    @Column(name = "SECURETY_CODE")
    private int  SECURETY_CODE;

    @Column(name = "TOTAL_SALES")
    private float  TOTAL_SALES;

    @Column(name = "DISCOUNT_ITEMS")
    private float  DISCOUNT_ITEMS;

    @Column(name = "DISCOUNT_PERCENT")
    private float  DISCOUNT_PERCENT;

    @Column(name = "DISCOUNT_AMOUNT")
    private float  DISCOUNT_AMOUNT;

    @Column(name = "TOTAL_DISCOUNT")
    private float  TOTAL_DISCOUNT;

    @Column(name = "NET_SALES")
    private float  NET_SALES;

    @Column(name = "TOTAL_COST")
    private float  TOTAL_COST;

    @Column(name = "TOTAL_ARBAH",insertable = false,updatable = false)
    private float  TOTAL_ARBAH;

    @Column(name = "IVC_CODE")
    private int  IVC_CODE;

    @Column(name = "DAY_CASH")
    private int  DAY_CASH;

    @Column(name = "DATE_CASH")
    private Date  DATE_CASH;

    @Column(name = "TOT_CONV")
    private String  TOT_CONV;

    @Column(name = "ACCOUNT_CODE")
    private long  ACCOUNT_CODE;

    @Column(name = "CASH_USA")
    private float  CASH_USA;

    @Column(name = "REMAIN_USA")
    private float  REMAIN_USA;

    @Column(name = "CASH_IQ")
    private float  CASH_IQ;

    @Column(name = "REMAIN_IQ")
    private float  REMAIN_IQ;

    @Column(name = "C_DATE")
    private Date  C_DATE;

    @Column(name = "C_UPDATE")
    private String  C_UPDATE;

    @Column(name = "USER_UPDATE")
    private String  USER_UPDATE;

    @Column(name = "ACTIVE")
    private boolean  ACTIVE;

    @Column(name = "IS_AVG_COST")
    private boolean  IS_AVG_COST;

    @Column(name = "AVG_COST")
    private float  AVG_COST;

    @Column(name = "FLAG_CASH")
    private int  FLAG_CASH;

    @Column(name = "IS_OUT")
    private boolean  IS_OUT;

    @Column(name = "CURRANCY_SALES")
    private float  CURRANCY_SALES;

    public Sales() {
        C_DATE = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getBILL_NUMBER() {
        return BILL_NUMBER;
    }

    public void setBILL_NUMBER(long BILL_NUMBER) {
        this.BILL_NUMBER = BILL_NUMBER;
    }

    public String getBILL_INVOICE() {
        return BILL_INVOICE;
    }

    public void setBILL_INVOICE(String BILL_INVOICE) {
        this.BILL_INVOICE = BILL_INVOICE;
    }

    public Date getBILL_DATE() {
        return BILL_DATE;
    }

    public void setBILL_DATE(Date BILL_DATE) {
        this.BILL_DATE = BILL_DATE;
    }

    public int getOFFER_CODE() {
        return OFFER_CODE;
    }

    public void setOFFER_CODE(int OFFER_CODE) {
        this.OFFER_CODE = OFFER_CODE;
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

    public long getCLIENT_CODE() {
        return CLIENT_CODE;
    }

    public void setCLIENT_CODE(long CLIENT_CODE) {
        this.CLIENT_CODE = CLIENT_CODE;
    }

    public String getCLIENT_NAME() {
        return CLIENT_NAME;
    }

    public void setCLIENT_NAME(String CLIENT_NAME) {
        this.CLIENT_NAME = CLIENT_NAME;
    }

    public String getCLIENT_PHONE() {
        return CLIENT_PHONE;
    }

    public void setCLIENT_PHONE(String CLIENT_PHONE) {
        this.CLIENT_PHONE = CLIENT_PHONE;
    }

    public String getCLIENT_ADRESS() {
        return CLIENT_ADRESS;
    }

    public void setCLIENT_ADRESS(String CLIENT_ADRESS) {
        this.CLIENT_ADRESS = CLIENT_ADRESS;
    }

    public int getMANDOOB_CODE() {
        return MANDOOB_CODE;
    }

    public void setMANDOOB_CODE(int MANDOOB_CODE) {
        this.MANDOOB_CODE = MANDOOB_CODE;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public int getTYPE_PRICE_SELL() {
        return TYPE_PRICE_SELL;
    }

    public void setTYPE_PRICE_SELL(int TYPE_PRICE_SELL) {
        this.TYPE_PRICE_SELL = TYPE_PRICE_SELL;
    }

    public int getSTORE_CODE() {
        return STORE_CODE;
    }

    public void setSTORE_CODE(int STORE_CODE) {
        this.STORE_CODE = STORE_CODE;
    }

    public String getUSER_CREATE() {
        return USER_CREATE;
    }

    public void setUSER_CREATE(String USER_CREATE) {
        this.USER_CREATE = USER_CREATE;
    }

    public int getSECURETY_CODE() {
        return SECURETY_CODE;
    }

    public void setSECURETY_CODE(int SECURETY_CODE) {
        this.SECURETY_CODE = SECURETY_CODE;
    }

    public float getTOTAL_SALES() {
        return TOTAL_SALES;
    }

    public void setTOTAL_SALES(float TOTAL_SALES) {
        this.TOTAL_SALES = TOTAL_SALES;
    }

    public float getDISCOUNT_ITEMS() {
        return DISCOUNT_ITEMS;
    }

    public void setDISCOUNT_ITEMS(float DISCOUNT_ITEMS) {
        this.DISCOUNT_ITEMS = DISCOUNT_ITEMS;
    }

    public float getDISCOUNT_PERCENT() {
        return DISCOUNT_PERCENT;
    }

    public void setDISCOUNT_PERCENT(float DISCOUNT_PERCENT) {
        this.DISCOUNT_PERCENT = DISCOUNT_PERCENT;
    }

    public float getDISCOUNT_AMOUNT() {
        return DISCOUNT_AMOUNT;
    }

    public void setDISCOUNT_AMOUNT(float DISCOUNT_AMOUNT) {
        this.DISCOUNT_AMOUNT = DISCOUNT_AMOUNT;
    }

    public float getTOTAL_DISCOUNT() {
        return TOTAL_DISCOUNT;
    }

    public void setTOTAL_DISCOUNT(float TOTAL_DISCOUNT) {
        this.TOTAL_DISCOUNT = TOTAL_DISCOUNT;
    }

    public float getNET_SALES() {
        return NET_SALES;
    }

    public void setNET_SALES(float NET_SALES) {
        this.NET_SALES = NET_SALES;
    }

    public float getTOTAL_COST() {
        return TOTAL_COST;
    }

    public void setTOTAL_COST(float TOTAL_COST) {
        this.TOTAL_COST = TOTAL_COST;
    }

    public float getTOTAL_ARBAH() {
        return TOTAL_ARBAH;
    }

    public void setTOTAL_ARBAH(float TOTAL_ARBAH) {
        this.TOTAL_ARBAH = TOTAL_ARBAH;
    }

    public int getIVC_CODE() {
        return IVC_CODE;
    }

    public void setIVC_CODE(int IVC_CODE) {
        this.IVC_CODE = IVC_CODE;
    }

    public int getDAY_CASH() {
        return DAY_CASH;
    }

    public void setDAY_CASH(int DAY_CASH) {
        this.DAY_CASH = DAY_CASH;
    }

    public Date getDATE_CASH() {
        return DATE_CASH;
    }

    public void setDATE_CASH(Date DATE_CASH) {
        this.DATE_CASH = DATE_CASH;
    }

    public String getTOT_CONV() {
        return TOT_CONV;
    }

    public void setTOT_CONV(String TOT_CONV) {
        this.TOT_CONV = TOT_CONV;
    }

    public long getACCOUNT_CODE() {
        return ACCOUNT_CODE;
    }

    public void setACCOUNT_CODE(long ACCOUNT_CODE) {
        this.ACCOUNT_CODE = ACCOUNT_CODE;
    }

    public float getCASH_USA() {
        return CASH_USA;
    }

    public void setCASH_USA(float CASH_USA) {
        this.CASH_USA = CASH_USA;
    }

    public float getREMAIN_USA() {
        return REMAIN_USA;
    }

    public void setREMAIN_USA(float REMAIN_USA) {
        this.REMAIN_USA = REMAIN_USA;
    }

    public float getCASH_IQ() {
        return CASH_IQ;
    }

    public void setCASH_IQ(float CASH_IQ) {
        this.CASH_IQ = CASH_IQ;
    }

    public float getREMAIN_IQ() {
        return REMAIN_IQ;
    }

    public void setREMAIN_IQ(float REMAIN_IQ) {
        this.REMAIN_IQ = REMAIN_IQ;
    }

    public Date getC_DATE() {
        return C_DATE;
    }

    public void setC_DATE(Date c_DATE) {
        C_DATE = c_DATE;
    }

    public String getC_UPDATE() {
        return C_UPDATE;
    }

    public void setC_UPDATE(String c_UPDATE) {
        C_UPDATE = c_UPDATE;
    }

    public String getUSER_UPDATE() {
        return USER_UPDATE;
    }

    public void setUSER_UPDATE(String USER_UPDATE) {
        this.USER_UPDATE = USER_UPDATE;
    }

    public boolean isACTIVE() {
        return ACTIVE;
    }

    public void setACTIVE(boolean ACTIVE) {
        this.ACTIVE = ACTIVE;
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

    public int getFLAG_CASH() {
        return FLAG_CASH;
    }

    public void setFLAG_CASH(int FLAG_CASH) {
        this.FLAG_CASH = FLAG_CASH;
    }

    public boolean isIS_OUT() {
        return IS_OUT;
    }

    public void setIS_OUT(boolean IS_OUT) {
        this.IS_OUT = IS_OUT;
    }

    public float getCURRANCY_SALES() {
        return CURRANCY_SALES;
    }

    public void setCURRANCY_SALES(float CURRANCY_SALES) {
        this.CURRANCY_SALES = CURRANCY_SALES;
    }
}
