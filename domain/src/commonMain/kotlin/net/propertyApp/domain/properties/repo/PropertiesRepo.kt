package net.propertyApp.domain.properties.repo

import net.propertyApp.domain.properties.entities.Property

interface PropertiesRepo {

    suspend fun getProperties(): List<Property>

    suspend fun getPropertyById(id: String): Property?
}