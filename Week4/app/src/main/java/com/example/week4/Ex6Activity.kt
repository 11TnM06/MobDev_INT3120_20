package com.example.week4

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Ex6Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex6)

        val searchIntent = Intent(Intent.ACTION_WEB_SEARCH)
        searchIntent.putExtra(SearchManager.QUERY, "straight hitting golf clubs")

        val phoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:555-1234"))

        val smsIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("sms:5551234"))
        smsIntent.putExtra("sms body", "are we playing golf next Saturday?")

        val pictureIntent = Intent(Intent.ACTION_GET_CONTENT)
        pictureIntent.type = "image/pictures/"

        val myData = Uri.parse("content://contacts/people/")
        val contactsIntent = Intent(Intent.ACTION_VIEW, myData)

        val geoCode = Uri.parse("geo:0,0?q=1860+east+18th+street+cleveland+oh")
        val geoCode2 = Uri.parse("geo:41.5020952,-81.6789717")
        val geoIntent = Intent(Intent.ACTION_VIEW, geoCode)

        val musicIntent = Intent("android.intent.action.MUSIC_PLAYER")
        startActivity(contactsIntent)
    }
}