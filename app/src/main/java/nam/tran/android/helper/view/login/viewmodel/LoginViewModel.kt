package nam.tran.android.helper.view.login.viewmodel;

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import nam.tran.domain.entity.state.Resource
import nam.tran.domain.interactor.login.ILoginUseCase
import tran.nam.core.viewmodel.BaseFragmentViewModel
import tran.nam.core.viewmodel.IProgressViewModel
import tran.nam.util.Logger
import javax.inject.Inject

class LoginViewModel @Inject internal constructor(application: Application, private val iLoginUseCase: ILoginUseCase) :
    BaseFragmentViewModel(application),
    IProgressViewModel {

    val results = MutableLiveData<Resource<Void>?>()

    override fun resource(): Resource<Void>? {
        return results.value
    }

    override fun onCreated() {
        results.value = null
    }

    fun login(email: String, password: String) {
        view<ILoginViewModel>()?.let { v ->
            iLoginUseCase.login(email, password).observe(v, Observer {
                Logger.debug("call api")
                results.value = it
            })
        }
    }

}