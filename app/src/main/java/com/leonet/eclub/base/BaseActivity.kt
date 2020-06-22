package com.leonet.eclub.base

import android.os.Bundle
import android.os.PersistableBundle
import dagger.android.support.DaggerAppCompatActivity
import android.content.Intent



abstract class BaseActivity: DaggerAppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

    }

    override fun finish() {
        super.finish()
        overridePendingTransitionExit()
    }

    override fun startActivity(intent: Intent) {
        super.startActivity(intent)
        overridePendingTransitionEnter()
    }

    override fun startActivityForResult(intent: Intent?, requestCode: Int, options: Bundle?) {
        super.startActivityForResult(intent, requestCode, options)
        overridePendingTransitionEnter()
    }

    private fun overridePendingTransitionEnter() {
        //overridePendingTransition(com.leonet.eclub.R.anim.slide_from_right, com.leonet.eclub.R.anim.slide_to_left)
    }

    /**
     * Overrides the pending Activity transition by performing the "Exit" animation.
     */
    private fun overridePendingTransitionExit() {
        //overridePendingTransition(com.leonet.eclub.R.anim.slide_from_left, com.leonet.eclub.R.anim.slide_to_right)
    }
}