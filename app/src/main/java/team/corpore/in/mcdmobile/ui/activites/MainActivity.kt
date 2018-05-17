package team.corpore.`in`.mcdmobile.ui.activites

import android.content.Context
import android.content.Intent
import team.corpore.`in`.mcdmobile.R

class MainActivity : BaseActivity() {
    companion object {
        fun openActivity(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getViewId(): Int? = R.layout.activity_main

    override fun init() {

    }

    override fun onOpenKeyboard() {

    }

    override fun onHideKeyboard() {

    }
}
