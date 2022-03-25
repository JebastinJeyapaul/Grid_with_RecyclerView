package com.example.firminiq.ui.main.view

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.firminiq.R
import com.example.firminiq.ui.main.adapter.GridImageAdapter
import com.example.firminiq.ui.main.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        recyclerView.layoutManager = GridLayoutManager(context, resources.getInteger(R.integer.gridCount))
        val gridAdapter = GridImageAdapter(object: GridImageAdapter.GridItemClickListener{
            override fun onGridItemClicked(imageId: Int, imageTitle: String) {
                val intent = Intent(context, ItemDetailsActivity::class.java)
                intent.putExtra(ItemDetailsActivity.IMAGE_ID_KEY, imageId)
                intent.putExtra(ItemDetailsActivity.IMAGE_NAME_KEY, imageTitle)
                startActivity(intent)
            }
        })

        recyclerView.adapter = gridAdapter
        viewModel.setFilterText("")

        searchInput.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(inputText: CharSequence?, start: Int, before: Int, count: Int) {
                inputText?.let {inputTextFilter ->
                    viewModel.setFilterText(inputTextFilter.toString())
                }
            }
        })

        viewModel.gridItemLiveData.observe(viewLifecycleOwner) { gridList ->
            gridList?.let { gridAdapter.setGridItem(gridList) }
        }
    }
}