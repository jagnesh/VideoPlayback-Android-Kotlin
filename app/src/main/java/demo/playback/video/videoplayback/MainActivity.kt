package demo.playback.video.videoplayback

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import demo.playback.video.videoplayback.models.MediaObject
import demo.playback.video.videoplayback.util.Resources
import demo.playback.video.videoplayback.util.VerticalSpacingItemDecorator


class MainActivity : AppCompatActivity() {

    private var mRecyclerView: VideoPlayerRecyclerView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRecyclerView = findViewById(R.id.recycler_view)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        mRecyclerView?.setLayoutManager(layoutManager)
        val itemDecorator = VerticalSpacingItemDecorator(10)
        mRecyclerView!!.addItemDecoration(itemDecorator)

        val mediaObjects = ArrayList<MediaObject>(Resources.MEDIA_OBJECTS.toList())
        mRecyclerView!!.setMediaObjects(mediaObjects)
        val adapter = VideoPlayerRecyclerAdapter(mediaObjects, initGlide())
        mRecyclerView!!.setAdapter(adapter)
    }

    private fun initGlide(): RequestManager {
        val options = RequestOptions()
                .placeholder(R.drawable.white_background)
                .error(R.drawable.white_background)

        return Glide.with(this)
                .setDefaultRequestOptions(options)
    }


    override fun onDestroy() {
        if (mRecyclerView != null)
            mRecyclerView!!.releasePlayer()
        super.onDestroy()
    }
}
