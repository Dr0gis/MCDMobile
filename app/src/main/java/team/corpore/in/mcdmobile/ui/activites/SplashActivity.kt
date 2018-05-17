package team.corpore.`in`.mcdmobile.ui.activites

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        openInitialActivity()
    }

    private fun openInitialActivity() {
        LoginRegistrationActivity.openActivity(this)
        finish()
    }
}