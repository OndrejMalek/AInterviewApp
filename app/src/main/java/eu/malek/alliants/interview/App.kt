package eu.malek.alliants.interview

import android.app.Application
import eu.malek.alliants.interview.net.CmsApiRepo
import eu.malek.setDefaultErrorHandler

class App : Application() {

    lateinit var appModule: AppModule

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG){
            setDefaultErrorHandler(this)
        }

        appModule = AppModule()
    }

    class AppModule{
        var cmsApiRepo : CmsApiRepo = CmsApiRepo()
    }
}
