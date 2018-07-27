package bipin.com.android.arch.base

import android.arch.lifecycle.ViewModel
import android.databinding.Bindable
import android.databinding.Observable
import android.databinding.PropertyChangeRegistry

abstract class BaseViewModel : ViewModel(), Observable {
	
	@Transient
	private var transientCallbacks: PropertyChangeRegistry? = null
	
	override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback) {
		synchronized(this) {
			if (transientCallbacks == null) {
				transientCallbacks = PropertyChangeRegistry()
			}
		}
		transientCallbacks!!.add(callback)
	}
	
	override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback) {
		synchronized(this) {
			if (transientCallbacks == null) {
				return
			}
		}
		transientCallbacks!!.remove(callback)
	}
	
	/**
	 * Notifies listeners that all properties of this instance have changed.
	 */
	fun notifyChange() {
		synchronized(this) {
			if (transientCallbacks == null) {
				return
			}
		}
		transientCallbacks!!.notifyCallbacks(this, 0, null)
	}
	
	/**
	 * Notifies listeners that a specific property has changed. The getter for the property
	 * that changes should be marked with [Bindable] to generate a field in
	 * `BR` to be used as `fieldId`.
	 
	 * @param fieldId The generated BR id for the Bindable field.
	 */
	fun notifyPropertyChanged(fieldId: Int) {
		synchronized(this) {
			if (transientCallbacks == null) {
				return
			}
		}
		transientCallbacks!!.notifyCallbacks(this, fieldId, null)
	}
}
