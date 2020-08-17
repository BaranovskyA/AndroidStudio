package com.example.education

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox

class MainActivity2 : AppCompatActivity() {



    var array = arrayOf("Tom", "Ned", "Bob", "Nick", "Jack", "Freddy", "Alfred", "Armando", "Alan", "Bruce", "Brian", "Cris", "Donald", "Kevin", "Herald", "John", "Mark", "Max", "Martin", "Oscar", "Peter", "Patric", "Robert", "Richard", "Stan", "William", "Thomas", "Alex", "Antonio", "Andrew")
    var IDCheckBoxes = arrayOf(R.id.checkbox_list1, R.id.checkbox_list2,R.id.checkbox_list3,R.id.checkbox_list4,R.id.checkbox_list5,R.id.checkbox_list6,R.id.checkbox_list7,R.id.checkbox_list8,R.id.checkbox_list9,R.id.checkbox_list10,R.id.checkbox_list11,R.id.checkbox_list12,R.id.checkbox_list13,R.id.checkbox_list14,R.id.checkbox_list15)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        for (i in IDCheckBoxes) {
            findViewById<CheckBox>(i).text = array.get((0..29).random())
        }
    }


    fun checkInfo(view: View) {
        for (i in IDCheckBoxes) {
            var checkbox:CheckBox = findViewById<CheckBox>(i)
            if(!checkbox.isChecked) {
                checkbox.setTextColor(Color.RED)
            }
        }
    }
}