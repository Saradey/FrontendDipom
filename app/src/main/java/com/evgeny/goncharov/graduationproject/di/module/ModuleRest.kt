package com.evgeny.goncharov.graduationproject.di.module

import com.evgeny.goncharov.graduationproject.rest.RestClient
import com.evgeny.goncharov.graduationproject.rest.api.ArticleApi
import com.evgeny.goncharov.graduationproject.rest.api.UserApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class ModuleRest {

    @Provides
    @Singleton
    fun provideRestClient(): RestClient = RestClient()


    @Provides
    fun provideUserApi(restClient: RestClient):
            UserApi = restClient.createService<UserApi>()

    @Provides
    fun provideArticleApi(restClient: RestClient):
            ArticleApi = restClient.createService<ArticleApi>()

}