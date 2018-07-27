package bipin.com.android.arch.di.module

import android.app.Application
import android.content.Context
import bipin.com.android.arch.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Bipin Vayalu on 25/07/18.
 */

@Module(includes = [ViewModelModule::class])
class AppModule {


    @Provides
    @Singleton
    fun provideApp(app: Application): App {
        return app as App
    }

    @Provides
    @Singleton
    fun provideContext(app: Application): Context {
            return app
    }

    // Add Other providers as you required
}
