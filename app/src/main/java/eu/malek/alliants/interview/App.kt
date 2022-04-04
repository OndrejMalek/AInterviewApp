package eu.malek.alliants.interview

import android.app.Application
import eu.malek.alliants.interview.net.CmsApiRepo

class App : Application() {

    lateinit var cmsApiRepo : CmsApiRepo

    override fun onCreate() {
        super.onCreate()

        cmsApiRepo = CmsApiRepo()
    }
}