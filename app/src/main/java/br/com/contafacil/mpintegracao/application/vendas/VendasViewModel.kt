package br.com.contafacil.mpintegracao.application.vendas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.contafacil.mpintegracao.utils.mercadopago.PaymentResult

class VendasViewModel : ViewModel() {
    private val _formasDePagamento = MutableLiveData<List<String>>()
    val formasDePagamento: LiveData<List<String>> get() = _formasDePagamento

    private val _parcelas = MutableLiveData<List<Int>>()
    val parcelas: LiveData<List<Int>> get() = _parcelas

    private val _resultadoPagamento = MutableLiveData<PaymentResult>()
    val resultadoPagamento: LiveData<PaymentResult> get() = _resultadoPagamento

    init {
        _formasDePagamento.value = listOf<String>("Débito", "Crédito")
        _parcelas.value = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
    }

    fun setResultadoPagamento(resultadoPagamento: PaymentResult) {
        _resultadoPagamento.value = resultadoPagamento
    }

}