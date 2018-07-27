package bipin.com.android.arch.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import bipin.com.android.arch.di.ViewModelFactory
import bipin.com.android.arch.di.ViewModelKey
import bipin.com.android.arch.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Bipin Vayalu on 26/07/18.
 */

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindsViewModelFactory(
        viewModelFactory: ViewModelFactory
    ): ViewModelProvider.Factory


    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

}
