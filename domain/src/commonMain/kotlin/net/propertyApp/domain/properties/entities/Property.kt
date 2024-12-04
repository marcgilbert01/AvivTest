package net.propertyApp.domain.properties.entities

data class Property (
    val bedrooms: Int? = null,
    val city: String,
    val id: Int,
    val area: Double,
    val url: String? = null,
    val price: Double,
    val professional: String,
    val type: String,
    val offerType: Int,
    val rooms: Int? = null
)