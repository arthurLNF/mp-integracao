package br.com.contafacil.mpintegracao.utils.mvvm

import android.app.Application
import br.com.contafacil.mpintegracao.utils.mvvm.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class ContaFacilAegea : Application() {
    override fun onCreate() {
        super.onCreate()
        // start Koin!
        startKoin {
            // declare used Android context
            androidContext(this@ContaFacilAegea)
            // declare modules
            modules(viewModelModule)
        }
    }
}