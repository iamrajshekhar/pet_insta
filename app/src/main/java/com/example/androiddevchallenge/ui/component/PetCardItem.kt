/*
 * Copyright 2021 The Android Open Source Project
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
package com.example.androiddevchallenge.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.PetModel
import com.example.androiddevchallenge.ui.theme.GreyBorder
import com.example.androiddevchallenge.ui.theme.heartLikeColor

@Composable
fun PetCardItem(petInfo: PetModel, navigateToDetailsScreen: (PetModel) -> Unit) {
    val heartIcon =
        if (petInfo.isLiked) R.drawable.ic_heart_active else R.drawable.ic_heart_inactive
    Box(modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 15.dp).border(width = 1.dp, color = GreyBorder, shape = RoundedCornerShape(10.dp))) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(color = MaterialTheme.colors.background)
                .clickable {

                    navigateToDetailsScreen.invoke(petInfo)
                }

        ) {

            petInfo.picture.let {
                val image = loadImageFromUrl(url = it, defaultImage = R.drawable.ic_pet).value
                image?.let { bmp ->
                    Image(
                        modifier = Modifier
                            .width(110.dp)
                            .height(110.dp)
                            .clip(RoundedCornerShape(10.dp)),
                        alignment = Alignment.Center,
                        bitmap = bmp.asImageBitmap(),
                        contentScale = ContentScale.Crop,
                        contentDescription = ""
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
                    .padding(10.dp)
            ) {
                Column {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            petInfo.name,
                            style = MaterialTheme.typography.h2.copy(color = MaterialTheme.colors.onPrimary)
                        )

                        IconButton(
                            onClick = {},
                            modifier = Modifier
                                .height(24.dp)
                                .width(24.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = heartIcon),
                                contentDescription = "",
                                tint = heartLikeColor
                            )
                        }
                    }
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        petInfo.breedName,
                        style = MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.onPrimary),
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_location),
                            tint = MaterialTheme.colors.onPrimary,
                            contentDescription = "",
                            modifier = Modifier
                                .height(24.dp)
                                .width(24.dp)
                        )
                        Text(
                            petInfo.location,
                            style = MaterialTheme.typography.subtitle2.copy(color = MaterialTheme.colors.onPrimary),
                        )
                    }
                }
            }
        }
    }
}
