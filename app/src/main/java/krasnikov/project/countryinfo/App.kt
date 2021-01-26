package krasnikov.project.countryinfo

import android.app.Application
import krasnikov.project.countryinfo.data.model.Country
import krasnikov.project.countryinfo.data.remote.CountryRemoteDataSource
import krasnikov.project.countryinfo.data.remote.api.CountryService
import krasnikov.project.countryinfo.data.repository.CountryRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class App : Application() {

    private val countryService by lazy { CountryService.provideCountryService() }
    private val countryRemoteDataSource by lazy { CountryRemoteDataSource.getInstance(countryService) }
    val countryRepository by lazy { CountryRepository.getInstance(countryRemoteDataSource) }

}