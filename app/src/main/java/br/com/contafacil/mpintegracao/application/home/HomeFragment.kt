package br.com.contafacil.mpintegracao.application.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.contafacil.mpintegracao.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val _viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }


}