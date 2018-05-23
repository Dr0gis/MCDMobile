package team.corpore.`in`.mcdmobile.utils

import team.corpore.`in`.mcdmobile.net.RetrofitClient

class SharedUtils {
    companion object {
        private var serverUrl = "http://192.168.31.168:9000/"
        private var token = ""

        fun changeServerUrl(url: String) {
            serverUrl = url
            RetrofitClient.newInstance()
        }

        fun getServerUrl() = serverUrl

        fun setToken(token: String) {
            this.token = token
        }

        fun getToken() = token
    }
}