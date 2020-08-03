package edu.academik.websocket.mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import tech.gusavila92.websocketclient.WebSocketClient

import java.net.URI

class MainActivity : AppCompatActivity() {

    private lateinit var  mainViewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.message.observe(this, Observer {
            messageTextView.text = it
        })
    }

    override fun onStart() {
        super.onStart()

        this.mainViewModel.conectar()

    }
    override fun onDestroy() {
        super.onDestroy()

        this.mainViewModel.close()

    }
}