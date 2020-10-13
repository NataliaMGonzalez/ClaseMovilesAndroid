package com.example.recyclergyphy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private AdapterGyphy mAdapterGyphy;
    private List<Gyphy> mGyphyList;
    private RequestQueue mRequestQueue;

    private Button mButton;
    private EditText mEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
        mGyphyList = new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(this);
        mEditText = findViewById(R.id.editText_giphy);
    }

    public void buscarGyphy(View view) {

        mGyphyList.clear();
        String busqueda = mEditText.getText().toString();
        String url ="http://api.giphy.com/v1/gifs/search?q=" + busqueda + "&api_key=dc6zaTOxFJmzC&limit=20";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try {

                            JSONArray jsonArray = response.getJSONArray("data");

                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject gyphy = jsonArray.getJSONObject(i);
                                String imageUrl = gyphy.getJSONObject("images").getJSONObject("fixed_height").getString("url");
                                Log.i("CONSULTA_API",imageUrl);
                                mGyphyList.add(new Gyphy(imageUrl));

                            }

                            mAdapterGyphy = new AdapterGyphy(MainActivity.this,mGyphyList);
                            mRecyclerView.setAdapter(mAdapterGyphy);

                        }catch(JSONException ex) {
                            ex.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        mRequestQueue.add(request);


    }
}