package com.evgeny.goncharov.graduationproject.common

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor


/**
 * Created by Evgeny Goncharov on 2019-03-29.
 * jtgn@yandex.ru
 */


internal class MainThreadExecutor : Executor {
    private val mHandler = Handler(Looper.getMainLooper())

    override fun execute(command: Runnable) {
        mHandler.post(command)
    }

}