package com.sidorov.mypeakscompose.utils.navigation

import android.os.Bundle
import androidx.core.os.bundleOf

fun createExternalRouter(block: (String, Bundle) -> Unit): Router = object : Router {
    override fun routeTo(screen: String, params: Bundle) {
        block.invoke(screen, params)
    }
}

interface Router {
    fun routeTo(screen: String, params: Bundle = bundleOf()) {
        throw NotImplementedError(message = "Router doesn't implemented it for screen $screen with params $params")
    }
}
