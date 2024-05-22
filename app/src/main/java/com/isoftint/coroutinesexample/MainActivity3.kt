package com.isoftint.coroutinesexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity3 : AppCompatActivity() {
    var TAG = "KotlinFun"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

//        GlobalScope.launch(Dispatchers.Main) {
//            execute()
//        }
          CoroutineScope(Dispatchers.IO).launch {
              execute()
          }
    }

    private suspend fun execute(){
//        var parentJob = GlobalScope.launch(Dispatchers.Main){
//            Log.d(TAG,"Parent Started")
//
//            var childJob = launch{
//                try {
//                    Log.d(TAG,"Child job Started")
//                    delay(5000)
//                    Log.d(TAG,"Child job Ended")
//                }
//                catch (ex:CancellationException){
//                    Log.d(TAG,"Child job Cancelled")
//                }
//            }
//            delay(3000)
////            childJob.cancel()
//            Log.d(TAG,"Parent job Ended")
//
//        }
//        delay(100)
//        parentJob.cancel()
//        Log.d(TAG,"Parent job Cancelled")
//        parentJob.join()
//        Log.d(TAG,"Parent job Complete")

        /* Sen 2 */
        val Job = CoroutineScope(Dispatchers.IO).launch {
            for (i in 1..1000){
                executeLongRuningTask()
                Log.d(TAG,i.toString())
            }
        }

       // delay(100)
//        Log.d(TAG,"Canceling Job")
//        parentJob.cancel()
//        Log.d(TAG,"Canceling Job")
        Job.join()
        Log.d(TAG,"Parent Completed")


    }

    private fun executeLongRuningTask(){
        for (i in 1..1000000){
        }
    }
}