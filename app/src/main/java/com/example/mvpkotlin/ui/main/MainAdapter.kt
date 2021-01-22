package com.example.mvpkotlin.ui.main

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvpkotlin.R
import com.example.mvpkotlin.data.User
import com.example.mvpkotlin.data.Users
import kotlinx.android.synthetic.main.adapter_user_item.view.*
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainAdapter(val ctx: Context) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    /**
     *  条目点击接口
     */
    interface OnItemClickListener {
        fun onItemClick(user: User)
    }

    //ArrayList()
    private val data: ArrayList<User> = arrayListOf()

    var onItemClick: OnItemClickListener? = null
        set(value) {
            field = value
        }

    override fun getItemCount(): Int = data.size

    /**
     *  更新数据 刷新视图
     */
    fun notifyDataSetChanged(users: List<User>) {
        data.clear()
        data.addAll(users)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = data[position]
        Glide.with(ctx)
            .load("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2619070134,4006736665&fm=26&gp=0.jpg")
            .error(R.mipmap.ic_launcher).into(holder?.user_avatar)
        holder.user_name.text = user.name
        holder.user_scope.text = "${user.score}"
        holder.user_home.text = user.html_url
        holder.itemView.onClick {
            onItemClick?.onItemClick(user)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(ctx).inflate(R.layout.adapter_user_item, parent, false)
        return ViewHolder(itemView)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val user_avatar: ImageView = itemView.find(R.id.user_avatar)
        val user_name: TextView = itemView.find(R.id.user_name)
        val user_scope: TextView = itemView.find(R.id.user_scope)
        val user_home: TextView = itemView.find(R.id.user_home)
    }


}