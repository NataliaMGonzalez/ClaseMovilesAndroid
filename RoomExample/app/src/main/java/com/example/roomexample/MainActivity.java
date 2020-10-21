package com.example.roomexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.roomexample.productdb.Product;
import com.example.roomexample.productdb.ProductsDatabase;

public class MainActivity extends AppCompatActivity {

    TextView idView;
    EditText productBox;
    EditText quantityBox;
    EditText editTextProductId;

    private ProductsDatabase productsDatabase;
    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idView = findViewById(R.id.productID);
        productBox = findViewById(R.id.productName);
        quantityBox = findViewById(R.id.productQuantity);
        editTextProductId = findViewById(R.id.editText_productId);

        productsDatabase = ProductsDatabase.getInstance(this);

    }

    public void lookupProduct(View view) {
        String id = editTextProductId.getText().toString();

        productsDatabase.getProductDao().searchById(Integer.parseInt(id));

        if(product != null){
            idView.setText(String.valueOf(product.getProduct_id()));
            productBox.setText(String.valueOf(product.getTitle()));
            quantityBox.setText(String.valueOf(product.getQuantity()));
        }
        else {
            idView.setText("ID not found");
        }
    }
    public void removeProduct(View view) {
        // Step 1 search product
        Integer id = Integer.parseInt(editTextProductId.getText().toString());
        Product product = productsDatabase.getProductDao().searchById(id);

        // Step 2
        if(product != null){
            productsDatabase.getProductDao().deleteProduct(product);
            idView.setText("Product deleted");
        }
        else{
            idView.setText("Product not found");
        }
    }

    public void newProduct(View view) {

        int quantity = Integer.parseInt(quantityBox.getText().toString());
        String name = productBox.getText().toString();
        Product product = new Product(name, quantity);

        long j = productsDatabase.getProductDao().insertProduct(product);
        idView.setText("Product created with ID: " + j);
    }
}