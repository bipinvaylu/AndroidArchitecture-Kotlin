package bipin.com.android.arch.ui.main

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Bipin Vayalu on 25/07/18.
 */

@Module
abstract class MainActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun bindMainFragment(): MainFragment
}
