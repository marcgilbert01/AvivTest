package net.propertyApp.data.dataSources

import net.propertyApp.domain.properties.entities.Property

interface PropertiesDataSource {
    suspend fun getProperties(): List<Property>
    suspend fun getPropertyById(id: String): Property?
}
