package edu.academik

import com.fasterxml.jackson.annotation.JsonProperty

class ResponseApi<T> {

    @JsonProperty("success")
    var success : Boolean = false

    @JsonProperty("message")
    var message : String? = null

    @JsonProperty("content")
    var content : T? = null
}