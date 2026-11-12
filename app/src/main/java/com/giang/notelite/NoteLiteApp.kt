package com.giang.notelite

import android.app.Application
import com.giang.notelite.di.AppContainer

/** Application sống suốt vòng đời app -> nơi hợp lý để giữ AppContainer. */
class NoteLiteApp : Application() {
    lateinit var container: AppContainer
        private set

    override fun onCreate() {
        super.onCreate()
        container = AppContainer(this)
    }
}
