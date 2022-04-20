package br.com.contafacil.mpintegracao.utils.mvvm.modules

import br.com.contafacil.mpintegracao.application.home.HomeViewModel
import br.com.contafacil.mpintegracao.application.vendas.VendasViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{
        HomeViewModel()
    }
    viewModel{
        VendasViewModel()
    }
}