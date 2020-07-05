package com.tory.study.database


import androidx.room.*
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface UserInfoDao {
    @Query("SELECT * FROM FriendInfo")
    fun getAll(): Maybe<List<UserInfo>>
    @Query("SELECT * FROM FriendInfo WHERE owner_id = :owner")
    fun getAllByOwner(owner: String): List<UserInfo>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(userInfo: UserInfo): Long
    @Update
    fun update(userInfo: UserInfo): Int
    @Delete
    fun delete(userInfo: UserInfo): Int
}