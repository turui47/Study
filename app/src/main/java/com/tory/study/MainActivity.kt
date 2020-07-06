package com.tory.study

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tory.study.database.AppDatabase
import com.tory.study.database.UserInfo
import io.reactivex.MaybeObserver
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Callable

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userInfo1 = UserInfo("大姐大" + AppDatabase.DB_NAME,"女",
            "狗屁","1","黄泥磅");
        val userInfo2 = UserInfo("王艺" + AppDatabase.DB_NAME,"女",
            "屁沟","2","巴南");
        userInfo1.userDesc = "蒲霭丽"
        userInfo2.userDesc = "豪宅，减肥成功了"
        Single.fromCallable{AppDatabase.getAppDatabase(baseContext).userInfoDao().save(userInfo1) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {},
                onError = {}
            )
        Single.fromCallable {AppDatabase.getAppDatabase(baseContext).userInfoDao().save(userInfo2) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {},
                onError = {}
            )
        //这里查询、更新操作同步进行的，所以其实要用Flowable/Observable来~
        AppDatabase.getAppDatabase(baseContext).userInfoDao().getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : MaybeObserver<List<UserInfo>>{
                override fun onSuccess(t: List<UserInfo>) {
                    t.run {

                    }
                }

                override fun onComplete() {
                    var s = "s";
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {
                }
            })
    }
}
