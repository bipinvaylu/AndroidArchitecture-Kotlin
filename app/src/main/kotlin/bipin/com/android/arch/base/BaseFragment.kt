package bipin.com.android.arch.base

import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import bipin.com.android.arch.base.BaseActivity
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseFragment : Fragment() {
	
	@Inject
	lateinit var viewModelFactory: ViewModelProvider.Factory
	
	fun getBaseActivity(): BaseActivity {
		return activity as BaseActivity
	}
	
	@CallSuper
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		AndroidSupportInjection.inject(this)
		retainInstance = true
		setHasOptionsMenu(true)
	}
	
	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
	                          savedInstanceState: Bundle?): View? {
		return container?.inflate(layoutId())
	}
	
	abstract fun layoutId(): Int
}

fun android.view.ViewGroup.inflate(layoutId: Int): android.view.View {
	return android.view.LayoutInflater.from(context).inflate(layoutId, this, false)
}
