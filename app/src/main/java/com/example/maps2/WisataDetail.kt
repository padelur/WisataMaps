package com.example.maps2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WisataDetail : AppCompatActivity() {

    private lateinit var detailnama : TextView
    private lateinit var detailimg : ImageView
    private lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_wisata_detail)

        button = findViewById(R.id.btnDetail)
        detailnama = findViewById(R.id.txtDetailWisata)
        detailimg = findViewById(R.id.imgDetailWisata)

        val DetailNama = intent.getStringExtra("NamaWisata")
        val DetailImg = intent.getIntExtra("ImageWisata",0)
        val latitude = intent.getDoubleExtra("latitude",0.0)
        val longitude = intent.getDoubleExtra("longitude",0.0)

        Toast.makeText(this,"latitude{$latitude} {$longitude}", Toast.LENGTH_SHORT).show()


        detailnama.setText(DetailNama)
        detailimg.setImageResource((DetailImg))

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        button.setOnClickListener(){
            val intentMenu2 = Intent(this@WisataDetail,
                MapsActivity::class.java)
            //put latitude longitude
            intentMenu2.putExtra("latitude",latitude)
            intentMenu2.putExtra("longitude",longitude)
            startActivity(intentMenu2)
        }


    }
}