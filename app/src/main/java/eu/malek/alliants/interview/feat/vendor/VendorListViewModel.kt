package eu.malek.alliants.interview.feat.vendor

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import eu.malek.alliants.interview.App
import eu.malek.alliants.interview.net.data.vendor.Vendor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class VendorListViewModel(application: Application) : AndroidViewModel(application) {

    data class VendorListState(
        val isLoading: Boolean = true,
        val response: Response<List<Vendor>>? = null
    )

    val vendors: MutableLiveData<VendorListState> = MutableLiveData(VendorListState(true))

    private val compDis = CompositeDisposable()

    init {
        loadVendors()
    }

    private fun loadVendors() {
        //Todo Check network state
        appModule().cmsApiRepo.getVendorList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(onNext = { res ->
                vendors.value = VendorListState(false, res)
            }).addTo(compDis)
    }

    override fun onCleared() {
        compDis.dispose()
    }

    private fun appModule() = this.getApplication<App>().appModule
}