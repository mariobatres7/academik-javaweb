package edu.academik

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RetrofitService.init()

        val mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        mainViewModel.findProductsState.observe(this, Observer {

            when (it){
                is ResultService.Success -> {
                    showMessage("Información de productos obtenida satisfactoriamente")
                    process(it.data)
                }
                is ResultService.Error -> {
                    it.exception.message?.let { message -> showMessage("Error:  $message") }
                }
                is ResultService.Init -> {
                    showMessage("Iniciando carga de datos")
                }
            }
        })

        mainViewModel.findProducts()
    }

    private fun showMessage(message : String ) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun process(productList : List<Product>? ) {
        this.listView.adapter =  ProductArrayAdapter(this, productList!!)

    }

}



class ProductArrayAdapter (context: Context,  values: List<Product>)
    : ArrayAdapter<Product>(context, 0, values){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(this.context).inflate(R.layout.item_product, null)

        this.getItem(position)?.let {
            view.findViewById<AppCompatTextView>(R.id.productIdTextView).text = it.productId.toString()
            view.findViewById<AppCompatTextView>(R.id.codeTextView).text = it.code
            view.findViewById<AppCompatTextView>(R.id.descriptionTextView).text = it.description
        }
        return view

    }
}