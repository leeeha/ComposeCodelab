/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.opensource.composecodelab.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.opensource.composecodelab.R
import com.google.opensource.composecodelab.data.Email
import com.google.opensource.composecodelab.data.LocalAccountsDataProvider
import com.google.opensource.composecodelab.ui.theme.ComposeCodelabTheme

@Composable
fun ReplyEmailThreadItem(
    email: Email,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = MaterialTheme.shapes.medium
            )
            .padding(16.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            ReplyProfileImage(
                drawableResource = email.sender.avatar,
                description = email.sender.fullName,
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 12.dp, vertical = 4.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = email.sender.firstName,
                    style = MaterialTheme.typography.labelMedium
                )
                Text(
                    text = stringResource(id = R.string.twenty_mins_ago),
                    style = MaterialTheme.typography.labelMedium
                )
            }
            IconButton(
                onClick = { /*Click Implementation*/ },
                modifier = Modifier
                    .clip(CircleShape)
            ) {
                Icon(
                    imageVector = if (email.isStarred) Icons.Default.Star else Icons.Default.StarBorder,
                    contentDescription = stringResource(id = R.string.description_favorite),
                    tint = if (email.isStarred) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.outline
                )
            }
        }

        Text(
            text = email.subject,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 12.dp, bottom = 8.dp),
        )
        Text(
            text = email.body,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Button(
                onClick = { /*Click Implementation*/ },
                modifier = Modifier.weight(1f),
            ) {
                Text(
                    text = stringResource(id = R.string.reply),
                )
            }
            Button(
                onClick = { /*Click Implementation*/ },
                modifier = Modifier.weight(1f),
            ) {
                Text(
                    text = stringResource(id = R.string.reply_all),
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0x15f9f5)
@Composable
private fun ReplyEmailThreadItemPreview() {
    ComposeCodelabTheme {
        ReplyEmailThreadItem(
            email = Email(
                id = 5L,
                sender = LocalAccountsDataProvider.getContactAccountByUid(13L),
                recipients = listOf(LocalAccountsDataProvider.getDefaultUserAccount()),
                subject = "Update to Your Itinerary",
                body = "ㅎㅎㅎ",
                createdAt = "2 hours ago"
            ),
        )
    }
}