package com.ashok.memesharevolley

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

class MainActivity : AppCompatActivity() {
     lateinit var  currentImageurl : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadMeme()

    }

    fun loadMeme() {
         val imageView = findViewById<ImageView>(R.id.imageView)
         val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.visibility = View.VISIBLE

        val queue = Volley.newRequestQueue(this)

// Request a string response from the provided URL.
        val url = "https://meme-api.com/gimme"

        val jsonObjectRequest = JsonObjectRequest( Request.Method.GET, url, null,
            { response ->
                currentImageurl = response.getString("url")
                Glide.with(this).load( currentImageurl).listener(object : RequestListener<Drawable> {

                    override fun onResourceReady(
                        resource: Drawable,
                        model: Any,
                        target: com.bumptech.glide.request.target.Target<Drawable>?,
                        dataSource: DataSource,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressBar.visibility = View.GONE
                        return false
                    }

                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressBar.visibility = View.GONE
                        return false
                    }

                }).into(imageView)
            },
            { error ->
                Toast.makeText(this,"something wrong ",Toast.LENGTH_LONG)
            }
        )

        // Add the request to the RequestQueue.
       // queue.add(jsonObjectRequest)
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)             //using singleton pattern

    }

    fun shareMeme(view : View){
         val intent = Intent(Intent.ACTION_SEND)
         intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT , currentImageurl)
         val chooser = Intent.createChooser(intent,"share this meme")
         startActivity(chooser)
    }

    fun nextMeme(view : View){
        loadMeme()
    }


}