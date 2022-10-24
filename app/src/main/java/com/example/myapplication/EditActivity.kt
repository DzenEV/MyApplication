package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.databinding.ActivityEditBinding
import com.example.myapplication.databinding.ActivityMainBinding

class EditActivity : AppCompatActivity() {

    lateinit var binding: ActivityEditBinding
    private var indexImage = 0
    private var imageId = R.drawable.image1
    private val imageIdList = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtons()
    }

    private fun initButtons() = with(binding){
    bNext.setOnClickListener {
        indexImage++
        if(indexImage > imageIdList.size - 1) indexImage = 0
        imageId = imageIdList[indexImage]
        imageView.setImageResource(imageId)
    }
    bDone.setOnClickListener {
        val plant = Plant(imageId, edTitle.text.toString(), edDesc.text.toString())
        val editIntent = Intent().apply {
            putExtra("plant", plant)
                    }
        setResult(RESULT_OK, editIntent)
        finish()
    }
    }

}