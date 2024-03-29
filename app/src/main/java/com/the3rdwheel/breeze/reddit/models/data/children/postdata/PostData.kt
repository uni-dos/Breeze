package com.the3rdwheel.breeze.reddit.models.data.children.postdata

import com.squareup.moshi.Json
import com.the3rdwheel.breeze.reddit.models.data.children.postdata.awards.Award
import com.the3rdwheel.breeze.reddit.models.data.children.postdata.preview.Preview

data class PostData(
    val subreddit: String,
    @Json(name = "selftext") val selftext: String?,
    val saved: Boolean,
    val gilded: Int,
    val clicked: Boolean,
    val title: String,
    val subreddit_name_prefixed: String,
    val hidden: Boolean,
    @Json(name = "hide_score") val isScoreHidden: Boolean,
    val name: String,
    @Json(name = "total_awards_received") val total_awards_received: Int,
    val score: Long,
    val thumbnail: String,
    val created: Long,
    @Json(name = "archived") val isArchived: Boolean,
    @Json(name = "pinned") val isPinned: Boolean,
    @Json(name = "over_18") val isAdultContent: Boolean,
    val preview: Preview?, //TODO add Image Class
    @Json(name = "all_awardings") val all_awardings: List<Award>?,
    @Json(name = "spoiler") val isSpoiler: Boolean,
    @Json(name = "locked") val isLocked: Boolean,
    @Json(name = "id") val id: String,
    val author: String,
    val num_comments: Long,
    @Json(name = "contest_mode") val isContestMode: Boolean,
    val permalink: String,
    @Json(name = "stickied") val isStickied: Boolean,
    @Json(name = "is_video") val isVideo: Boolean
)
