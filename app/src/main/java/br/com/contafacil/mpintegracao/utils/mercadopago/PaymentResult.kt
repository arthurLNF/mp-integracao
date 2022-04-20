package br.com.contafacil.mpintegracao.utils.mercadopago

data class PaymentResult(
    val status: String,
    val paymentId: Long,
    val installments: Int,
    val amount: Double,
    val cardType: String
)