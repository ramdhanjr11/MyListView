package com.muramsyah.mylistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.muramsyah.mylistview.databinding.ItemHeroBinding
import de.hdodenhof.circleimageview.CircleImageView

class HeroAdapter internal constructor(private val context: Context) : BaseAdapter(){
    internal var heroes = arrayListOf<Hero>()

    override fun getCount(): Int = heroes.size

    override fun getItem(position: Int): Any = heroes[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_hero, parent, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val hero = getItem(position) as Hero
        viewHolder.bind(hero)
        return itemView
    }

    private inner class ViewHolder internal constructor(view: View) {
        // Has changes with view binding, with that can reduce more code to short
//        private val txtName: TextView = view.findViewById(R.id.txt_name)
//        private val txtDescription: TextView = view.findViewById(R.id.txt_description)
//        private val imgPhoto: CircleImageView = view.findViewById(R.id.img_photo)

        private var binding = ItemHeroBinding.bind(view)

        internal fun bind(hero: Hero) {
            binding.txtName.text = hero.name
            binding.txtDescription.text = hero.description
            binding.imgPhoto.setImageResource(hero.photo)
        }
    }
}