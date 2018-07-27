package bipin.com.android.arch.di.module

import bipin.com.android.arch.ui.detail.DetailActivity
import bipin.com.android.arch.ui.detail.DetailActivityBuilderModule
import bipin.com.android.arch.ui.main.MainActivity
import bipin.com.android.arch.ui.main.MainActivityBuilderModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Bipin Vayalu on 25/07/18.
 */

@Module
abstract class ActivityBuilderModule {


    @ContributesAndroidInjector(modules = [MainActivityBuilderModule::class])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [DetailActivityBuilderModule::class])
    abstract fun bindDetailActivity(): DetailActivity

}
