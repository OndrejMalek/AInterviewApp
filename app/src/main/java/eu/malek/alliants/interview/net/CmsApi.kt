package eu.malek.alliants.interview.net

import com.google.gson.GsonBuilder
import eu.malek.alliants.interview.BuildConfig
import eu.malek.alliants.interview.net.data.Vendor
import eu.malek.gson.LocalTimeDeserializer
import eu.malek.gson.ZoneIdDeserializer
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.time.LocalTime
import java.time.ZoneId

interface CmsApi {

    companion object{
        const val BASE_URL = "https://nobu.cms.alliants.app/"

        fun createService(
        ): CmsApi {
            val retrofit = Retrofit.Builder().client(createHttpClient())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(createGson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
            return retrofit.create(CmsApi::class.java)
        }

        fun createGson() = GsonBuilder()
            .registerTypeAdapter(LocalTime::class.java, LocalTimeDeserializer())
            .registerTypeAdapter(ZoneId::class.java, ZoneIdDeserializer())
            .create()

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
    fun getVendorList() : Observable<Response<List<Vendor>>>

}
