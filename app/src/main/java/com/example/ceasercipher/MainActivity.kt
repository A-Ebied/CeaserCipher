package com.example.ceasercipher
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        this.supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        val inputText:EditText= findViewById<EditText>(R.id.editText)
        val keyText:EditText= findViewById<EditText>(R.id.editText2)
        val tOut:TextView = findViewById<TextView>(R.id.textView2)
        val btn:Button = findViewById<Button>(R.id.button)
        val sw1:Switch = findViewById<Switch>(R.id.switch1)

        var newString: String
        var inputString:String
          var key:Int

        btn.setOnClickListener {
            key = keyText.text.toString().toInt()
            inputString = inputText.text.toString()
            if (sw1.isChecked) {
                newString = encryption(inputString, key)
            } else {
                newString = decryption(inputString, key)
            }
            tOut.text = newString
        }


    }

     val alpha = "abcdefghijklmnopqrstuvwxyz !@#$"
     var alphaLen = alpha.length
    fun  encryption(plainText: String, k: Int) : String
    {
        var plainLen = plainText.length
        var cipher = ""

        for (item in plainText)
        {
            cipher +=  alpha[ (k + alpha.indexOf(item)) % alphaLen ]
        }
        return cipher
    }

    fun  decryption(cipherText: String, k: Int) : String
    {
        var cipherLen = cipherText.length
        var plain = ""

        for (item in cipherText)
        {
            var temp = (alpha.indexOf(item) - k) % alphaLen
            if (temp < 0)
            {
                temp = (alphaLen + alpha.indexOf(item) - k) % alphaLen
            }
            plain +=  alpha[temp]
        }
        return plain
    }

    //  Code Design By Abdallah Ebied

}



