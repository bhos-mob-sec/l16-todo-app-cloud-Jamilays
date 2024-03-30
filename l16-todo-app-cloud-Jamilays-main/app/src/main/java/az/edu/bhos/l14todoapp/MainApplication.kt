package az.edu.bhos.l14todoapp

import android.app.Application
import az.edu.bhos.l14todoapp.di.androidModule
import org.koin.core.context.GlobalContext.startKoin

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(androidModule)
        }
    }
}