package com.isoftint.coroutinesexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity2 : AppCompatActivity() {
    val TAG:String = "KotlinFun"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        CoroutineScope(Dispatchers.IO).launch {
            printFollowers()
        }
    }

    private suspend fun printFollowers(){
//        var fbFollowers = 0
//        var job = CoroutineScope(Dispatchers.IO).launch {
//            fbFollowers = getFbFollowers()
//        }
//        job.join()
//        Log.d(TAG,"${fbFollowers}")
        val fb = CoroutineScope(Dispatchers.IO).async {
            getFbFollowers()
        }
        val insta = CoroutineScope(Dispatchers.IO).async {
            getInstaFollowers()
        }

        Log.d(TAG,"FB- ${fb.await()}, insta-${insta.await()}")
    }
    private suspend fun getFbFollowers():Int{
        delay(1000)
        return 54
    }
    private suspend fun getInstaFollowers():Int{
        delay(2000)
        return 120
    }
}