package com.tory.study.database;

import androidx.room.ColumnInfo;

public class UserBaseInfo {
    @ColumnInfo(name = "user_desc")
    private String userDesc;

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }
}
