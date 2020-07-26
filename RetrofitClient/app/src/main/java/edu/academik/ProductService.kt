package edu.academik

import io.reactivex.Observable
import retrofit2.http.GET

interface ProductService {

    @GET("productos/listado")
    fun findProducts() : Observable<ResponseApi<List<Product>>>
}