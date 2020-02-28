package com.the3rdwheel.breeze.reddit

import com.the3rdwheel.breeze.BuildConfig
import okhttp3.Credentials

object RedditUtils {

    const val REDDIT_AUTH_URL = "https://www.reddit.com/api/v1/"
    const val REDDIT_BASE_URL = "https://oauth.reddit.com/"
    val CREDENTIALS = Credentials.basic(BuildConfig.CLIENT_ID, "")
    const val ANONYMOUS_USER = "Anonymous"
    const val ANONYMOUS_KARMA = 0
    const val CURRENT_USER = 1
    const val BREEZE_REDIRECT_URL = "breeze://com.the3rdwheel.breeze/callback"
    const val TOKEN_TYPE = "Bearer"
    const val AUTHORIZATION_KEY = "Authorization"
    const val AUTHORIZATION_BASE = "bearer "
}