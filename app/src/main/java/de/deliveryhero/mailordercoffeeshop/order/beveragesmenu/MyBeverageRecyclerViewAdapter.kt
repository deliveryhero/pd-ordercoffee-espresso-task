package de.deliveryhero.mailordercoffeeshop.order.beveragesmenu

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import de.deliveryhero.mailordercoffeeshop.R
import de.deliveryhero.mailordercoffeeshop.data.beverage.BeverageMenuItem
import de.deliveryhero.mailordercoffeeshop.databinding.FragmentBeverageBinding

/**
 * [RecyclerView.Adapter] that can display a [BeverageMenuItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 *
 */
class MyBeverageRecyclerViewAdapter(
        private val beverageMenuItems: List<BeverageMenuItem>,
        private val fragmentListener: MenuFragment.OnListFragmentInteractionListener?)
    : RecyclerView.Adapter<MyBeverageRecyclerViewAdapter.EspressoViewHolder>() {

    private val onClickListener: View.OnClickListener

    init {
        onClickListener = View.OnClickListener { v ->
            val item = v.tag as BeverageMenuItem
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            fragmentListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EspressoViewHolder {
        return EspressoViewHolder(DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.fragment_beverage, parent, false
        ))
    }

    override fun onBindViewHolder(holder: EspressoViewHolder, position: Int) {
        beverageMenuItems[position].let { beverages ->
            with(holder) {
                itemView.tag = beverages
                bind(onClickListener, beverages)
            }
        }
    }

    override fun getItemCount(): Int = beverageMenuItems.size

    inner class EspressoViewHolder(private val binding: FragmentBeverageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(listener: View.OnClickListener, beverage: BeverageMenuItem) {
            with(binding) {
                clickListener = listener
                viewModel = MenuViewModel(beverage)
                executePendingBindings()
            }
        }
    }
}
