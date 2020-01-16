/*
 * Copyright 2020 Google LLC
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

package androidx.camera.activity.example

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.activity.PhotoActivity
import coil.api.load
import kotlinx.android.synthetic.main.activity_main.photo_view
import kotlinx.android.synthetic.main.activity_main.take_photo
import kotlinx.android.synthetic.main.activity_main.take_photo_overlay
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        take_photo.setOnClickListener {
            startActivityForResult(
                Intent(this, PhotoActivity::class.java),
                PHOTO_REQUEST_CODE)
        }

        take_photo_overlay.setOnClickListener {
            startActivityForResult(Intent(this, PhotoActivity::class.java).apply {
                putExtra(PhotoActivity.VIEW_FINDER_OVERLAY, R.layout.camera_overlay_square)
            }, PHOTO_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PHOTO_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val photoUri = data?.extras?.get(PhotoActivity.IMAGE_URI) as Uri?
            photoUri?.let { photo_view.load(it) }
        }
    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
        private val PHOTO_REQUEST_CODE = Random.nextInt(0, 10000)
    }
}
