package com.edwin.randompicture.presentation.model

data class PendingPostView(
        val id: Long,
        val imagePath: String,
        val caption: String,
        val status: Int)