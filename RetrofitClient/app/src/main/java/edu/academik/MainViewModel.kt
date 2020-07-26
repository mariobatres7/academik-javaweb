package edu.academik

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel  : ViewModel() {

    private val productService = RetrofitService.createService(ProductService::class.java)

    private var _findProductsState = MutableLiveData<ResultService<List<Product>>>()
    val findProductsState : LiveData<ResultService<List<Product>>> = _findProductsState


    fun findProducts() {

        var args : String? = null

        args?.let { a -> println(a) }

        val disposables = CompositeDisposable()

        disposables.add(this.productService.findProducts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {this._findProductsState.value = ResultService.Init()}
            .subscribe(
                {result -> this._findProductsState.value = ResultService.processResponseApi(result)},
                {throwable -> this._findProductsState.value =  ResultService.Error(throwable)}
            )
        )
    }

}