package com.example.otuskmp

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.marginLeft
import org.jetbrains.compose.web.css.marginBottom
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable

fun main() {
    val viewModel = StopwatchViewModel()

    renderComposable(rootElementId = "root") {
        val uiState by viewModel.uiState.collectAsState()

        Div({ style { padding(16.px) } }) {
            Div({ style { fontSize(24.px); marginBottom(16.px) } }) {
                Text(uiState.formattedTime)
            }

            Div {
                Button(attrs = {
                    onClick { viewModel.onStartClicked() }
                }) {
                    Text("Start")
                }

                Button(attrs = {
                    onClick { viewModel.onStopClicked() }
                    style { marginLeft(8.px) }
                }) {
                    Text("Stop")
                }

                Button(attrs = {
                    onClick { viewModel.onCopyClicked() }
                    style { marginLeft(8.px) }
                }) {
                    Text("Copy")
                }
            }
        }
    }
}
