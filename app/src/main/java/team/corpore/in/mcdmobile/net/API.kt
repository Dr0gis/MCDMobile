package team.corpore.`in`.mcdmobile.net

import retrofit2.Call
import retrofit2.http.*
import team.corpore.`in`.mcdmobile.net.model.AuthorizationModelRequest
import team.corpore.`in`.mcdmobile.net.model.UserInfoModelResponse

interface API {

    @POST("/Authorization")
    fun authorization(@Body model: AuthorizationModelRequest): Call<String>

    @GET("/UserInfo")
    fun userInfo(@Query("token") token: String): Call<UserInfoModelResponse>

}