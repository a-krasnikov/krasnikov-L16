package krasnikov.project.countryinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.google.android.material.tabs.TabLayoutMediator
import krasnikov.project.countryinfo.data.model.Country
import krasnikov.project.countryinfo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: CountriesViewModel by viewModels {
        CountriesViewModel.CountriesViewModelFactory((application as App).countryRepository)
    }

    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupViewPager()
        setupTabLayout()

        viewModel.observeCountries.observe(this, Observer<List<Country>> { countries ->
            viewPagerAdapter.submitList(countries.subList(0, 10))
        })
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupTabLayout() {
        TabLayoutMediator(binding.tabLayout, binding.vpCountry) { tab, position ->
            tab.text = viewPagerAdapter.getItemTabName(position)
        }.attach()
    }

    private fun setupViewPager() {
        viewPagerAdapter = ViewPagerAdapter()
        binding.vpCountry.adapter = viewPagerAdapter
    }
}