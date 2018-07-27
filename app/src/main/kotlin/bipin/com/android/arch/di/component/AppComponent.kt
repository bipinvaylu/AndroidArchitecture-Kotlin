package bipin.com.android.arch.di.component

import android.app.Application
import bipin.com.android.arch.App
import bipin.com.android.arch.di.module.ActivityBuilderModule
import bipin.com.android.arch.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


/**
 * Created by Bipin Vayalu on 25/07/18.
 */
// When AppComponent is build with its modules,
// we have a graph with all provided instances in our graph.

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityBuilderModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent

    }

    fun inject(app: App)

}
