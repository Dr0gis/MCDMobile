package team.corpore.`in`.mcdmobile.net

import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import team.corpore.`in`.mcdmobile.utils.SharedUtils

class RetrofitClient {
    companion object {
        private var retrofitClient: RetrofitClient? = null

        private fun init() {
            retrofitClient = RetrofitClient()
        }

        fun getInstance(): RetrofitClient {
            if (retrofitClient == null) {
                init()
            }
            return retrofitClient!!
        }

        fun newInstance() {
            init()
        }
    }

    init {
        setupClient()
    }

    private var service: API? = null

    private fun setupClient() {
        val restAdapter = Retrofit.Builder()
                .baseUrl(SharedUtils.getServerUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        service = restAdapter.create(API::class.java)
    }

    fun getService(): API {
        return service!!
    }
}