package team.corpore.`in`.mcdmobile.ui.fragments

import android.support.constraint.ConstraintLayout
import kotlinx.android.synthetic.main.fragment_login.*
import team.corpore.`in`.mcdmobile.R
import team.corpore.`in`.mcdmobile.ui.activites.MainActivity

class LoginFragment : LoginRegistrationFragment() {

    override fun getViewId(): Int = R.layout.fragment_login

    override fun init() {
        loginACB.setOnClickListener {
            MainActivity.openActivity(context!!)
        }
    }

    override fun contentToTop() {
        val layoutParams = loginLL.layoutParams as ConstraintLayout.LayoutParams
        layoutParams.verticalBias = 0.1F
        loginLL.layoutParams = layoutParams
    }

    override fun contentToCenter() {
        val layoutParams = loginLL.layoutParams as ConstraintLayout.LayoutParams
        layoutParams.verticalBias = 0.5F
        loginLL.layoutParams = layoutParams
    }
}