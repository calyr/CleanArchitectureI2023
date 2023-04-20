package com.ucb.livedataexample.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UseCaseModule::class, DataModule::class, AppModule::class])
interface AppComponent {
}