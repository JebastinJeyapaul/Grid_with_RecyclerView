package com.example.firminiq.ui.main.repository

import android.R
import com.example.firminiq.ui.main.model.GridItem


object ImageRepository {
    fun getImageItems(): ArrayList<GridItem> {
        val gridItemArrayList: ArrayList<GridItem> = ArrayList()
        gridItemArrayList.add(GridItem("Add", R.drawable.ic_menu_add))
        gridItemArrayList.add(GridItem("Next", R.drawable.ic_media_next))
        gridItemArrayList.add(GridItem("Play", R.drawable.ic_media_play))
        gridItemArrayList.add(GridItem("Pause", R.drawable.ic_media_pause))
        gridItemArrayList.add(GridItem("Alert", R.drawable.ic_dialog_alert))
        gridItemArrayList.add(GridItem("Previous", R.drawable.ic_media_previous))
        gridItemArrayList.add(GridItem("Edit", R.drawable.ic_menu_edit))
        gridItemArrayList.add(GridItem("Reverse", R.drawable.ic_media_rew))
        gridItemArrayList.add(GridItem("Forward", R.drawable.ic_media_ff))
        gridItemArrayList.add(GridItem("Charging", R.drawable.ic_lock_idle_charging))
        gridItemArrayList.add(GridItem("Silent mode", R.drawable.ic_lock_silent_mode))
        gridItemArrayList.add(GridItem("Report", R.drawable.ic_menu_report_image))
        gridItemArrayList.add(GridItem("Camera", R.drawable.ic_menu_camera))
        gridItemArrayList.add(GridItem("Delete", R.drawable.ic_menu_delete))
        return gridItemArrayList
    }
}