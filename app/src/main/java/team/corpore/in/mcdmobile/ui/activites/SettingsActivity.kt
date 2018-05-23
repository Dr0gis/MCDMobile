package team.corpore.`in`.mcdmobile.ui.activites

import android.content.Context
import android.content.Intent
import kotlinx.android.synthetic.main.activity_settings.*
import team.corpore.`in`.mcdmobile.R
import team.corpore.`in`.mcdmobile.utils.SharedUtils

class SettingsActivity : BaseActivity() {
    companion object {
        fun openActivity(context: Context) {
            val intent = Intent(context, SettingsActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getViewId(): Int? = R.layout.activity_settings

    override fun init() {
        urlET.setText(SharedUtils.getServerUrl())
    }

    override fun onOpenKeyboard() {

    }

    override fun onHideKeyboard() {

    }

    override fun finish() {
        super.finish()
        SharedUtils.changeServerUrl(urlET.text.toString())
    }
}