package de.deliveryhero.mailordercoffeeshop.order

import androidx.lifecycle.ViewModelProviders
import android.content.Context
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.deliveryhero.mailordercoffeeshop.R

class HeaderFragment : androidx.fragment.app.Fragment() {
    companion object {
        fun newInstance(): HeaderFragment {
            return HeaderFragment()
        }

        val FRAGMENT_TAG = "FRAGMENT_TAG:${HeaderFragment::class.java.simpleName}"
    }

    private lateinit var headerFragmentViewModel: OrderViewModel
    private lateinit var headerListeners: OnHeaderSelected


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        headerFragmentViewModel = ViewModelProviders.of(activity!!).get(OrderViewModel::class.java)
        val mapBinding: de.deliveryhero.mailordercoffeeshop.databinding.FragmentHeaderBinding = DataBindingUtil.inflate<de.deliveryhero.mailordercoffeeshop.databinding.FragmentHeaderBinding>(inflater, R.layout.fragment_header, container, false).apply {
            viewModel = headerFragmentViewModel
            listener = headerListeners
        }
        return mapBinding.root
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnHeaderSelected) {
            headerListeners = context
        } else {
            throw ClassCastException(context.toString() + " must implement OnHeaderSelected.")
        }
    }

    interface OnHeaderSelected {
        fun onMenuSelected()

        fun onCustomOrderSelected()
    }


}


