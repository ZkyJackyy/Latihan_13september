package com.zack.latihan_13september

import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.zack.latihan_13september.adapter.photoAdapter

class GalleryPhoto : AppCompatActivity() {

    private val imageList = arrayOf(
        R.drawable.gp,
        R.drawable.tp,
        R.drawable.gpkm,
        R.drawable.masjd
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_gallery_photo)

        val gridview = findViewById<GridView>(R.id.gridView)
        val adapter = photoAdapter(this, imageList)
        gridview.adapter =adapter

        gridview.setOnItemClickListener{_,_,position,_->
            val intent = Intent(this,photoDetail::class.java)
            intent.putExtra("imageResId",imageList[position])
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}