package edu.academik.websocket.mobile

import android.util.Log
import tech.gusavila92.websocketclient.WebSocketClient
import java.lang.Exception
import java.net.URI


class MyWebSocketClient : WebSocketClient{

    var textReceivedAction : (message : String) ->  Unit = {}

    constructor( uri : URI) : super(uri) {

    }

    override fun onOpen() {
        Log.i("WebSocket", "Sesión ha empezado")
    }

    override fun onTextReceived(message: String?) {
        Log.i("WebSocket", "Recibido:   $message")

        message?.let { textReceivedAction.invoke(it)}

    }

    override fun onPongReceived(data: ByteArray?) {

    }

    override fun onException(ex: Exception?) {
        Log.e(this.javaClass.name, ex?.message, ex)
    }

    override fun onCloseReceived() {

    }

    override fun onBinaryReceived(data: ByteArray?) {

    }

    override fun onPingReceived(data: ByteArray?) {

    }
}