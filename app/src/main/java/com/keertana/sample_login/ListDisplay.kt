package com.keertana.sample_login

import android.app.ProgressDialog
import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_list_display.*
import org.json.JSONArray
import java.net.HttpURLConnection
import java.net.URL

const val BASE_URL="https://api.publicapis.org/entries"
class ListDisplay : AppCompatActivity() {

    lateinit var pDialog:ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_display)
        AsyncTaskHandler().execute(BASE_URL)

        val actionBar=supportActionBar
        actionBar!!.title="Second Activity"
        actionBar.setDisplayHomeAsUpEnabled(true)

    }

    inner class AsyncTaskHandler:AsyncTask<String,String,String>(){
        override fun onPreExecute() {
            super.onPreExecute()
            pDialog= ProgressDialog(this@ListDisplay)
            pDialog.setMessage("Please Wait")
            pDialog.setCancelable(false)
            pDialog.show()
        }

        override fun doInBackground(vararg url: String?): String {
            val res:String
            val connection= URL(url[0]).openConnection() as HttpURLConnection
            try {
                connection.connect()
                res=connection.inputStream.use { it.reader().use { reader->reader.readText() } }
            }finally {
                connection.disconnect()
            }
            return res
        }
        override fun onPostExecute(result:String?){
            super.onPostExecute(result)

            if (pDialog.isShowing())
                pDialog.dismiss()
            jsonResult(result)
        }
        private fun jsonResult(jsonString:String?){
            val jsonArray=JSONArray(jsonString)

            val list=ArrayList<Entry>()
            var i=0
            while(i<jsonArray.length())
            {
                val jsonObject=jsonArray.getJSONObject(i)
                list.add(
                    Entry(
                        jsonObject.getString("API"),
                        jsonObject.getString("Auth"),
                        jsonObject.getString("Category"),
                        jsonObject.getString("Cors"),
                        jsonObject.getString("Auth"),
                        jsonObject.getBoolean("HTTPS"),
                        jsonObject.getString("Link")
                    )
                )
                i++
            }
            val adapter=ListAdapter(this@ListDisplay,list)
            myList.adapter=adapter
        }
    }

}