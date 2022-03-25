package com.example.firminiq.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firminiq.ui.main.model.GridItem
import com.example.firminiq.ui.main.repository.ImageRepository

class MainViewModel : ViewModel() {

    val gridItemLiveData: MutableLiveData<List<GridItem>> = MutableLiveData()

    fun setFilterText(inputTextFilter: String) {
        gridItemLiveData.postValue(ImageRepository.getImageItems().filter { it.imageName.contains(inputTextFilter, true) })
    }
}