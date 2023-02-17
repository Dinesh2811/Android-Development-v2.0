package com.dinesh.android.kotlin.basic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import com.dinesh.android.databinding.BasicV1Binding

private val TAG = "log_" + V1::class.java.name.split(V1::class.java.name.split(".").toTypedArray()[2] + ".").toTypedArray()[1]

class V1 : AppCompatActivity() {
    private lateinit var binding: BasicV1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = BasicV1Binding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}