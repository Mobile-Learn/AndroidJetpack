package nam.tran.android.helper.view

import androidx.appcompat.app.AppCompatActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import nam.tran.android.helper.view.comic.ComicFragment
import nam.tran.android.helper.view.comic.ComicFragmentModule
import nam.tran.android.helper.view.detail.DetailComicFragment
import nam.tran.android.helper.view.detail.DetailComicFragmentModule
import nam.tran.android.helper.view.local.ComicLocalFragment
import nam.tran.android.helper.view.local.ComicLocalFragmentModule
import nam.tran.android.helper.view.login.LoginFragment
import nam.tran.android.helper.view.login.LoginFragmentModule
import nam.tran.android.helper.view.register.RegisterFragment
import nam.tran.android.helper.view.register.RegisterFragmentModule
import nam.tran.android.helper.view.splash.SplashFragment
import nam.tran.android.helper.view.splash.SplashFragmentModule
import tran.nam.core.di.inject.PerActivity
import tran.nam.core.di.inject.PerFragment

/**
 * Provides main activity dependencies.
 */
@Module
abstract class MainActivityModule {

    /**
     * Provides the injector for the [SplashFragmentModule], which has access to the dependencies
     * provided by this application instance (singleton scoped objects).
     */
    @PerFragment
    @ContributesAndroidInjector(modules = [SplashFragmentModule::class])
    internal abstract fun injectorSplashFragment(): SplashFragment

    /**
     * Provides the injector for the [LoginFragmentModule], which has access to the dependencies
     * provided by this application instance (singleton scoped objects).
     */
    @PerFragment
    @ContributesAndroidInjector(modules = [LoginFragmentModule::class])
    internal abstract fun injectorLoginFragment(): LoginFragment

    /**
     * Provides the injector for the [RegisterFragmentModule], which has access to the dependencies
     * provided by this application instance (singleton scoped objects).
     */
    @PerFragment
    @ContributesAndroidInjector(modules = [RegisterFragmentModule::class])
    internal abstract fun injectorRegisterFragment(): RegisterFragment

    /**
     * Provides the injector for the [ComicFragmentModule], which has access to the dependencies
     * provided by this application instance (singleton scoped objects).
     */
    @PerFragment
    @ContributesAndroidInjector(modules = [ComicFragmentModule::class])
    internal abstract fun injectorHomeFragment(): ComicFragment

    /**
     * Provides the injector for the [ComicLocalFragmentModule], which has access to the dependencies
     * provided by this application instance (singleton scoped objects).
     */
    @PerFragment
    @ContributesAndroidInjector(modules = [ComicLocalFragmentModule::class])
    internal abstract fun injectorComicLocalFragment(): ComicLocalFragment

    /**
     * Provides the injector for the [DetailComicFragmentModule], which has access to the dependencies
     * provided by this application instance (singleton scoped objects).
     */
    @PerFragment
    @ContributesAndroidInjector(modules = [DetailComicFragmentModule::class])
    internal abstract fun injectorDetailComicFragment(): DetailComicFragment

    @Binds
    @PerActivity
    internal abstract fun activity(activity: MainActivity): AppCompatActivity
}
