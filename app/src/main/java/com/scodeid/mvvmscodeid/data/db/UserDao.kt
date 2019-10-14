package com.scodeid.mvvmscodeid.data.db
//[7]
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.scodeid.mvvmscodeid.data.db.entities.CURRENT_USER_ID
import com.scodeid.mvvmscodeid.data.db.entities.User

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

@Dao
interface UserDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(user: User) : Long

    @Query("SELECT * FROM user WHERE uid = $CURRENT_USER_ID")
    fun getUser() : LiveData<User>
}