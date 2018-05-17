package team.corpore.`in`.mcdmobile.ui.adapters

import android.os.Parcel
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import team.corpore.`in`.mcdmobile.ui.fragments.LoginFragment
import team.corpore.`in`.mcdmobile.ui.fragments.LoginRegistrationFragment
import team.corpore.`in`.mcdmobile.ui.fragments.RegistrationFragment

class LoginRegistrationPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val fragments = ArrayList<LoginRegistrationFragment>()

    init {
        fragments.add(LoginFragment())
        fragments.add(RegistrationFragment())
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    fun contentToTop() {
        for (fragment in fragments) {
            fragment.contentToTop()
        }
    }

    fun contentToCenter() {
        for (fragment in fragments) {
            fragment.contentToCenter()
        }
    }
}