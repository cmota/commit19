package presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cmota.commit19.R
import kotlinx.android.synthetic.main.activity_speaker.*
import utils.*

class SpeakerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_speaker)

        val speakerName = intent.extras.getString(EXTRA_SPEAKER_NAME)
        val imageImage = intent.extras.getString(EXTRA_SPEAKER_IMG)

        val talkTitle = intent.extras.getString(EXTRA_TALK_TITLE)
        val talkDescription = intent.extras.getString(EXTRA_TALK_DESCRIPTION)
        val talkSchedule = intent.extras.getString(EXTRA_TALK_SCHEDULE)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        collapsing_toolbar.title = speakerName

        Glide.with(this)
            .load(imageImage)
            .apply(RequestOptions.centerCropTransform())
            .into(iv_speaker_photo)

        tv_talk_title.text = talkTitle
        tv_talk_schedule.text = talkSchedule
        tv_talk_description.text = talkDescription
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}