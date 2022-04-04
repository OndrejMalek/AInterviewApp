package eu.malek.alliants.interview.net

import eu.malek.alliants.interview.BuildConfig
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CmsApi {

    companion object{
        const val BASE_URL = "https://nobu.cms.alliants.app/"

        fun createService(
        ): CmsApi {
            val retrofit = Retrofit.Builder().client(createHttpClient())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
            return retrofit.create(CmsApi::class.java)
        }

        fun createHttpClient(
        ): OkHttpClient {
            return if (BuildConfig.DEBUG) {
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()
            } else OkHttpClient.Builder().build()
        }


    }


    @GET("vendors")
    fun getVendorList() : Observable<Response<Object>>

}
