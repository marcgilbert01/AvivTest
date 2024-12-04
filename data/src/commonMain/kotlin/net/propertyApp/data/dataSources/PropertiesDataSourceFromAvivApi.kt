package net.propertyApp.data.dataSources

import net.propertyApp.avivApi.services.properties.AvivPropertiesService
import net.propertyApp.avivApi.services.properties.PropertyItemData
import net.propertyApp.domain.properties.entities.Property

class PropertiesDataSourceFromAvivApi(
    private val avivPropertiesService: AvivPropertiesService
): PropertiesDataSource {

    private val properties = mutableMapOf<String, Property>() // key is id

    override suspend fun getProperties(): List<Property> {
        return avivPropertiesService.getProperties().items.map {
            it.toDomain().also {
                properties[it.id.toString()] = it
            }
        }
    }

    override suspend fun getPropertyById(id: String): Property? {
        if (properties.isEmpty()) getProperties()
        return properties[id]
    }
}

fun PropertyItemData.toDomain() = Property(
    id = this.id,
    city = this.city,
    price = this.price,
    area = this.area,
    url = this.url,
    bedrooms = this.bedrooms,
    professional = this.professional,
    type = this.propertyType,
    offerType = this.offerType,
    rooms = this.rooms
)

