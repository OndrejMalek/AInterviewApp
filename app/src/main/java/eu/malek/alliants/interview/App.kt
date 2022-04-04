package eu.malek.alliants.interview

import android.app.Application
import eu.malek.alliants.interview.net.CmsApiRepo
import eu.malek.setDefaultErrorHandler

class App : Application() {

    lateinit var cmsApiRepo : CmsApiRepo

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG){
            setDefaultErrorHandler(this)
        }


        cmsApiRepo = CmsApiRepo()
    }

}
