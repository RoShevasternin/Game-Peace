package com.sound.peace

import android.app.Activity
import android.app.Application
import android.content.Context
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.appopen.AppOpenAd
import com.sound.peace.util.log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Date

lateinit var appContext: Context private set

class App: Application() {

    private lateinit var appOpenAdManager: AppOpenAdManager

    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this)
        appContext = applicationContext

        appOpenAdManager = AppOpenAdManager()
        appOpenAdManager.load()
    }

    fun showAdIfAvailable(activity: Activity) {
        appOpenAdManager.showAdIfAvailable(activity)
    }

    private inner class AppOpenAdManager {

        private var appOpenAd: AppOpenAd? = null
        private var isLoadingAd = false

        private var loadTime: Long = 0

        fun load() {
            AppOpenAd.load(
                appContext,
                getString(R.string.ad_app_open_id),
                AdRequest.Builder().build(),
                object : AppOpenAd.AppOpenAdLoadCallback() {
                    override fun onAdLoaded(ad: AppOpenAd) {
                        log("ADS: --- App open ad loaded. ---")

                        appOpenAd = ad
                        isLoadingAd = false
                        loadTime = Date().time
                    }

                    override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                        // Called when an app open ad has failed to load.
                        log("ADS: --- App open ad failed to load with error: " + loadAdError.message + " ---")

                        isLoadingAd = false
                    }
                },
            )
        }

        fun showAdIfAvailable(activity: Activity) {
            appOpenAd?.show(activity)
        }

    }
}