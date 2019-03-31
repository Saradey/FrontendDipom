package com.evgeny.goncharov.graduationproject.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import com.evgeny.goncharov.graduationproject.R
import com.evgeny.goncharov.graduationproject.consts.START_FRAGMENT_ENTRY
import com.evgeny.goncharov.graduationproject.ui.activity.MainActivity
import com.evgeny.goncharov.graduationproject.ui.activity.Router
import javax.inject.Inject


/**
 * Created by Evgeny Goncharov on 2019-03-31.
 * jtgn@yandex.ru
 */


class AskLogoutDialog : DialogFragment() {

    @Inject
    lateinit var router: Router


    init {
        MainActivity.appComponent.inject(this)
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        builder.setTitle(R.string.logout_title_str)
            .setMessage(R.string.logout_text_str)
            .setPositiveButton(R.string.ask_exit_yes) { _, _ ->
                router.exit()
            }.setNegativeButton(R.string.ask_exit_no) { _, _ ->

            }

        return builder.create()
    }


}