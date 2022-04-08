package eu.malek.alliants.interview

import android.app.Application
import eu.malek.setDefaultErrorHandler

class App : Application() {

    lateinit var appModule: AppModule

    override fun onCreate() {
        super.onCreate()

        setDefaultErrorHandler(this, BuildConfig.DEBUG)

        appModule = AppModule()
    }

}
