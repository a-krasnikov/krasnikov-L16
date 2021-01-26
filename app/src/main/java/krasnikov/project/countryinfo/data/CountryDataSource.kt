package krasnikov.project.countryinfo.data

import androidx.lifecycle.LiveData
import krasnikov.project.countryinfo.data.model.Country

interface CountryDataSource {

    fun getObserveCountries(): LiveData<List<Country>>
}