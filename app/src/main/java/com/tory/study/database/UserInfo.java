package com.tory.study.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "FriendInfo", primaryKeys = {"owner_id", "user_id"})
public class UserInfo {
    @ColumnInfo(name = "owner_id")
    @NotNull
    private String ownerId;
    @ColumnInfo(name = "user_id")
    @NotNull
    private String userId;
    @ColumnInfo(name = "user_gender")
    private String userGender;
    @ColumnInfo(name = "user_avatar")
    private String userAvatar;
    @ColumnInfo(name = "user_phone")
    private String userPhone;
    @ColumnInfo(name = "user_address")
    private String userAddress;

    public UserInfo(@NotNull String ownerId, @NotNull String userId, String userGender, String userAvatar, String userPhone, String userAddress) {
        this.ownerId = ownerId;
        this.userId = userId;
        this.userGender = userGender;
        this.userAvatar = userAvatar;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
    }

    @NotNull
    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(@NotNull String ownerId) {
        this.ownerId = ownerId;
    }

    @NotNull
    public String getUserId() {
        return userId;
    }

    public void setUserId(@NotNull String userId) {
        this.userId = userId;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}
