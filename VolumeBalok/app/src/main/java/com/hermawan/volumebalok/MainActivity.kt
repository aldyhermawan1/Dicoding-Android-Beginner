package com.hermawan.volumebalok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.hermawan.volumebalok.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    /*
    private lateinit var editLength: EditText
    private lateinit var editWidth: EditText
    private lateinit var editHeight: EditText
    private lateinit var btnCalculate: Button
    private lateinit var textResult: TextView
     */
    private lateinit var binding: ActivityMainBinding

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*
        editLength = findViewById(R.id.editLength)
        editWidth = findViewById(R.id.editWidth)
        editHeight = findViewById(R.id.editHeight)
        btnCalculate = findViewById(R.id.btnCalculate)
        textResult = findViewById(R.id.textResult)
         */
        binding.btnCalculate.setOnClickListener(this)

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            binding.textResult.text = result
        }
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btnCalculate) {
            val inputLength = binding.editLength.text.toString().trim()
            val inputHeight = binding.editHeight.text.toString().trim()
            val inputWidth = binding.editWidth.text.toString().trim()

            var isEmptyFields = false

            when {
                inputLength.isEmpty() -> {
                    isEmptyFields = true
                    binding.editLength.error = "Field ini tidak boleh kosong"
                }
                inputWidth.isEmpty() -> {
                    isEmptyFields = true
                    binding.editWidth.error = "Field ini tidak boleh kosong"
                }
                inputHeight.isEmpty() -> {
                    isEmptyFields = true
                    binding.editHeight.error = "Field ini tidak boleh kosong"
                }
            }

            if (!isEmptyFields){
                val volume = inputHeight.toDouble() * inputLength.toDouble() * inputWidth.toDouble()
                binding.textResult.text = volume.toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, binding.textResult.text.toString())
    }
}