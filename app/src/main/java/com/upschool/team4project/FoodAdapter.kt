package com.upschool.team4project

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.upschool.team4project.databinding.YemekCardBinding
import com.upschool.team4project.entity.Yemekler
import kotlinx.android.synthetic.main.fragment_detail_page.view.*

class FoodAdapter(var mContext:Context, var foodList: List<Yemekler>): RecyclerView.Adapter<FoodAdapter.CardDesignKeeper>() {

    inner class CardDesignKeeper(yemekCardBinding: YemekCardBinding):RecyclerView.ViewHolder(yemekCardBinding.root){
        var design:YemekCardBinding

        init {
            this.design = yemekCardBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignKeeper {
        val layoutInflater = LayoutInflater.from(mContext)
        val design = YemekCardBinding.inflate(layoutInflater, parent, false)

        return CardDesignKeeper(design)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: CardDesignKeeper, position: Int) {
        val food =foodList.get(position)

        holder.design.yemekNesnesi=food

        //Picasso part
        var url = "http://kasimadalan.pe.hu/yemekler/resimler/"+food.yemek_resim_adi
        var id=holder.design.imageViewYemek
        Picasso.get().load(url).into(id);


        holder.design.textView.text = food.yemek_adi
        holder.design.textView2.text = food.yemek_fiyat.toString()

        holder.design.foodCardview.setOnClickListener {
            var gecis= HomePageFragmentDirections.detayaGecis(food)
            Navigation.findNavController(it).navigate(gecis)
        }
        }

    }
