package com.iraqsofit.speedoo.barcode;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "T_ITEM_BARCODE")
public class BarCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "T_ID",unique = false,insertable = false)
    private long id ;

    @Column(name = "ITEM_CODE")
    private int ITEM_CODE;

    @Column(name = "TYPE_VAL")
    private int TYPE_VAL;

    @Column(name = "ITEM_BARCODE")
    private String ITEM_BARCODE;

    @Column(name = "UNIT_CODE")
    private int UNIT_CODE;

    @Column(name = "UNIT_NAME")
    private String UNIT_NAME;

    @Column(name = "C_DATE")
    private Date C_DATE;

    public BarCode() {
        C_DATE = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getITEM_CODE() {
        return ITEM_CODE;
    }

    public void setITEM_CODE(int ITEM_CODE) {
        this.ITEM_CODE = ITEM_CODE;
    }

    public int getTYPE_VAL() {
        return TYPE_VAL;
    }

    public void setTYPE_VAL(int TYPE_VAL) {
        this.TYPE_VAL = TYPE_VAL;
    }

    public String getITEM_BARCODE() {
        return ITEM_BARCODE;
    }

    public void setITEM_BARCODE(String ITEM_BARCODE) {
        this.ITEM_BARCODE = ITEM_BARCODE;
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

    public Date getC_DATE() {
        return C_DATE;
    }

    public void setC_DATE(Date c_DATE) {
        C_DATE = c_DATE;
    }
}
