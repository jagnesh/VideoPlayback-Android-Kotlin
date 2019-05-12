package demo.playback.video.videoplayback

import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import demo.playback.video.videoplayback.models.MediaObject

class VideoPlayerViewHolder(internal var parent: View) : RecyclerView.ViewHolder(parent) {

    internal var media_container: FrameLayout
    internal var title: TextView
    lateinit var thumbnail: ImageView
    lateinit var volumeControl: ImageView
    lateinit var progressBar: ProgressBar
    internal lateinit var requestManager: RequestManager


    init {
        media_container = parent.findViewById(R.id.media_container)
        thumbnail = parent.findViewById(R.id.thumbnail)
        title = parent.findViewById(R.id.title)
        progressBar = parent.findViewById(R.id.progressBar)
        volumeControl = parent.findViewById(R.id.volume_control)
    }

    fun onBind(mediaObject: MediaObject, requestManager: RequestManager) {
        this.requestManager = requestManager
        parent.tag = this
        title.text = mediaObject.title
        this.requestManager
                .load(mediaObject.thumbnail)
                .into(thumbnail)
    }

}
