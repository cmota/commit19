package presentation.cb

import android.view.View
import domain.model.Speaker

interface IOnUserAction {

    fun onUserClickAction(speaker: Speaker, view: View)
}
