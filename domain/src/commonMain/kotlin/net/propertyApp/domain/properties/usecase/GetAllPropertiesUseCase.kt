package net.propertyApp.domain.properties.usecase

import net.propertyApp.domain.properties.entities.Property
import net.propertyApp.domain.properties.repo.PropertiesRepo

class GetAllPropertiesUseCase(
    private val propertiesRepo: PropertiesRepo
) {

    suspend operator fun invoke(): List<Property> {
        return propertiesRepo.getProperties()
    }
}