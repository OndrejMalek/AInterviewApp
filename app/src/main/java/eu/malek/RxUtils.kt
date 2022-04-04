package eu.malek

import android.app.Application
import android.util.Log
import android.widget.Toast
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.plugins.RxJavaPlugins

fun setDefaultErrorHandler(context: Application?) {
    RxJavaPlugins.setErrorHandler { throwable: Throwable ->
        Log.e("Rx_default_error", "Rx default error handler", throwable)
        throwable.printStackTrace()
        toastOnMainThread(context, throwable)
    }
}


fun toastOnMainThread(context: Application?, throwable: Throwable) {
    val dis = Observable.just(1)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            { integer: Int? ->
                Toast.makeText(
                    context,
                    "Error: " + throwable.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        ) { throwable1: Throwable ->
            //Log.e(RxUtils.class.getSimpleName(), "toastOnMainThread: failed");
            throwable1.printStackTrace()
        }
}