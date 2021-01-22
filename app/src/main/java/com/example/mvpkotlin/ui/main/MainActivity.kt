package com.example.mvpkotlin.ui.main

import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.mvpkotlin.AppComponent
import com.example.mvpkotlin.BaseActivity
import com.example.mvpkotlin.R
import com.example.mvpkotlin.data.User
import com.example.mvpkotlin.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import javax.inject.Inject

class MainActivity : BaseActivity(), MainViews, MainAdapter.OnItemClickListener {
    // 需要注入的对象
    @Inject
    lateinit var persenter: MainPresenter

    @Inject
    lateinit var adapter: MainAdapter

    override fun attchLayoutId(): Int = R.layout.activity_main

    override fun initViews() {
        mainRecyclerView.layoutManager = LinearLayoutManager(this)
        mainRecyclerView.adapter = adapter
        adapter.onItemClick = this
        mainSearch.onClick {
            val key = mainEdit.text.toString()
            persenter.getUsers(key)
        }
    }

    override fun setUpComponent(appComponent: AppComponent) {
        DaggerMainActivityComponent
            .builder()
            .appComponent(appComponent)
            .mainActivityModule(MainActivityModule(this))
            .build()
            .inject(this)
    }

    override fun onItemClick(user: User) {
        startActivity(intentFor<DetailActivity>("user" to user))
    }

    override fun showUsers(user: List<User>) {
        stopLoading()
        adapter.notifyDataSetChanged(user)
    }

}
