package demo.playback.video.videoplayback

import android.view.LayoutInflater
import android.view.ViewGroup

import com.bumptech.glide.RequestManager

import java.util.ArrayList
import androidx.recyclerview.widget.RecyclerView
import demo.playback.video.videoplayback.models.MediaObject

class VideoPlayerRecyclerAdapter(private val mediaObjects: ArrayList<MediaObject>, private val requestManager: RequestManager) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): RecyclerView.ViewHolder {
        return VideoPlayerViewHolder(
                LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_video_list_item, viewGroup, false))
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, i: Int) {
        (viewHolder as VideoPlayerViewHolder).onBind(mediaObjects[i], requestManager)
    }

    override fun getItemCount(): Int {
        return mediaObjects.size
    }

}

