package br.com.emdev.shoppinglist.adapters

import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.emdev.shoppinglist.R
import br.com.emdev.shoppinglist.databinding.FragmentHomeBinding
import br.com.emdev.shoppinglist.databinding.PurchaseItemBinding
import br.com.emdev.shoppinglist.domain.model.Purchase
import br.com.emdev.shoppinglist.extensions.bind

class PurchaseAdapter : ListAdapter<Purchase, VerticalHolder>(MovieItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalHolder {
        return VerticalHolder(parent.bind(R.layout.purchase_item))
    }

    override fun onBindViewHolder(holder: VerticalHolder, position: Int) {
//        holder.itemView.setOnClickListener {
//            it.context.run {
//                //this.startActivity(Intent(this, MovieDetailActivity::class.java).apply {
//                  //  putExtra("movie", currentList[position])
//                Toast.makeText(this,"Clicou em"+it.id,Toast.LENGTH_SHORT).show()
//                })
//            }
//        }
        holder.binding.purchase = currentList[position]
    }
}

class VerticalHolder(val binding: PurchaseItemBinding) :
    RecyclerView.ViewHolder(binding.root)

class MovieItemCallback : DiffUtil.ItemCallback<Purchase>() {
    override fun areItemsTheSame(oldItem: Purchase, newItem: Purchase): Boolean {
        return oldItem._id == newItem._id
    }

    override fun areContentsTheSame(oldItem: Purchase, newItem: Purchase): Boolean {
        return oldItem == newItem
    }
}