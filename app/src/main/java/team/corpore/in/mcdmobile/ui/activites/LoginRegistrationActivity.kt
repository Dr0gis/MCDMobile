package team.corpore.`in`.mcdmobile.ui.activites

import android.content.Context
import android.content.Intent
import android.support.constraint.ConstraintLayout
import android.view.View
import kotlinx.android.synthetic.main.activity_auth_reg.*
import team.corpore.`in`.mcdmobile.R
import team.corpore.`in`.mcdmobile.ui.adapters.LoginRegistrationPagerAdapter

class LoginRegistrationActivity : BaseActivity() {
    companion object {
        fun openActivity(context: Context) {
            val intent = Intent(context, LoginRegistrationActivity::class.java)
            context.startActivity(intent)
        }
    }

    val loginRegistrationPagerAdapter = LoginRegistrationPagerAdapter(supportFragmentManager)

    override fun getViewId(): Int? = R.layout.activity_auth_reg

    override fun init() {
        loginRegistrationVP.adapter = loginRegistrationPagerAdapter
        loginRegistrationCI.setViewPager(loginRegistrationVP)
    }

    override fun onOpenKeyboard() {
        loginRegistrationPagerAdapter.contentToTop()
        val layoutParams = loginRegistrationCI.layoutParams as ConstraintLayout.LayoutParams
        layoutParams.verticalBias = 0.58F
        loginRegistrationCI.layoutParams = layoutParams
        logoRL.visibility = View.INVISIBLE
    }

    override fun onHideKeyboard() {
        loginRegistrationPagerAdapter.contentToCenter()
        val layoutParams = loginRegistrationCI.layoutParams as ConstraintLayout.LayoutParams
        layoutParams.verticalBias = 0.9F
        loginRegistrationCI.layoutParams = layoutParams
        logoRL.visibility = View.VISIBLE
    }
}