package com.edwin.randompicture.ui.di.module

import com.edwin.randompicture.domain.executor.PostExecutionThread
import com.edwin.randompicture.ui.di.scope.PerActivity
import com.edwin.randompicture.ui.di.scope.PerApplication
import com.edwin.randompicture.ui.screen.UiThread
import com.edwin.randompicture.ui.screen.capture.CaptureActivity
import com.edwin.randompicture.ui.screen.main.MainActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module(includes = [ActivityBindingModule::class])
class UiModule {

    @Provides
    @PerApplication
    internal fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread {
        return uiThread
    }
}

@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun contributeMainActivity(): MainActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [CaptureActivityModule::class])
    abstract fun contributeCaptureActivity(): CaptureActivity
}