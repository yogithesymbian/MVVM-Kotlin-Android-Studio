package com.scodeid.mvvmscodeid.data.network

import com.scodeid.mvvmscodeid.util.ApiException
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response

/**
 * @author
 * Created by scode on 08,October,2019
 * Yogi Arif Widodo
 * www.dicoding.com/users/297307
 * www.github.com/yogithesymbian
 * SCODEID company,
 * Indonesia, East Borneo.
 * ==============================================================
Android Studio 3.4.2
Build #AI-183.6156.11.34.5692245, built on June 27, 2019
JRE: 1.8.0_152-release-1343-b16-5323222 amd64
JVM: OpenJDK 64-Bit Server VM by JetBrains s.r.o
Linux 5.2.0-kali2-amd64
 * ==============================================================
 */
// handle error request api | generic function
abstract class SafeApiRequest {
    // asynchronous function
    suspend fun<T: Any> apiRequest(call: suspend () -> Response<T>) : T{
        val response = call.invoke()
        if (response.isSuccessful){
            return response.body()!!
        } else {
            val error = response.errorBody()?.toString()
            val message = StringBuilder()
            // check api response
            error?.let {
                try {
                    message.append(JSONObject(it).getString("message"))
                } catch (e: JSONException) { }
                message.append("\n")
            }
            message.append("Error code: ${response.code()}")
            throw ApiException(message.toString())
        }
    }
}