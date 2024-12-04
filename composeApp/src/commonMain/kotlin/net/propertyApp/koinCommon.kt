package net.propertyApp

import net.propertyApp.avivApi.services.properties.AvivPropertiesService
import net.propertyApp.data.properties.PropertiesRepoImpl
import net.propertyApp.data.dataSources.PropertiesDataSource
import net.propertyApp.data.dataSources.PropertiesDataSourceFromAvivApi
import net.propertyApp.domain.properties.repo.PropertiesRepo
import net.propertyApp.domain.properties.usecase.GetPropertyUseCase
import net.propertyApp.domain.properties.usecase.GetAllPropertiesUseCase
import net.propertyApp.ui.propertyDetail.PropertyDetailViewModel
import net.propertyApp.ui.properties.PropertiesViewModel
import org.koin.dsl.module

val koinCommon = module {

    //////////////////////////////////////////////////////////////////
    // view models
    factory {
        PropertiesViewModel(get())
    }

    factory {
        PropertyDetailViewModel(get())
    }


    //////////////////////////////////////////////////////////////////
    // use cases
    factory {
        GetAllPropertiesUseCase(get())
    }
    factory {
        GetPropertyUseCase(get())
    }

    //////////////////////////////////////////////////////////////////
    // repo
    single<PropertiesRepo> {
        PropertiesRepoImpl(get())
    }

    //////////////////////////////////////////////////////////////////
    // data sources
    single<PropertiesDataSource> {
        PropertiesDataSourceFromAvivApi(get())
    }

    //////////////////////////////////////////////////////////////////
    // services
    single {
        AvivPropertiesService()
    }

}