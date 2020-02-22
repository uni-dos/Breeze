package com.the3rdwheel.breeze.authentication.db
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.the3rdwheel.breeze.authentication.db.entity.Account

@Dao
interface AccountDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(account: Account)

    @Query("Update accounts Set auth_access_token =:accessToken Where userName =:userName")
    fun changeAccessToke(userName: String, accessToken: String)

    @Query("Select * From accounts Where userName =:userName")
    fun getUser(userName: String)

    @Query("Delete From accounts Where userName =:userName")
    fun deleteUser(userName: String)

    @Query("Delete From accounts")
    fun deleteAllUsers()

    @Query("Update accounts Set karma =:karma Where userName =:userName")
    fun updateAccountKarma(userName: String, karma: Int)
}