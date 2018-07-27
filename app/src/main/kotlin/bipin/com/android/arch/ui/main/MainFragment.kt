package bipin.com.android.arch.ui.main

import android.os.Bundle
import android.view.View
import bipin.com.android.arch.R
import bipin.com.android.arch.base.BaseBindingFragment
import bipin.com.android.arch.databinding.MainFragmentBinding
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Bipin Vayalu on 26/07/18.
 */

class MainFragment : BaseBindingFragment<MainFragmentBinding>() {


    @Inject
    lateinit var mainViewModel: MainViewModel

    private val compositeDisposable = CompositeDisposable()


    override fun layoutId() = R.layout.main_fragment

    override fun initializeBinding(binding: MainFragmentBinding) {
        binding.viewModel = mainViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel.randomLabelObservable.subscribe {
            binding.get()?.helloWorld?.text = it
        }
    }

}
