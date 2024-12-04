package net.propertyApp.avivApi.services.properties

import io.ktor.client.call.body
import io.ktor.client.request.get
import net.propertyApp.avivApi.AVIV_API_BASE_URL
import net.propertyApp.avivApi.ktorHttpClient

class AvivPropertiesService(
    private val url: String = AVIV_API_BASE_URL
) {
    suspend fun getProperties(): AvivPropertyData {
        return ktorHttpClient.get("${url}/listings.json").body()
    }

    suspend fun getProperty(id: Int): PropertyDetails {
        return ktorHttpClient.get("${url}/listings/$id.json").body()
    }
}