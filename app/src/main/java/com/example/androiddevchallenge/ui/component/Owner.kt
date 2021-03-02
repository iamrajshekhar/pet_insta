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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.data.PetModel
import com.example.androiddevchallenge.ui.theme.ownerInfoColor
import com.example.androiddevchallenge.R
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height



@Composable
fun OwnerInfo(pet: PetModel) {
    Row(modifier = Modifier.padding(10.dp)) {
        Row(
            modifier = Modifier
                .background(
                    color = ownerInfoColor,
                    shape = RoundedCornerShape(15.dp)
                )
                .padding(10.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.user_profile),
                    contentDescription = "Profile",
                    contentScale = ContentScale.Inside,
                    modifier = Modifier
                        .size(50.dp)
                        .border(2.dp, Color.Gray, CircleShape)
                )

                Column(
                    modifier = Modifier.padding(5.dp)
                ) {
                    Text(text = pet.owner,style = TextStyle(fontSize = 16.sp, color = MaterialTheme.colors.onSurface))
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(text = "Owner",style = TextStyle(fontSize = 14.sp, color = MaterialTheme.colors.onSurface, fontWeight = FontWeight.Bold))
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(text = pet.location,style = TextStyle(fontSize = 12.sp, color = MaterialTheme.colors.onSurface,fontWeight = FontWeight.Light))
                }
            }

        }
    }

}
