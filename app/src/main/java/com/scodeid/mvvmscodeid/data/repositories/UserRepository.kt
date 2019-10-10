package com.scodeid.mvvmscodeid.data.repositories
// [5]
import com.scodeid.mvvmscodeid.data.db.AppDatabase
import com.scodeid.mvvmscodeid.data.db.entities.User
import com.scodeid.mvvmscodeid.data.network.MyApi
import com.scodeid.mvvmscodeid.data.network.SafeApiRequest
import com.scodeid.mvvmscodeid.data.network.responses.AuthResponse

/**
 * @author
 * Created by scode on 04,October,2019
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

class UserRepository(
    private val api: MyApi,
    private val db : AppDatabase
) : SafeApiRequest() {

    suspend fun userLogin(email: String, password: String) : AuthResponse{
        return apiRequest {
            api.userLogin(email, password)
        }
    }
    // save user to local
    suspend fun saveUser(user: User) = db.getUserDao().upsert(user)
}