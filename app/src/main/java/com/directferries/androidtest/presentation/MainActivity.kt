package com.directferries.androidtest.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.directferries.androidtest.R
import com.directferries.androidtest.data.CarEntity
import com.directferries.androidtest.databinding.ActivityMainBinding
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_view_car.view.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<MainViewModel> { viewModelFactory }

    private lateinit var binding: ActivityMainBinding

    private lateinit var listAdapter: CarsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewModel = viewModel

        // Set the lifecycle owner to the lifecycle of the view
        binding.lifecycleOwner = this

        setupListAdapter()
        subscribeUi(listAdapter)

        viewModel.loadCars()
    }

    private fun subscribeUi(adapter: CarsAdapter) {
        viewModel.cars.observe(this) { cars ->
            adapter.submitList(cars)
        }
    }

    private fun setupListAdapter() {
        listAdapter = CarsAdapter()
        binding.carsRecycler.adapter = listAdapter
    }

    object Adapter : RecyclerView.Adapter<Holder>() {
        var listItems: MutableList<CarEntity> = mutableListOf()
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
            return Holder(View.inflate(parent.context, R.layout.item_view_car, parent))
        }

        override fun getItemCount(): Int {
            return listItems.size
        }

        override fun onBindViewHolder(holder: Holder, position: Int) {
            holder.bindView(listItems[position])
        }
    }

    class Holder(view: View): RecyclerView.ViewHolder(view) {
        fun bindView(car: CarEntity) {
            itemView.make.text = car.make
            itemView.model.text = car.model
        }
    }
}
