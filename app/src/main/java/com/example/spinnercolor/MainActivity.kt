package com.example.spinnercolor

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.DocumentsContract
import android.sax.RootElement
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.spinnercolor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val color = resources.getStringArray(R.array.colors)
        val rootView = binding.constraint
        val sp = binding.spinner
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,color)

        sp.adapter = adapter

        sp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Log.d("Color",color.toString())
                when (sp.selectedItemPosition) {
                    1 -> {
                        rootView.setBackgroundResource(R.color.red)
                    }
                    2 -> {
                        rootView.setBackgroundResource(R.color.orange)
                    }
                    3 -> {
                        rootView.setBackgroundResource(R.color.blue)
                    }
                    4 -> {
                        rootView.setBackgroundResource(R.color.yellow)
                    }
                }
//
                Toast.makeText(this@MainActivity,""+color[p2],Toast.LENGTH_SHORT).show()
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }



    }

}