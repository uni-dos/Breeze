package com.the3rdwheel.breeze.reddit.models.data.children.postdata.awards

import com.squareup.moshi.Json

data class Award(@Json(name = "icon_url") val icon_url: String)



