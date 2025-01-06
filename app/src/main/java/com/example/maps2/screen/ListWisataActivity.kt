package com.example.maps2.screen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.maps2.Adapter.AdapterWisata
import com.example.maps2.R
import com.example.maps2.model.ModelWisata

class ListWisataActivity : AppCompatActivity() {

    private var rv_wisata: RecyclerView? = null
    private var WisataAdapter: AdapterWisata? = null

    private var wisataList = mutableListOf<ModelWisata>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_wisata)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        rv_wisata = findViewById(R.id.rv_wisata)
        wisataList = ArrayList()
        WisataAdapter= AdapterWisata(this,wisataList);
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this,1)
        rv_wisata!!.layoutManager = layoutManager
        rv_wisata!!.adapter = WisataAdapter

        //create dummy data
        prepareDataWisata()
    }

    private fun prepareDataWisata() {
        var itemWisata = ModelWisata(
            R.drawable.tiga,
            "Masjid Raya Sumbar",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                    "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                    "when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
            "Padang,Sumatra Barat",-0.9241240123977031, 100.36217556876177
        )
        wisataList.add(itemWisata)
        itemWisata = ModelWisata(
            R.drawable.empat,
            "Lembah Harau",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                    "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                    "when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
            "Lima Puluh Kota,Sumatra Barat ",-0.1062761, 100.6613319
        )
        wisataList.add(itemWisata)
        itemWisata = ModelWisata(
            R.drawable.dua,
            "Ngarai Sianok",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                    "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                    "when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
            "Bukittinggi,Sumatra Barat  ",-0.3079414, 100.3625977
        )
        wisataList.add(itemWisata)
        itemWisata = ModelWisata(
            R.drawable.lima,
            "Istana Pagaruyuang",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                    "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                    "when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
            "Tanah Datar,Sumatra Barat  ",-0.471291, 100.616534
        )
        wisataList.add(itemWisata)
        itemWisata = ModelWisata(
            R.drawable.satu,
            "Danau Maninjau",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                    "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                    "when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
            "Kabupaten Agam,Sumatra Barat  ",-0.3282321, 100.1466585
        )

        wisataList.add(itemWisata)
        WisataAdapter!!.notifyDataSetChanged()
    }
}