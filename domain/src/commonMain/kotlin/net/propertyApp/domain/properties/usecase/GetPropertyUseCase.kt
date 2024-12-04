package net.propertyApp.domain.properties.usecase

import net.propertyApp.domain.properties.entities.Property
import net.propertyApp.domain.properties.repo.PropertiesRepo

class GetPropertyUseCase(
    private val propertiesRepo: PropertiesRepo
) {

    suspend operator fun invoke(propertyId: String): Property? {
        return propertiesRepo.getPropertyById(propertyId)
    }
}