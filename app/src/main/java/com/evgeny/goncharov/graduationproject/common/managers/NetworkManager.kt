package com.evgeny.goncharov.graduationproject.common.managers

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log
import com.evgeny.goncharov.graduationproject.consts.BASE_URL
import com.evgeny.goncharov.graduationproject.consts.LOG_REST_MANAGER
import io.reactivex.Observable
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Callable

class NetworkManager(private val context: Context) {

    private fun isOnline(): Boolean {
        val cm: ConnectivityManager? =
            context.getSystemService(Context.CONNECTIVITY_SERVICE)
                    as ConnectivityManager
        val networkInfo: NetworkInfo? = cm!!.activeNetworkInfo
        var isOn = false
        networkInfo?.let {
            isOn = networkInfo.isConnected
        }
        return isOn
    }


    private fun isOnlineBackEnd(): Callable<Boolean> {
        return object : Callable<Boolean> {
            override fun call(): Boolean {
                if (!isOnline()) {
                    return false
                }
                return true
            }
        }
    }


    fun getNetworkStatus(): Observable<Boolean> {
        return Observable.fromCallable(isOnlineBackEnd())
    }


}