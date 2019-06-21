package presentation

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import domain.model.Speaker
import kotlinx.android.synthetic.main.item_speaker.view.*
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cmota.commit19.R
import presentation.cb.IOnUserAction

class SpeakersListAdapter(private val speakers: List<Speaker>, private val action: IOnUserAction): RecyclerView.Adapter<SpeakersListAdapter.SpeakerViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): SpeakerViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        return SpeakerViewHolder(
            inflater.inflate(
                R.layout.item_speaker,
                viewGroup,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return speakers.size
    }

    override fun onBindViewHolder(viewHolder: SpeakerViewHolder, position: Int) {
        val speaker = speakers[position]

        Glide.with(viewHolder.speakerPhoto)
             .load(speaker.img)
             .apply(RequestOptions.circleCropTransform())
             .into(viewHolder.speakerPhoto)

        viewHolder.speakerName.text = speaker.speaker
        viewHolder.talkTitle.text = speaker.talkTitle
        viewHolder.container.setOnClickListener {
            action.onUserClickAction(speaker, it)
        }
    }


    class SpeakerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val container: RelativeLayout = itemView.rl_container
        val speakerPhoto: ImageView = itemView.iv_speaker_photo
        val speakerName: TextView = itemView.tv_speaker_name
        val talkTitle: TextView = itemView.tv_talk_title
    }
}