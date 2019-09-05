package com.example.usagecommonintent

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val mAdapter = CustomAdapter(this, listItems)
        mRecyclerView.adapter = mAdapter

        val lm = LinearLayoutManager(this)
        mRecyclerView.layoutManager = lm
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        mAdapter.itemClick = object: CustomAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                MoveIntent(position)
            }
        }

    }

    var listItems = arrayListOf<ListItem>(


        ListItem("Call the scheme Apps"),
        ListItem("Move To Google WebPage"),
        ListItem("Open the Google Map App"),
        ListItem("Looking for google Map position"),
        ListItem("Call the Phone"),
        ListItem("Send the SMS Message"),

        ListItem("Send the MMS Message"),
        ListItem("Send the E-mail"),
        ListItem("Email and Extra"),
        ListItem("Play the Media"),
        ListItem("Remove the app"),

        ListItem("Through app to remove the apk"),
        ListItem("Intall the apk"),
        ListItem("Play the music file"),
        ListItem("Send the email and file"),
        ListItem("Looking for the app in Play store")

    )

    fun MoveIntent(idx : Int) {


        when (idx) {
            0 -> {

                val nextintent = Intent(Intent.ACTION_VIEW, Uri.parse("bill://aaaa?param1=test&param2=test2"))
                startActivity(nextintent)
            }

            1 -> {
                val nextintent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
                startActivity(nextintent)
            }

            2 -> {
                val nextintent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:38.899533,-77.036476"))
                startActivity(nextintent)
            }

            3 -> {
                val nextintent = Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?f=d&saddr=1600 Amphitheatre Pkwy, Mountain View, CA 94043&daddr=1600 Amphitheatre Pkwy, Mountain View, CA 94043&hl=us"))
                startActivity(nextintent)
            }

            4 -> {
                val nextintent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:911"))
                startActivity(nextintent)
            }

            5 -> {
                val nextintent = Intent(Intent.ACTION_VIEW)
                nextintent.putExtra("sms_body", "The SMS text")
                nextintent.setType("vnd.android-dir/mms-sms")
                nextintent.setData(Uri.parse("sms:"))
                startActivity(nextintent)
            }

            6 -> {

                val nextintent = Intent(Intent.ACTION_SEND)
                nextintent.putExtra("sms_body", "your mind write")
                nextintent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://media/external/images/media/23"))
                nextintent.setType("image/png")
                startActivity(nextintent)

            }

            7 -> {

                val nextintent = Intent(Intent.ACTION_SEND)
                val tos = arrayOf("abced1@abc.com")
                val ccs = arrayOf("me@abc.com")
                nextintent.putExtra(Intent.EXTRA_EMAIL, tos)
                nextintent.putExtra(Intent.EXTRA_CC, ccs)
                nextintent.putExtra(Intent.EXTRA_TEXT, "body text")
                nextintent.putExtra(Intent.EXTRA_SUBJECT, "Subject text")
                nextintent.setType("message/rfc822")
                startActivity(nextintent)

            }

            8 -> {

                val nextintent = Intent(Intent.ACTION_SEND)
                nextintent.putExtra(Intent.EXTRA_SUBJECT, "Subject Text")
                nextintent.putExtra(Intent.EXTRA_STREAM, "file:///sdcard/test.mp3")
                nextintent.setType("audio/mp3")
                startActivity(Intent.createChooser(nextintent, "Choose Music file"))

            }

            9 -> {

                val nextintent = Intent(Intent.ACTION_VIEW, Uri.withAppendedPath(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, "1"))
                startActivity(nextintent)

            }

            10 -> {

                val nextintent = Intent(Intent.ACTION_DELETE, Uri.fromParts("package", this.packageName, null))
                startActivity(nextintent)

            }

            11 -> {

                val nextintent = Intent(Intent.ACTION_DELETE, Uri.fromParts("package", "xxx.example", null))
                startActivity(nextintent)

            }

            12 -> {

                val nextintent = Intent(Intent.ACTION_VIEW, Uri.parse("file:///sdcard/download/piyoi.mp3"))
                startActivity(nextintent)

            }

            13 -> {

                val nextintent = Intent(Intent.ACTION_SEND)
                nextintent.putExtra(Intent.EXTRA_SUBJECT, "The email subject text")
                nextintent.putExtra(Intent.EXTRA_STREAM, "file:///sdcard/eoe.mp3")
                nextintent.setType("audio/mp3")
                startActivity(Intent.createChooser(nextintent, "Choose Email Client"))

            }

            14 -> {

                val nextintent = Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q=pname:pkg_name"))
                startActivity(nextintent)

            }

            15 -> {
                val nextintent = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=applicationid"))
                startActivity(nextintent)
            }

            16 -> {

                val nextintent = Intent(Intent.ACTION_VIEW)
                nextintent.setAction(Intent.ACTION_WEB_SEARCH)
                nextintent.putExtra(SearchManager.QUERY,"searchString");
                startActivity(nextintent)
            }


            else -> {
                println("Number too high")
            }
        }
    }

}
