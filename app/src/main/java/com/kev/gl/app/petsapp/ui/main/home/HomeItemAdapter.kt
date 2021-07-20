package com.kev.gl.app.petsapp.ui.main.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kev.gl.app.petsapp.data.model.Pet
import com.kev.gl.app.petsapp.databinding.ItemHomeBinding

/**
 * @author Kevin Villalobos
 */
class HomeItemAdapter(
    private val block: (item: Pet, view: View) -> Unit
) : RecyclerView.Adapter<HomeItemAdapter.HomeItemHolder>() {

    /**
     * List of Items to Display
     */
    private val homeItems = ArrayList<Pet>()

    /**
     * Add Items to the Adapter and Notify the Changes
     */
    fun addItems(items: List<Pet>) {
        homeItems.clear()
        homeItems.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeItemHolder {
        // Layout Inflater
        val layoutInflater = LayoutInflater.from(parent.context)
        // Item View Holder using Data Bind
        val itemBinding = ItemHomeBinding.inflate(layoutInflater, parent, false)
        return HomeItemHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return homeItems.size
    }

    override fun onBindViewHolder(holder: HomeItemHolder, position: Int) {
        holder.bind(homeItems[position], block)
    }

    class HomeItemHolder internal constructor(
        private val mBinding: ItemHomeBinding
    ) : RecyclerView.ViewHolder(mBinding.root) {

        /**
         * Bind the Holder with the Item Data
         */
        fun bind(item: Pet, block: (item: Pet, view: View) -> Unit) {
            mBinding.apply {
                pet = item
                executePendingBindings()
                clItemContainer.setOnClickListener {
                    block(item, cardPet)
                }
            }
        }
    }
}