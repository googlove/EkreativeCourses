package com.flame4ost.datainfoapi.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.flame4ost.datainfoapi.databinding.ListItemsActivityBinding
import com.flame4ost.datainfoapi.presentation.view_model.ListItemsActivityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListItemsActivity : AppCompatActivity() {

    private lateinit var binding: ListItemsActivityBinding
    private val viewModel by viewModel<ListItemsActivityViewModel>()
    private val listItemAdapter = ListItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ListItemsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.loadItemList()

        initAdapter()
        initObserver()
    }

    private fun initAdapter(){
        binding.recyclerViewContainerItem.apply {
            adapter = listItemAdapter
        }
    }

    private fun initObserver(){
        viewModel.itemList.observe(this, {
            listItemAdapter.submitList(it)
        })
    }
}