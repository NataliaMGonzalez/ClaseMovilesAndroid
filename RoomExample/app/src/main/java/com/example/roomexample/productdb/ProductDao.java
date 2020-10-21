package com.example.roomexample.productdb;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
// Data access object
@Dao

public interface ProductDao {


    @Query("SELECT * FROM " + Constants.TABLE_NAME_PRODUCTS + " where product_id = :id")
    Product searchById(long id);


    @Insert
    long insertProduct(Product product);

    @Delete
    void deleteProduct(Product product);
}
