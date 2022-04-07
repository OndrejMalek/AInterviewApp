package eu.malek

import android.app.Application
import android.util.Log
import android.widget.Toast
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.rxkotlin.subscribeBy

fun setDefaultErrorHandler(context: Application?, debug: Boolean) {
    RxJavaPlugins.setErrorHandler { throwable: Throwable ->
        Log.e("Rx_default_error", "Rx default error handler", throwable)
        throwable.printStackTrace()
        if (debug) {
            toastOnMainThread(context, throwable)
        }
    }
}


fun toastOnMainThread(context: Application?, throwable: Throwable) {
    val dis = Observable.just(1)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeBy(
            onNext = { integer: Int? ->
                Toast.makeText(
                    context,
                    "Error: " + throwable.message,
                    Toast.LENGTH_SHORT
                ).show()
            },
            onError = { throwable1: Throwable ->
                throwable1.printStackTrace()
            }

        )
}