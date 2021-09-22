package br.com.emdev.shoppinglist.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.emdev.shoppinglist.domain.model.Purchase
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _purchase = MutableLiveData<List<Purchase>>()
    val purchase: LiveData<List<Purchase>> = _purchase

    fun getPurchase() = viewModelScope.launch {
        _purchase.value = getFakePurchases()
    }
}

fun getFakePurchases(): List<Purchase> {
    return listOf(
        Purchase("1", "Purchase 1", "01/01/2021"),
        Purchase("2", "Purchase 2", "02/01/2021"),
        Purchase("3", "Purchase 3", "03/01/2021"),
        Purchase("4", "Purchase 4", "04/01/2021")
    )
}



