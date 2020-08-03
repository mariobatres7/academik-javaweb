package edu.academik.websocket.mobile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URI


class MainViewModel : ViewModel(){

    private var webSocketClient : MyWebSocketClient? = null


    private var _message = MutableLiveData<String>()
    val message : LiveData<String> = _message


    fun conectar(){

        this.webSocketClient =  MyWebSocketClient( URI("ws://192.168.43.171:8080/websocket/socket"))

        this.webSocketClient?.let { it.textReceivedAction = { me ->
            _message.postValue(me)
        } }

        this.webSocketClient?.let { it.connect()  }
    }

    fun close(){
        this.webSocketClient?.let { it.close() }


    }

}