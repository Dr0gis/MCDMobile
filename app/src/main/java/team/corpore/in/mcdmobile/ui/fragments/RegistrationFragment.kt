package team.corpore.`in`.mcdmobile.ui.fragments

import android.support.constraint.ConstraintLayout
import kotlinx.android.synthetic.main.fragment_registration.*
import team.corpore.`in`.mcdmobile.R

class RegistrationFragment : LoginRegistrationFragment() {

    override fun getViewId(): Int = R.layout.fragment_registration

    override fun init() {
        registrationACB.setOnClickListener {
            //TODO: request to server
        }
    }

    override fun contentToTop() {
        val layoutParams = registrationLL.layoutParams as ConstraintLayout.LayoutParams
        layoutParams.verticalBias = 0.1F
        registrationLL.layoutParams = layoutParams
    }

    override fun contentToCenter() {
        val layoutParams = registrationLL.layoutParams as ConstraintLayout.LayoutParams
        layoutParams.verticalBias = 0.5F
        registrationLL.layoutParams = layoutParams
    }
}