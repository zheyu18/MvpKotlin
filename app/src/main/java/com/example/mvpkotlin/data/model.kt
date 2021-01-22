package com.example.mvpkotlin.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

const val BASE_URL = "http://api.github.com/"

data class Repo(
    @SerializedName("full_name") var name: String,
    var description: String,
    @SerializedName("stargazers_count") var stargazers: Int
)

data class Users(var items: List<User>)

data class User(
    @SerializedName("login") var name: String, var avatar_url: String,
    var html_url: String, var score: Double, var repos_url: String
) : Parcelable {

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<User> = object : Parcelable.Creator<User> {
            override fun newArray(size: Int): Array<User?> {
                return arrayOfNulls<User>(size)
            }

            override fun createFromParcel(source: Parcel): User {
                val name = source.readString()
                val avatar_url = source.readString()
                val html_url = source.readString()
                val score = source.readDouble()
                val repos_url = source.readString()
                return User(name.toString(), avatar_url.toString(), html_url.toString(), score, repos_url.toString())
            }

        }

    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(name)
        dest?.writeString(avatar_url)
        dest?.writeString(html_url)
        dest?.writeDouble(score)
        dest?.writeString(repos_url)
    }

    override fun describeContents(): Int = 0
}