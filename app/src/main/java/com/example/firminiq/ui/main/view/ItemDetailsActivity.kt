package com.example.firminiq.ui.main.view

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firminiq.R
import kotlinx.android.synthetic.main.item_details_activity.*

class ItemDetailsActivity : AppCompatActivity() {

    companion object {
        const val IMAGE_ID_KEY = "IMAGE_ID_KEY"
        const val IMAGE_NAME_KEY = "IMAGE_NAME_KEY"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_details_activity)
        if(resources.getBoolean(R.bool.portrait_only)){
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        intent?.extras?.let {
            itemDetailImage.setImageResource(it.getInt(IMAGE_ID_KEY))
            itemTitle.text = it.getString(IMAGE_NAME_KEY, "")
        }
    }
}