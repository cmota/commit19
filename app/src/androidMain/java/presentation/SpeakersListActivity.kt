package presentation

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import domain.model.Speaker
import kotlinx.android.synthetic.main.activity_main.*
import com.cmota.commit19.R
import android.support.v7.widget.DividerItemDecoration
import android.view.View
import presentation.cb.IOnUserAction
import utils.*

private const val TAG = "SpeakersListActivity"

class SpeakersListActivity : AppCompatActivity(), ISpeakersListView, IOnUserAction {

    private val presenter by lazy { ServiceLocator.getSpeakersListPresenter }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        toolbar.title = getString(R.string.app_name)
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
    }

    private fun setUiComponents(speakers: List<Speaker>) {
        val linearLayoutManager = LinearLayoutManager(this@SpeakersListActivity)

        rv_content.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = SpeakersListAdapter(speakers, this@SpeakersListActivity)
        }

        val dividerItemDecoration = DividerItemDecoration(
            applicationContext,
            linearLayoutManager.orientation
        )

        rv_content.addItemDecoration(dividerItemDecoration)
    }

    //region ISpeakersListView
    override fun onSpeakersListFetched(speakers: List<Speaker>) {
        Log.d(TAG, "onSpeakersListFetched | speakers=$speakers")
        setUiComponents(speakers)
    }

    override fun onSpeakersListFailed(e: Exception) {
        Log.d(TAG, "onSpeakersListFailed | exception=$e")
    }

    //endregion

    //region IOnUserAction
    override fun onUserClickAction(speaker: Speaker, view: View) {
        val intent = Intent(this, SpeakerActivity::class.java)
        intent.putExtra(EXTRA_SPEAKER_NAME, speaker.speaker)
        intent.putExtra(EXTRA_SPEAKER_IMG, speaker.img)
        intent.putExtra(EXTRA_TALK_TITLE, speaker.talkTitle)
        intent.putExtra(EXTRA_TALK_DESCRIPTION, speaker.talkDescription)
        intent.putExtra(EXTRA_TALK_SCHEDULE, speaker.talkSchedule)

        startActivity(intent)
    }

    //endregion
}