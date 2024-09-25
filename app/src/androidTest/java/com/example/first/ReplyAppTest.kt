package com.example.first

import androidx.activity.ComponentActivity
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.first.test.TestCompactWidth
import com.example.first.test.TestExpandedWidth
import com.example.first.test.TestMediumWidth
import com.example.first.test.onNodeWithStringId
import com.example.first.ui.ReplyApp
import org.junit.Rule
import org.junit.Test

/**
 * @className: first
 * @desc:
 * @version:
 * @author: blossom
 * @email:
 * @date: 2024/9/25 01:28 Wed
 * @copyright: Copyright (c) 2024 Yxy Inc. All Rights Reserved.
 */
class ReplyAppTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Composable
    @Test
    @TestCompactWidth
    fun compactDevice_verifyUsingBottomNavigation() {
        // Set up compact window
        composeTestRule.setContent {
            ReplyApp(
                windowSize = WindowWidthSizeClass.Compact
            )
        }
        // Bottom navigation is displayed
//        composeTestRule.onNodeWithTagForStringId(
        composeTestRule.onNodeWithStringId(
            R.string.navigation_bottom
        ).assertExists()
    }
    @Test
    @TestMediumWidth
    fun mediumDevice_verifyUsingNavigationRail() {
        // Set up medium window
        composeTestRule.setContent {
            ReplyApp(
                windowSize = WindowWidthSizeClass.Medium
            )
        }
        // Navigation rail is displayed
//        composeTestRule.onNodeWithTagForStringId(
        composeTestRule.onNodeWithStringId(
            R.string.navigation_rail
        ).assertExists()
    }
    @Test
    @TestExpandedWidth
    fun expandedDevice_verifyUsingNavigationDrawer() {
        // Set up expanded window
        composeTestRule.setContent {
            ReplyApp(
                windowSize = WindowWidthSizeClass.Expanded
            )
        }
        // Navigation drawer is displayed
//        composeTestRule.onNodeWithTagForStringId(
        composeTestRule.onNodeWithStringId(
            R.string.navigation_drawer
        ).assertExists()
    }
}