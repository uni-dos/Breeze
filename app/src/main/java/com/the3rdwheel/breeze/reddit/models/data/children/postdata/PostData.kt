package com.the3rdwheel.breeze.reddit.models.data.children.postdata


import com.squareup.moshi.Json
import com.the3rdwheel.breeze.reddit.models.data.children.postdata.awards.Award

data class PostData(
    val subreddit: String,
    @Json(name = "selftext") val selfText: String?,
    val saved: Boolean,
    val gilded: Int,
    val clicked: Boolean,
    val title: String,
    val subreddit_name_prefixed: String,
    val hidden: Boolean,
    @Json(name = "downs") val downVotes: Long,
    @Json(name = "hide_score") val isScoreHidden: Boolean,
    @Json(name = "ups") val upVotes: Long,
    @Json(name = "total_awards_received") val rewardsReceived: Int,
    val score: Long,
    val thumbnail: String,
    val edited: Boolean,
    val created: Long,
    @Json(name = "archived") val isArchived: Boolean,
    @Json(name = "pinned") val isPinned: Boolean,
    @Json(name = "over_18") val isAdultContent: Boolean,
    @Json(name = "all_awardings") val awards: List<Award>,
    @Json(name = "spoiler") val isSpoiler: Boolean,
    @Json(name = "locked") val isLocked: Boolean,
    val id: String,
    val author: String,
    @Json(name = "num_comments") val totalPostComments: Long,
    @Json(name = "contest_mode") val isContestMode: Boolean,
    val permalink: String,
    @Json(name = "stickied") val isStickied: Boolean,
    @Json(name = "is_video") val isVideo: Boolean
)

//TODO finish class