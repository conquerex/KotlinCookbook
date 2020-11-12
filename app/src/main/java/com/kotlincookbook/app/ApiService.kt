package com.kotlincookbook.app

import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by jongkook on 2020.11.12
 */
interface ApiService {
    @GET("get")
    fun getHttpBin() : Observable<HttpBinResponse>
}