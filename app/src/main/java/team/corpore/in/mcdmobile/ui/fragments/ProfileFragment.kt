package team.corpore.`in`.mcdmobile.ui.fragments

import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_profile.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import team.corpore.`in`.mcdmobile.R
import team.corpore.`in`.mcdmobile.net.RetrofitClient
import team.corpore.`in`.mcdmobile.net.model.UserInfoModelResponse
import team.corpore.`in`.mcdmobile.utils.SharedUtils

class ProfileFragment : MainBaseFragment() {

    override fun getViewId(): Int = R.layout.fragment_profile

    override fun init() {
        RetrofitClient.getInstance().getService().userInfo(SharedUtils.getToken()).enqueue(object: Callback<UserInfoModelResponse> {
            override fun onFailure(call: Call<UserInfoModelResponse>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
            }
            override fun onResponse(call: Call<UserInfoModelResponse>, response: Response<UserInfoModelResponse>) {
                if (response.isSuccessful) {
                    setData(response.body()!!.email, response.body()!!.name, response.body()!!.surname)
                }
                else {
                    Toast.makeText(context, response.message() + " | " + response.errorBody()!!.string() + " | ", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    fun setData(email: String, name: String, surname: String) {
        emailValueTV.text = email
        nameValueTV.text = name
        surnameValueTV.text = surname
    }
}