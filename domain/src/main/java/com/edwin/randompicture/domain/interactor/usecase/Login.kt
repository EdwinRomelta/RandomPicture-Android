package com.edwin.randompicture.domain.interactor.usecase

import com.edwin.randompicture.domain.executor.PostExecutionThread
import com.edwin.randompicture.domain.executor.ThreadExecutor
import com.edwin.randompicture.domain.interactor.CompletableUseCase
import com.edwin.randompicture.domain.repository.SessionRepository
import io.reactivex.Completable
import javax.inject.Inject

class Login @Inject constructor(
        private val sessionRepository: SessionRepository,
        threadExecutor: ThreadExecutor,
        postExecutionThread: PostExecutionThread) :
        CompletableUseCase<Login.LoginParam>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: LoginParam): Completable =
            sessionRepository.login(params)

    inner class LoginParam(val email: String,
                           val password: String)
}