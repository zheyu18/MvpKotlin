package com.example.mvpkotlin

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.indeterminateProgressDialog

abstract class BaseActivity : AppCompatActivity() {
    var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(attchLayoutId())
        setUpComponent(MyApplication.getApplication().getAppComponent())
        initViews()
    }

    /**
     *  初始化视图
     */
    abstract fun initViews()

    /**
     *  布局id
     */
    abstract fun attchLayoutId(): Int

    /**
     * 初始化注入器
     */
    abstract fun setUpComponent(appComponent: AppComponent)

    /**
     *  显示加载框
     */
    open fun startLoading() {
        if (null === progressDialog) {
            progressDialog = indeterminateProgressDialog("正在加载...")
        } else {
            progressDialog?.show()
        }
    }

    /**
     *  隐藏加载框
     */
    open fun stopLoading(){
        progressDialog?.dismiss()
    }

    override fun onDestroy() {
        super.onDestroy()
        stopLoading()
    }

}
