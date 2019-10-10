package com.scodeid.mvvmscodeid.data.db.entities
// [6]
import androidx.room.Entity
import androidx.room.PrimaryKey

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
const val CURRENT_USER_ID = 0

@Entity
data class User(
    var id : Int? = null,
    var name: String? = null,
    var email: String? = null,
    var password: String? = null,
    var email_verified_at: String? = null,
    var created_at: String? = null,
    var updated_at: String? = null
) {
    @PrimaryKey(autoGenerate = false )
    var uid: Int = CURRENT_USER_ID
}