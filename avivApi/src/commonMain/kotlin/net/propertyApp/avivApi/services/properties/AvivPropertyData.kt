package net.propertyApp.avivApi.services.properties

import kotlinx.serialization.Serializable


// create data classes for the above json
@Serializable
data class AvivPropertyData(
    val items: List<PropertyItemData>,
    val totalCount: Int
)

@Serializable
data class PropertyItemData(
    val bedrooms: Int? = null,
    val city: String,
    val id: Int,
    val area: Double,
    val url: String? = null,
    val price: Double,
    val professional: String,
    val propertyType: String,
    val offerType: Int,
    val rooms: Int? = null
)

@Serializable
data class PropertyDetails (
    val city: String,
    val id: Int,
    val area: Double,
    val url: String,
    val price: Double,
    val professional: String,
    val offerType: Int,
    val propertyType: String
)
