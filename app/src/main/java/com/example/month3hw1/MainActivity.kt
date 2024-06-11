package com.example.month3hw1

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.month3hw1.databinding.ActivityMainBinding
import java.lang.Exception
import java.net.URI

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickIntent()
    }

    private fun clickIntent() {

        binding.sendBtn.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val theme = binding.themeEt.text.toString()
            val text = binding.textEmailEt.text.toString()
            sendEmailIntent(email, theme, text)
        }

    }

    @SuppressLint("IntentReset")
    private fun sendEmailIntent(email: String, theme: String, text: String) {
        if (theme.equals("") || email.equals("") || text.equals("")) {
            Toast.makeText(this, "fill all fields", Toast.LENGTH_SHORT).show()
        } else {
            val mIntent = Intent(Intent.ACTION_SEND)
            mIntent.data = Uri.parse("mailto:")
            mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
            mIntent.putExtra(Intent.EXTRA_SUBJECT, theme)
            mIntent.putExtra(Intent.EXTRA_TEXT, text)
            mIntent.type = "text/plain"
            try {
                startActivity(Intent.createChooser(mIntent, "Choose Email client."))
            } catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
        }


    }

}
