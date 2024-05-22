package com.isoftint.coroutinesexample

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    lateinit var counter: TextView
    private val TAG:String = "Kotlinfun"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     //   counter = findViewById(R.id.textView)
        CoroutineScope(Dispatchers.Main).launch {
            task1()
        }
        CoroutineScope(Dispatchers.Main).launch {
            task2()
        }

    }

//    fun updateCounter(view: View) {
//        counter.text = "${counter.text.toString().toInt()+1}"
//    }
//
//    private fun excu(){
//        for (i in 1..1000000000L){}
//    }
//
//    fun doExcution(view: View) {
//
//        thread(start = true){
//            excu()
//        }
//    }

    suspend fun task1(){
        Log.d(TAG,"Starting Task 1")
        Log.d(TAG,"ending Task 1")
    }
    suspend fun task2(){
        Log.d(TAG,"Starting Task 2")
        Log.d(TAG,"ending Task 2")
    }

}