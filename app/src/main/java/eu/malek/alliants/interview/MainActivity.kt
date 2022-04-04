package eu.malek.alliants.interview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import eu.malek.alliants.interview.feat.main.VendorListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, VendorListFragment.newInstance())
                .commitNow()
        }
    }
}