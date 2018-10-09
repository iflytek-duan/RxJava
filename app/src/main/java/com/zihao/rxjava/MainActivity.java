package com.zihao.rxjava;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

@SuppressLint("CheckResult")
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

//        Observable.just(1, 4, 5, 3, 1, 4, 6, 5, 7)
//                .distinct()
//                .filter(new Predicate<Integer>() {
//                    @Override
//                    public boolean test(Integer integer) throws Exception {
//                        return integer > 3;
//                    }
//                })
//                .buffer(2)
//                .subscribe(new Consumer<List<Integer>>() {
//                    @Override
//                    public void accept(List<Integer> integers) throws Exception {
//                        Log.e(TAG, "buffer size : " + integers.size() + "\n");
//                        for (int integer :
//                                integers) {
//                            Log.e(TAG, "accept:" + integer);
//                        }
//                    }
//                });

    }

    private void initView() {
        findViewById(R.id.main_btn_hello).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Observable.timer(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())// timer 默认在新线程，所以需要切换回主线程
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.e(TAG, "timer :" + aLong + " at " + System.currentTimeMillis());
                    }
                });
    }
}
