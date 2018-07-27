package bipin.com.android.arch.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseBindingFragment<B : ViewDataBinding> : BaseFragment() {
	
	private var _binding: AutoClearedValue<B>? = null
	val binding: AutoClearedValue<B>
		get() = _binding!!
	
	final override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
	                                savedInstanceState: Bundle?): View? {
		return inflateView(inflater, container, savedInstanceState)
	}
	
	/**
	 * Use this if your subclass requires to have some sort of hooks into the inflation process of the view
	 */
	open fun inflateView(inflater: LayoutInflater, container: ViewGroup?,
	                     savedInstanceState: Bundle?): View? {
		val databinding: B = DataBindingUtil.inflate(inflater, layoutId(), container, false)!!
		_binding = AutoClearedValue(this, databinding)
		initializeBinding(databinding)
		return databinding.root
	}
	
	/**
	 * Used to not forget to initialize the binding
	 */
	abstract fun initializeBinding(binding: B)
	
}
