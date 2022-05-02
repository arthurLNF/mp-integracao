package br.com.contafacil.mpintegracao.application.vendas

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import br.com.contafacil.mpintegracao.R
import br.com.contafacil.mpintegracao.utils.formatacao.MoneyTextWatcher
import br.com.contafacil.mpintegracao.utils.mercadopago.BundleCodes
import br.com.contafacil.mpintegracao.utils.mercadopago.PaymentResult
import cn.pedant.SweetAlert.SweetAlertDialog
import kotlinx.android.synthetic.main.vendas_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class VendasFragment : Fragment() {

    private val _viewModel: VendasViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.vendas_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupUi()
        subscribeUi()
    }

    private fun setupUi() {
        edtValor.addTextChangedListener(MoneyTextWatcher(edtValor))
        btnPagar.setOnClickListener {
            chamarMercadoPago()
        }
    }

    private fun subscribeUi() {
        _viewModel.formasDePagamento.observe(viewLifecycleOwner, { formasDePagamento ->
            context?.let {
                val spinnerAdapter = ArrayAdapter(
                    it,
                    android.R.layout.simple_spinner_dropdown_item,
                    formasDePagamento
                )
                spnTipo.adapter = spinnerAdapter
            }
        })
        _viewModel.parcelas.observe(viewLifecycleOwner, { parcelas ->
            context?.let {
                val spinnerAdapter = ArrayAdapter(
                    it,
                    android.R.layout.simple_spinner_dropdown_item,
                    parcelas
                )
                spnParcelas.adapter = spinnerAdapter
            }
        })
    }

    private fun chamarMercadoPago() {
        lateinit var cc_selected: String

        val i = Intent()

        i.action = "com.mercadopago.PAYMENT_ACTION"

        val bundle = Bundle()

// AppId

// AppId
        bundle.putString(BundleCodes.APP_ID, "6856782684038884")

// Secret

// Secret
        bundle.putString(BundleCodes.APP_SECRET, "yAufoEwGCBEWCNTmlXmfavQz6lw2Ka7D")

// App Fee

// App Fee
        bundle.putDouble(BundleCodes.APP_FEE, 1.0)

// Amount of transaction

// Amount of transaction
        bundle.putDouble(
            BundleCodes.AMOUNT,
            java.lang.Double.valueOf(
                MoneyTextWatcher.formatarValorVindoDoTextWatcher(
                    (edtValor.getText().toString())
                )
            )
        )

// Description of transaction

// Description of transaction
        bundle.putString(BundleCodes.DESCRIPTION, "Teste")

        if (spnTipo.getSelectedItemPosition() === 1) {
            cc_selected = "credit_card"
        } else {
            cc_selected = "debit_card"
        }

// Payment type of transaction ( credit_card | debit_card  )

// Payment type of transaction ( credit_card | debit_card  )
        bundle.putString(BundleCodes.CARD_TYPE, cc_selected)
        if (cc_selected == "credit_card") {
            val parcelas = Integer.valueOf(spnParcelas.selectedItem.toString())
            bundle.putLong(BundleCodes.INSTALLMENTS, parcelas.toLong())
        }


// Kiosk Mode

// Kiosk Mode
        bundle.putBoolean(BundleCodes.IS_KIOSK, true)

        i.putExtras(bundle);
        startActivityForResult(i, 141415);
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 141415 && data != null) {
            val resultadoPagamento = PaymentResult(
                data.getStringExtra(BundleCodes.RESULT_STATUS).toString(),
                data.getLongExtra(BundleCodes.PAYMENT_ID, 0),
                data.getIntExtra(BundleCodes.INSTALLMENTS, 0),
                data.getDoubleExtra(BundleCodes.AMOUNT, 0.0),
                data.getStringExtra(BundleCodes.CARD_TYPE).toString()
            )
            _viewModel.setResultadoPagamento(resultadoPagamento)
            if (resultadoPagamento.status == "OK") {
                SweetAlertDialog(requireContext(), SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Pagamento efetuado!")
                    .show();
            } else {
                SweetAlertDialog(requireContext(), SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("Erro no pagamento!")
                    .setContentText("Status: " + resultadoPagamento.status)
                    .show();
            }
        }
    }


}