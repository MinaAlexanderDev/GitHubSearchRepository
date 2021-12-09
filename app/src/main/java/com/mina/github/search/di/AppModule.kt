package com.mina.github.search.di

import com.mina.github.search.api.ServiceAPI
import com.mina.github.search.data.localdata.jsondata.JsonExtract
import com.mina.github.search.data.localdata.jsondata.JsonRepository
import com.mina.github.search.data.localdata.jsondata.JsonRepositoryImp
import com.mina.github.search.data.remotedata.RemoteRepository
import com.mina.github.search.data.remotedata.RemoteRepositoryImp
import com.mina.github.search.repository.Repository
import com.mina.github.search.repository.RepositoryImp
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(ServiceAPI.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideUnsplashApi(retrofit: Retrofit): ServiceAPI =
        retrofit.create(ServiceAPI::class.java)

    @Provides
    @Singleton
    fun bindRemoteLocalJson(): JsonExtract = JsonExtract()

    @Module
    @InstallIn(ActivityComponent::class)
    abstract class JsonExtractDatModule {

        @Binds
        abstract fun bindJsonExtractData(
            jsonExtractDataImp: JsonRepositoryImp
        ): JsonRepository
    }

    @Module
    @InstallIn(ActivityComponent::class)
    abstract class RemoteRepositoryModule {

        @Binds
        abstract fun bindRemoteRepository(
            remoteRepositoryImp: RemoteRepositoryImp
        ): RemoteRepository
    }

    @Module
    @InstallIn(ActivityComponent::class)
    abstract class RemoteAllRepository {

        @Binds
        abstract fun bindAllRepository(
            RepositoryImp: RepositoryImp
        ): Repository
    }


}