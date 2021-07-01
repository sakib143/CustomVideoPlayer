package com.example.customplayerdemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.customplayerdemo.exoplayer.PlayerActivity
import com.example.customplayerdemo.exoplayer.model.VideoSource
import java.util.*

class MainActivity : AppCompatActivity() {

    private var videoUriList: ArrayList<String> = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadVideoList()
        goToPlayerActivity(makeVideoSource(videoUriList, 0))
    }

    fun loadVideoList() {
        videoUriList.add("https://5b44cf20b0388.streamlock.net:8443/vod/smil:bbb.smil/playlist.m3u8")
    }

    private fun makeVideoSource(videos: List<String>, index: Int): VideoSource? {
        val singleVideos: ArrayList<VideoSource.SingleVideo> = ArrayList<VideoSource.SingleVideo>()
        for (i in videos.indices) {
            singleVideos.add(
                i, VideoSource.SingleVideo(
                    videos[i])
            )
        }
        return VideoSource(singleVideos, index)
    }

    //start player for result due to future features
    fun goToPlayerActivity(videoSource: VideoSource?) {
        val REQUEST_CODE = 1000
        val intent = Intent(applicationContext, PlayerActivity::class.java)
        intent.putExtra("videoSource", videoSource)
        startActivityForResult(intent, REQUEST_CODE)
    }

}