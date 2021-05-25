package com.upschool.team4project

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.upschool.team4project.databinding.YemekCardBinding

class FoodAdapter(var mContext:Context, var foodList: List<Food>): RecyclerView.Adapter<FoodAdapter.CardDesignKeeper>() {

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
        holder.design.imageViewYemek.setImageResource(
            mContext.resources.getIdentifier(food.yemek_adi,"drawable", mContext.packageName))

        holder.design.textView.text = food.yemek_adi
        holder.design.textView2.text = food.yemek_fiyat.toString()


    }
}