package br.com.emdev.shoppinglist.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import br.com.emdev.shoppinglist.R
import br.com.emdev.shoppinglist.adapters.PurchaseAdapter
import br.com.emdev.shoppinglist.databinding.FragmentHomeBinding
import br.com.emdev.shoppinglist.extensions.bind
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()
    private var itemAdapter = PurchaseAdapter()
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //val rv_purchase:RecyclerView= binding.rvPurchase

        binding= bind<FragmentHomeBinding>(R.layout.fragment_home).apply {
            lifecycleOwner =this@HomeFragment
            rvPurchase.adapter = itemAdapter
        }
        homeViewModel.purchase.observe(this.viewLifecycleOwner, Observer {
            Log.i("Values", it.toString())
            itemAdapter.submitList(it)
            binding.vmHome = homeViewModel
        })
        homeViewModel.getPurchase()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        //_binding = null
    }
}