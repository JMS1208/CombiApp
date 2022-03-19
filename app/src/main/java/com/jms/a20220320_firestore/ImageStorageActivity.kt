package com.jms.a20220320_firestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jms.a20220320_firestore.databinding.ActivityImageStorageBinding

class ImageStorageActivity : AppCompatActivity() {
    lateinit var binding : ActivityImageStorageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageStorageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title="이미지 파이어스토리지에 저장"
    }
}