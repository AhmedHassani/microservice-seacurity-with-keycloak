package com.iraqsofit.speedoo.items;
import javax.persistence.*;


@Entity
@Table(name = "T_ITEMS")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_CODE", updatable = false, nullable = false)
    private int itemCode;
    @Column(name = "ITEM_NAME")
    private String itemName;
    @Column(name = "CATEGORY_CODE")
    private int categoryCode;
    @Column(name = "TYPE_CODE")
    private int typeCode;
    @Column(name = "COST")
    private float cost;
    @Column(name = "SELL")
    private float sell;
    @Column(name = "ITEM_BARCODE")
    private String itemBarcode;
    @Column(name = "SORT")
    private int sort;
    @Column(name = "ACTIVE")
    private int active;
    @Column(name = "PRINTER_ID")
    private int IdPrinter;
    @Column(name = "ITEM_NOTE")
    private String ItemNote;
    @Column(name = "IMG_URL")
    private String ImgURL;
    @Column(name = "ITEM_NAME_EN")
    private String ItemNameEN;
    @Column(name = "ITEM_NOTE_EN")
    private String NoteEN;
    @Column(name = "TIME_USE")
    private String TimeUSE;
    @Column(name = "IS_STORE")
    private int IsStore;
    @Column(name = "QTY_MIN")
    private float QtyMTN;
    @Column(name = "ON2_OFF2")
    private int ON2_OFF2;
    @Column(name = "UNIT2_NAME")
    private String UNIT2_NAME;
    @Column(name = "UNIT2_QTY")
    private float UNIT2_QTY;
    @Column(name = "DF_SALE")
    private int DF_SALE;
    @Column(name = "SELL2")
    private float SELL2;
    @Column(name = "SELL_CNY")
    private float SELL_CNY;
    @Column(name = "SELL2_CNY")
    private float SELL2_CNY;
    @Column(name = "SHOW_MENU")
    private int SHOW_MENU;
    @Column(name = "SELL_G")
    private float SELL_G;
    @Column(name = "SELL_W")
    private float SELL_W;
    @Column(name = "SELL2_G")
    private float SELL2_G;
    @Column(name = "SELL2_W")
    private float SELL2_W;


    public Items() {
    }

    public Items(String itemName,float cost,float sell) {
        this.itemName = itemName;
        this.cost=cost;
        this.sell=sell;
    }

    public Items(String itemName, int categoryCode, int typeCode, float cost, float sell, String itemBarcode) {
        this.itemName = itemName;
        this.categoryCode = categoryCode;
        this.typeCode = typeCode;
        this.cost = cost;
        this.sell = sell;
        this.itemBarcode=itemBarcode;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(int typeCode) {
        this.typeCode = typeCode;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getSell() {
        return sell;
    }

    public void setSell(float sell) {
        this.sell = sell;
    }

    public String getItemBarcode() {
        return itemBarcode;
    }

    public void setItemBarcode(String itemBarcode) {
        this.itemBarcode = itemBarcode;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getIdPrinter() {
        return IdPrinter;
    }

    public void setIdPrinter(int idPrinter) {
        IdPrinter = idPrinter;
    }

    public String getItemNote() {
        return ItemNote;
    }

    public void setItemNote(String itemNote) {
        ItemNote = itemNote;
    }

    public String getImgURL() {
        return ImgURL;
    }

    public void setImgURL(String imgURL) {
        ImgURL = imgURL;
    }

    public String getItemNameEN() {
        return ItemNameEN;
    }

    public void setItemNameEN(String itemNameEN) {
        ItemNameEN = itemNameEN;
    }

    public String getNoteEN() {
        return NoteEN;
    }

    public void setNoteEN(String noteEN) {
        NoteEN = noteEN;
    }

    public String getTimeUSE() {
        return TimeUSE;
    }

    public void setTimeUSE(String timeUSE) {
        TimeUSE = timeUSE;
    }

    public int getIsStore() {
        return IsStore;
    }

    public void setIsStore(int isStore) {
        IsStore = isStore;
    }

    public float getQtyMTN() {
        return QtyMTN;
    }

    public void setQtyMTN(float qtyMTN) {
        QtyMTN = qtyMTN;
    }

    public int getON2_OFF2() {
        return ON2_OFF2;
    }

    public void setON2_OFF2(int ON2_OFF2) {
        this.ON2_OFF2 = ON2_OFF2;
    }

    public String getUNIT2_NAME() {
        return UNIT2_NAME;
    }

    public void setUNIT2_NAME(String UNIT2_NAME) {
        this.UNIT2_NAME = UNIT2_NAME;
    }

    public float getUNIT2_QTY() {
        return UNIT2_QTY;
    }

    public void setUNIT2_QTY(float UNIT2_QTY) {
        this.UNIT2_QTY = UNIT2_QTY;
    }

    public int getDF_SALE() {
        return DF_SALE;
    }

    public void setDF_SALE(int DF_SALE) {
        this.DF_SALE = DF_SALE;
    }

    public float getSELL2() {
        return SELL2;
    }

    public void setSELL2(float SELL2) {
        this.SELL2 = SELL2;
    }

    public float getSELL_CNY() {
        return SELL_CNY;
    }

    public void setSELL_CNY(float SELL_CNY) {
        this.SELL_CNY = SELL_CNY;
    }

    public float getSELL2_CNY() {
        return SELL2_CNY;
    }

    public void setSELL2_CNY(float SELL2_CNY) {
        this.SELL2_CNY = SELL2_CNY;
    }

    public int getSHOW_MENU() {
        return SHOW_MENU;
    }

    public void setSHOW_MENU(int SHOW_MENU) {
        this.SHOW_MENU = SHOW_MENU;
    }

    public float getSELL_G() {
        return SELL_G;
    }

    public void setSELL_G(float SELL_G) {
        this.SELL_G = SELL_G;
    }

    public float getSELL_W() {
        return SELL_W;
    }

    public void setSELL_W(float SELL_W) {
        this.SELL_W = SELL_W;
    }

    public float getSELL2_G() {
        return SELL2_G;
    }

    public void setSELL2_G(float SELL2_G) {
        this.SELL2_G = SELL2_G;
    }

    public float getSELL2_W() {
        return SELL2_W;
    }

    public void setSELL2_W(float SELL2_W) {
        this.SELL2_W = SELL2_W;
    }

}
