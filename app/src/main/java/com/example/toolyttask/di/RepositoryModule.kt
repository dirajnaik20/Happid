package com.example.toolyttask.di

import com.example.toolyttask.data.repository.LoginRepositoryImpl
import com.example.toolyttask.domain.repository.LoginRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindWallpaperRepository(
        loginRepositoryImpl: LoginRepositoryImpl
    ): LoginRepository
}