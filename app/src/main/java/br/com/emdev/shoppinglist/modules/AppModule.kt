package br.com.emdev.shoppinglist.modules

import br.com.emdev.shoppinglist.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { HomeViewModel() }
}





