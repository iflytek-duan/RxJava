package com.zihao.rxjava;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

@SuppressLint("CheckResult")
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private Disposable mDisposableInterval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        // just本身是一个简单的发射器，用于一次调用onNext()方法
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
        // time计时器
//        Observable.timer(2, TimeUnit.SECONDS)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())// timer 默认在新线程，所以需要切换回主线程
//                .subscribe(new Consumer<Long>() {
//                    @Override
//                    public void accept(Long aLong) throws Exception {
//                        Log.e(TAG, "timer :" + aLong + " at " + System.currentTimeMillis());
//                    }
//                });

        // interval间隔任务
//        if (mDisposableInterval != null && !mDisposableInterval.isDisposed()) {
//            mDisposableInterval.dispose();
//            mDisposableInterval = null;
//        } else {
//            mDisposableInterval = Observable.interval(0, 2, TimeUnit.SECONDS)
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(new Consumer<Long>() {
//                        @Override
//                        public void accept(Long aLong) throws Exception {
//                            Log.e(TAG, "timer :" + aLong + " at " + System.currentTimeMillis());
//                        }
//                    });
//        }

        // doOnNext在订阅者接收到数据前做点事儿
//        Observable.just(1, 2, 3, 4, 5)
//                .doOnNext(new Consumer<Integer>() {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//                        Log.e(TAG, "保存 :" + integer);
//                    }
//                }).subscribe(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) throws Exception {
//                Log.e(TAG, "accept :" + integer);
//            }
//        });

        // skip跳过操作
//        Observable.just(1, 2, 2, 4, 5, 3)
//                .skip(2)
//                .subscribe(new Consumer<Integer>() {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//                        Log.e(TAG, "skip,accept :" + integer);
//                    }
//                });

        // take接受操作，接受一个 long 型参数 count ，代表至多接收 count 个数据。
        Observable.just(1, 2, 3, 4, 5)
                .take(3)
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(TAG, "take,accept :" + integer);
                    }
                });
    }
}
