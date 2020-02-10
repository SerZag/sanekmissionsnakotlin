package com.me.sanekmissionsnakotiln

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlin.time.milliseconds

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        videoView.setVideoPath("https://sample-videos.com/video123/mp4/240/big_buck_bunny_240p_30mb.mp4")
        var togglevar = true
        var stoptime = 0
        fab.setOnClickListener { view ->
            videoView.setVideoPath("https://sample-videos.com/video123/mp4/240/big_buck_bunny_240p_30mb.mp4")
            videoView.start()

        }
        stop.setOnClickListener { view ->
            stoptime = videoView.currentPosition
            textView.setText(stoptime.toString())
            videoView.stopPlayback()

        }
        button4.setOnClickListener { view ->
            videoView.seekTo(stoptime)

        }
        pause.setOnClickListener { view ->
            videoView.pause()
        }
        resume.setOnClickListener { view ->
            videoView.resume()
        }
        toggle.setOnClickListener { view ->
            if (togglevar == true) {
                toggle.setText("disable sound")
            }

            if (togglevar == false) {
                toggle.setText("enable sound")
            }

            togglevar = !togglevar

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
