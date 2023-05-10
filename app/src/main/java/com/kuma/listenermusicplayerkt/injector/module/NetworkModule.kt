package com.kuma.listenermusicplayerkt.injector.module

import com.kuma.listenermusicplayerkt.Constants
import com.kuma.listenermusicplayerkt.ListenerApp
import com.kuma.listenermusicplayerkt.injector.scope.PerApplication
import com.kuma.listenermusicplayerkt.repository.RepositoryImpl
import com.kuma.listenermusicplayerkt.repository.interfaces.Repository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named

@Module
class NetworkModule(private val mListenerApp: ListenerApp) {

    @Provides
//    @PerApplication
    fun provideRepository(
        @Named("kugou") kugou: Retrofit,
        @Named("lastfm") lastfm: Retrofit?,
        @Named("artistimage") artistimage: Retrofit
    ): Repository? {
        return RepositoryImpl(mListenerApp, artistimage, kugou, lastfm)
    }


    //从构建和代码的角度这下面三个方法都直接写在上面这个方法里面都可以吧？
    @Provides
    @Named("artistimage")
//    @PerApplication
    fun provideArtistImageRetrofit(): Retrofit {
        val endpointUrl = Constants.BASE_API_URL_ARTISTIMAGE

        val retrofit = Retrofit.Builder()
            .baseUrl(endpointUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build()
        return retrofit
    }

    @Provides
    @Named("lastfm")
    @PerApplication
    fun provideLastFMRetrofit(): Retrofit? {
        return null
    }

    @Provides
    @Named("kugou")
    @PerApplication
    fun provideKuGouRetrofit(): Retrofit {
        val endpointUrl = Constants.BASE_API_URL_KUGOU

//        interceptor

        val client = OkHttpClient.Builder()
//            .cache()
            .connectTimeout(
                Constants.HTTP_CONNECT_TIMEOUT.toLong(),
                TimeUnit.MILLISECONDS
            )//为啥java里不用to
            .readTimeout(Constants.HTTP_READ_TIMEOUT.toLong(), TimeUnit.MILLISECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(endpointUrl)
            .client(client)
//            .addConverterFactory()
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()
        return retrofit
    }


//新代码开启的地方，原来用application代替repository当参数传入，应该也没什么作用吧
}