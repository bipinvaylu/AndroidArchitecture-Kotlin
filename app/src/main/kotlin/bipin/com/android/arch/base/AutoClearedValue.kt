package bipin.com.android.arch.base

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

class AutoClearedValue<out T>(fragment: Fragment, private var value: T?) {
	
	init {
		val fragmentManager = fragment.fragmentManager
		fragmentManager!!.registerFragmentLifecycleCallbacks(
				object : FragmentManager.FragmentLifecycleCallbacks() {
					override fun onFragmentViewDestroyed(fm: FragmentManager?, f: Fragment?) {
						if (f === fragment) {
							this@AutoClearedValue.value = null
							fragmentManager.unregisterFragmentLifecycleCallbacks(this)
						}
					}
				}, false)
	}
	
	fun get(): T? {
		return value
	}
}
