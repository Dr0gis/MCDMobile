package team.corpore.`in`.mcdmobile.ui.activites

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.*
import team.corpore.`in`.mcdmobile.R
import team.corpore.`in`.mcdmobile.ui.adapters.UsedDronesRecyclerAdapter
import team.corpore.`in`.mcdmobile.ui.fragments.MainFragment
import team.corpore.`in`.mcdmobile.ui.fragments.ProfileFragment
import team.corpore.`in`.mcdmobile.utils.SharedUtils

class MainActivity : BaseActivity() {
    companion object {
        fun openActivity(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getViewId(): Int? = R.layout.activity_main

    override fun init() {
        openMainFragment()

        logoutTV.setOnClickListener {
            logout()
        }
        mainTV.setOnClickListener {
            openMainFragment()
        }
        profileTV.setOnClickListener {
            openProfileFragment()
        }
    }

    private fun logout() {
        LoginRegistrationActivity.openActivity(this)
        finish()
    }

    private fun openMainFragment() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerFL, MainFragment(), MainFragment::class.java.simpleName)
                .commit()
        logoutTV.isSelected = false
        mainTV.isSelected = true
        profileTV.isSelected = false
        mainTV.typeface = Typeface.DEFAULT_BOLD

        profileTV.typeface = Typeface.DEFAULT
    }

    private fun openProfileFragment() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.containerFL, ProfileFragment(), ProfileFragment::class.java.simpleName)
                .commit()
        logoutTV.isSelected = false
        mainTV.isSelected = false
        profileTV.isSelected = true
        mainTV.typeface = Typeface.DEFAULT
        profileTV.typeface = Typeface.DEFAULT_BOLD
    }

    override fun onOpenKeyboard() {

    }

    override fun onHideKeyboard() {

    }

    override fun onBackPressed() {

    }
}
