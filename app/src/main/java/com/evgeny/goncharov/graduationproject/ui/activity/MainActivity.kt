package com.evgeny.goncharov.graduationproject.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.method.ScrollingMovementMethod
import com.evgeny.goncharov.graduationproject.R
import kotlinx.android.synthetic.main.fragment_article.*

class MainActivity : AppCompatActivity(), Router {


    companion object{

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_create_article)


        
    }




    override fun onBackPressed() {

    }




    override fun startOnScreen(key: Int) {

    }


}
