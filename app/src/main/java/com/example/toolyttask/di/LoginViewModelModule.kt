package com.example.toolyttask.di

import com.example.toolyttask.domain.repository.LoginRepository
import com.example.toolyttask.presentation.LoginViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object LoginViewModelModule {

    @Provides
    fun provideLoginViewModel(loginRepository: LoginRepository): LoginViewModel {
        return LoginViewModel(loginRepository)

    }

}