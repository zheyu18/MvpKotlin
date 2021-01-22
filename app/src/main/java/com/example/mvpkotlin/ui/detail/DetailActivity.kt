package com.example.mvpkotlin.ui.detail

import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.mvpkotlin.AppComponent
import com.example.mvpkotlin.BaseActivity
import com.example.mvpkotlin.R
import com.example.mvpkotlin.data.Repo
import com.example.mvpkotlin.data.User
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailActivity : BaseActivity(), DetailViews {

    @Inject
    lateinit var presenter: DetailPresenter

    @Inject
    lateinit var adapter: DetailAdapter

    override fun initViews() {
        val user = intent.getParcelableExtra<User>("user")
        Glide.with(this).load("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1705133864,230414792&fm=26&gp=0.jpg").error(R.mipmap.ic_launcher).into(detail_avatar)
        detail_name.text = user.name
        detailRecyclerView.layoutManager = LinearLayoutManager(this)
        detailRecyclerView.adapter = adapter
        presenter.getRepos(user.repos_url!!)
    }

    override fun attchLayoutId(): Int = R.layout.activity_detail

    override fun setUpComponent(appComponent: AppComponent) {
        DaggerDetailActivityComponent.builder().appComponent(appComponent)
            .detailActivityModule(DetailActivityModule(this)).build().inject(this)

    }

    override fun showRepo(repos: List<Repo>) {
        stopLoading()
        adapter.notifyDataSetChanged(repos)
    }


}