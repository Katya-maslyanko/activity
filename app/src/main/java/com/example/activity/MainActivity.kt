package com.example.activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var editText1: EditText
    private lateinit var editText2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText1 = findViewById(R.id.textInput)
        editText2 = findViewById(R.id.numberInput)

        val savedText = savedInstanceState?.getString("text")
        editText1.setText(savedText)
    }

    fun navigateToSecondActivity() {
        val text = editText1.text.toString()
        if (text.isNotEmpty()) {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("text", text)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Please enter text", Toast.LENGTH_SHORT).show()
        }
    }


    fun dialPhoneNumber() {
        val number = editText2.text.toString()
        if (number.isNotEmpty()) {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$number")
            startActivity(intent)
        } else {
            Toast.makeText(this, "Please enter phone number", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("text", editText1.text.toString())
    }
}
