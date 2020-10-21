package com.example.roomexample.productdb;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;

@Entity(tableName = Constants.TABLE_NAME_PRODUCTS)

public class Product implements Serializable {

    // Columns
    @PrimaryKey(autoGenerate = true)
    private long product_id;

    private String title;
    private Date date;
    private int quantity;


    public Product(String title, int quantity) {
        this.title = title;
        this.date = new Date(System.currentTimeMillis());
        this.quantity = quantity;
    }


    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
