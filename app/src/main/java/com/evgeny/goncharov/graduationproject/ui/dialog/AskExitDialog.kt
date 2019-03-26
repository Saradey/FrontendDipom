package com.evgeny.goncharov.graduationproject.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import com.evgeny.goncharov.graduationproject.R

class AskExitDialog : DialogFragment() {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        builder.setTitle(R.string.ask_exit_title_str)
            .setMessage(R.string.ask_exit_str)
            .setPositiveButton(R.string.ask_exit_yes) { _, _ ->
                requireActivity().finish()
            }.setNegativeButton(R.string.ask_exit_no) { _, _ ->

            }

        return builder.create()
    }


}