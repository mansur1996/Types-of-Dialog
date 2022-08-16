package com.android.dialogtypes

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {

        button.setOnClickListener {
            val myArray = arrayOf("Kotlin", "Java", "JavaScript", "Python", "C#", "C++", "Pascal")

            val alertDialog = AlertDialog.Builder(this)
                .setTitle("AlertDialog")
//                .setMessage("Message")
                .setCancelable(true)
                .setPositiveButton("Positive", object : DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        Toast.makeText(this@MainActivity, "Positive", Toast.LENGTH_SHORT).show()
                        dialog?.dismiss()
                    }
                })
                .setNegativeButton("Negative", object : DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        Toast.makeText(this@MainActivity, "Negative", Toast.LENGTH_SHORT).show()
                        dialog?.dismiss()
                    }
                })
                .setNeutralButton("Neutral"
                ) { dialog, which ->
                    Toast.makeText(this@MainActivity, "Neutral", Toast.LENGTH_SHORT).show()
                    dialog?.dismiss()
                }
//                .setMultiChoiceItems(myArray, BooleanArray(myArray.size), object :DialogInterface.OnMultiChoiceClickListener{
//                    override fun onClick(dialog: DialogInterface?, which: Int, isChecked: Boolean) {
//                        Toast.makeText(this@MainActivity, "${myArray[which]}", Toast.LENGTH_SHORT).show()
//                    }
//                })
                .setSingleChoiceItems(myArray, -1, object : DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        Toast.makeText(this@MainActivity, "${myArray[which]}", Toast.LENGTH_SHORT).show()
                    }
                })
                .show()
        }
    }
}