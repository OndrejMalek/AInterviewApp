package eu.malek.alliants.interview.feat.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import eu.malek.alliants.interview.App
import eu.malek.alliants.interview.net.data.Vendor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class VendorListViewModel(application: Application) : AndroidViewModel(application) {

    val vendors: MutableLiveData<Response<List<Vendor>>> = MutableLiveData()

    private val compDis = CompositeDisposable()

    init {
        loadVendors()
    }

    private fun loadVendors() {
        getCmsApiRepo().getVendorList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { res ->
                vendors.value = res
            }.addTo(compDis)
    }

    override fun onCleared() {
        compDis.dispose()
    }

    private fun getCmsApiRepo() = this.getApplication<App>().cmsApiRepo


}