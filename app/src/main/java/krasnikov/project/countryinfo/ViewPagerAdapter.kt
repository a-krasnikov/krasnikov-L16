package krasnikov.project.countryinfo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import krasnikov.project.countryinfo.data.model.Country

class ViewPagerAdapter :
    ListAdapter<Country, ViewPagerAdapter.CountryViewHolder>(CountryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun getItemTabName(position: Int): String = getItem(position).name

    class CountryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(country: Country) {
            with(itemView) {
                findViewById<TextView>(R.id.tvName).text =
                    resources.getString(R.string.text_name, country.name)

                findViewById<TextView>(R.id.tvArea).text =
                    resources.getString(R.string.text_area, country.area)

                findViewById<TextView>(R.id.tvPopulation).text =
                    resources.getString(R.string.text_population, country.population)

                findViewById<TextView>(R.id.tvPopulationDensity).text =
                    resources.getString(R.string.text_population_density, country.populationDensity)
            }
        }
    }
}

private class CountryDiffCallback : DiffUtil.ItemCallback<Country>() {

    override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
        return oldItem.population == newItem.population
                && oldItem.area == newItem.area
    }
}