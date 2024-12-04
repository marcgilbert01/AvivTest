package net.propertyApp.data.properties

import net.propertyApp.data.dataSources.PropertiesDataSource
import net.propertyApp.domain.properties.entities.Property
import net.propertyApp.domain.properties.repo.PropertiesRepo

class PropertiesRepoImpl(
    private val propertiesDataSource: PropertiesDataSource
) : PropertiesRepo {


    override suspend fun getProperties(): List<Property> {
        return propertiesDataSource.getProperties()
    }

    override suspend fun getPropertyById(id: String): Property? {
        return propertiesDataSource.getPropertyById(id)
    }

}