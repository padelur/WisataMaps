package com.example.maps2.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.maps2.R
import com.example.maps2.WisataDetail
import com.example.maps2.model.ModelWisata
import com.example.maps2.screen.ListWisataActivity

class AdapterWisata (
    val getListWisata: ListWisataActivity,
    val itemWisataList: List<ModelWisata>
) : RecyclerView.Adapter<AdapterWisata.MyViewHolder>(){
    class MyViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        var imgageWisata : ImageView = itemView.findViewById(R.id.imgWisata)
        var txtNamaWisata : TextView = itemView.findViewById(R.id.txtNamaWisata)
        var txtLokasi : TextView = itemView.findViewById(R.id.txtLokasi)
        val cardWisata : CardView = itemView.findViewById(R.id.cardWisata)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_card, parent, false)
        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemWisataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemWisataList[position]
        holder.txtNamaWisata.text = currentItem.detailwisata
        holder.txtLokasi.text = currentItem.lokasiWisata
        holder.imgageWisata.setImageResource(currentItem.imageWisata)

        holder.cardWisata.setOnClickListener(){

            //deklarasi intent
            val intent = Intent(getListWisata, WisataDetail::class.java)
            //put Extra
            intent.putExtra("ImageWisata", itemWisataList[position].imageWisata)
            intent.putExtra("NamaWisata",itemWisataList[position].detailwisata)
            intent.putExtra("LokasiWisata",itemWisataList[position].lokasiWisata)
            intent.putExtra("Keterangan",itemWisataList[position].keterangan)
            //intent.putExtra("judul",itemList[position].judul)

            //tambahkan latitude longitude
            intent.putExtra("latitude",itemWisataList[position].latitude)
            intent.putExtra("longitude",itemWisataList[position].longitude)




            // start pindah ke detail
            getListWisata.startActivity(intent)

            Toast.makeText(getListWisata,itemWisataList[position].detailwisata, Toast.LENGTH_SHORT).show()

        }

    }
}