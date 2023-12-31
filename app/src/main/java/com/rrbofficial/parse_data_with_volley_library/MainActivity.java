package com.rrbofficial.parse_data_with_volley_library;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    String url = "https://www.google.com";
    String apiurl = "https://jsonplaceholder.typicode.com/todos";
    String getApiurl = "https://jsonplaceholder.typicode.com/todos/1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RequestQueue queue = Volley.newRequestQueue(this);
        // GET REQUEST FOR STRING
        queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, getApiurl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Log.d("JsonObje", "onCreate" + response.getString("title"));
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        } , new Response.ErrorListener(){
            @Override
            public  void onErrorResponse (VolleyError error)
            {

            }
        });
        queue.add(jsonObjectRequest);


// *************************THIS IS JSON ARRAY REQUEST AND WE EXTRACTED TO getJSONArrayRequest()**************************************
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, apiurl, null,
//                response -> {
//                for(int i =0; i< response.length(); i++)
//                {
//                    try {
//                        JSONObject jsonObject = response.getJSONObject(i);
//                        Log.d("json", "onCreate"+ jsonObject.getString("userId"));
//                        // for getting boolean
//                        Log.d("json", "onCreate"+ jsonObject.getBoolean("completed"));
//                    } catch (JSONException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//
//
//                },
//                error -> {
//                    Log.d("json", "Failed");
//                });

      //  JsonArrayRequest jsonArrayRequest = getJsonArrayRequest();

       // queue.add(jsonArrayRequest);
   //     getString(queue);


        // ************************THIS IS JSON OBJECT REQUEST********************

//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//             // display the content of our url
//                Log.d("Main", "onCreate: " + response.substring(0,500));
//
//            }
//        },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.d("Main", "Failed to get info");
//
//                    }
//                });
//
//        queue.add(stringRequest);
//    }


    }

    @NonNull
    private JsonArrayRequest getJsonArrayRequest() {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, apiurl, null,
                response -> {
                    for(int i =0; i< response.length(); i++)
                    {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            Log.d("json", "onCreate"+ jsonObject.getString("userId"));
                            // for getting boolean
                            Log.d("json", "onCreate"+ jsonObject.getBoolean("completed"));
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }


                },
                error -> {
                    Log.d("json", "Failed");
                });
        return jsonArrayRequest;
    }

    private void getString(RequestQueue queue) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // display the content of our url
                Log.d("Main", "onCreate: " + response.substring(0, 500));

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Main", "Failed to get info");

                    }
                });

        queue.add(stringRequest);
    }
}