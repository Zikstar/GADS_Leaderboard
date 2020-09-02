package com.isaac.gadsleaderboard.data

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val gadsApi: GadsApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://gadsapi.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(GadsApiService::class.java)
    }


    val googleFormsApi: GoogleFormSubmitService by lazy {
        Retrofit.Builder()
            .baseUrl("https://docs.google.com/forms/d/e/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(GoogleFormSubmitService::class.java)
    }
}
