package krasnikov.project.countryinfo.data.repository

import androidx.lifecycle.LiveData
import krasnikov.project.countryinfo.data.CountryDataSource
import krasnikov.project.countryinfo.data.model.Country

class CountryRepository(private val dataSource: CountryDataSource) : CountryDataSource {
    override fun getObserveCountries(): LiveData<List<Country>> {
        return dataSource.getObserveCountries()
    }

    companion object {
        private var instance: CountryRepository? = null

        @Synchronized
        fun getInstance(dataSource: CountryDataSource): CountryRepository {
            if (instance == null) {
                instance = CountryRepository(dataSource)
            }
            return instance!!
        }
    }
}