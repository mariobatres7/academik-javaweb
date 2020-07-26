package edu.academik

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

class Product : Serializable {

    @JsonProperty("productoId")
    var productId: Long? = null

    @JsonProperty("codigo")
    var code: String? = null

    @JsonProperty("descripcion")
    var description: String? = null

}