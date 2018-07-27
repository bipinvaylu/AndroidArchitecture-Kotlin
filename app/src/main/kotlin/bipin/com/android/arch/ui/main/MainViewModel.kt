package bipin.com.android.arch.ui.main

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.content.Context
import bipin.com.android.arch.App
import bipin.com.android.arch.base.BaseViewModel
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Bipin Vayalu on 27/07/18.
 */

class MainViewModel @Inject constructor() : BaseViewModel() {

    private val labels = arrayListOf("Hello", "Hi", "Welcome")

    private fun pickRandomLabel() = labels[randomIndex()]

    private fun randomIndex() = (Math.random() * labels.size).toInt()

    val randomLabelObservable: Observable<String> by lazy {
        Observable.just(pickRandomLabel())
    }

}
