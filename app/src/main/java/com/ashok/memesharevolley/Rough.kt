package com.ashok.memesharevolley

import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide

class Rough {

    //this code is without singleton pattern

//    fun loadMeme() {
//        val imageView = findViewById<ImageView>(R.id.imageView)
//
//        val queue = Volley.newRequestQueue(this)
//
//// Request a string response from the provided URL.
//        val url = "https://meme-api.com/gimme"
//
//        val jsonObjectRequest = JsonObjectRequest( Request.Method.GET, url, null,
//            Response.Listener { response ->
//                val url = response.getString("url")
//                Glide.with(this).load(url).into(imageView)
//            },
//            Response.ErrorListener { error ->
//                Toast.makeText(this,"something worng ", Toast.LENGTH_LONG)
//            }
//        )
//
//        // Add the request to the RequestQueue.
//        queue.add(jsonObjectRequest)
//
//    }
//
//    fun shareMeme(view : View){
//
//    }
//
//    fun nextMeme(view : View){
//        loadMeme()
//    }
//
//


}

