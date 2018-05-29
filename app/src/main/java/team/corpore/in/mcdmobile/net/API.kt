package team.corpore.`in`.mcdmobile.net

import retrofit2.Call
import retrofit2.http.*
import team.corpore.`in`.mcdmobile.net.model.*

interface API {

    @POST("/Authorization")
    fun authorization(@Body model: AuthorizationModelRequest): Call<String>

    @GET("/UserInfo")
    fun userInfo(@Query("token") token: String): Call<UserInfoModelResponse>

    @GET("/UsedDrones")
    fun getUsedDrones(@Query("token") token: String): Call<ArrayList<UsedDronesModelResponse>>

    @GET("/DroneMovements")
    fun getDroneMovements(@Query("token") token: String, @Query("idDroneActivation") idDroneActivation: Int): Call<ArrayList<DroneMovementModelResponse>>

    @POST("/ActivateDrone")
    fun activateDrone(@Body model: ActivateDroneRequest): Call<Void>
}