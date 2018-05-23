package team.corpore.`in`.mcdmobile.ui.fragments

import android.support.constraint.ConstraintLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import team.corpore.`in`.mcdmobile.R
import team.corpore.`in`.mcdmobile.net.RetrofitClient
import team.corpore.`in`.mcdmobile.net.model.AuthorizationModelRequest
import team.corpore.`in`.mcdmobile.ui.activites.MainActivity
import team.corpore.`in`.mcdmobile.utils.SharedUtils

class LoginFragment : LoginRegistrationFragment() {

    override fun getViewId(): Int = R.layout.fragment_login

    override fun init() {
        loginACB.setOnClickListener {
            val model = AuthorizationModelRequest(emailTIET.text.toString(), passwordTIET.text.toString())
            RetrofitClient.getInstance().getService().authorization(model).enqueue(object: Callback<String> {
                override fun onFailure(call: Call<String>, t: Throwable) {
                    Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
                }
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    if (response.isSuccessful) {
                        SharedUtils.setToken(response.body()!!)
                        openMainActivity()
                    }
                    else {
                        Toast.makeText(context, response.message() + " | " + response.errorBody()!!.string() + " | ", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
    }

    override fun contentToTop() {
        if (loginLL != null) {
            val layoutParams = loginLL.layoutParams as ConstraintLayout.LayoutParams
            layoutParams.verticalBias = 0.1F
            loginLL.layoutParams = layoutParams
        }
    }

    override fun contentToCenter() {
        if (loginLL != null) {
            val layoutParams = loginLL.layoutParams as ConstraintLayout.LayoutParams
            layoutParams.verticalBias = 0.5F
            loginLL.layoutParams = layoutParams
        }
    }

    fun openMainActivity() {
        MainActivity.openActivity(context!!)
        activity!!.finish()
    }
}