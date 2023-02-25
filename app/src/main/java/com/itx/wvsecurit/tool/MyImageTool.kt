package com.itx.wvsecurit.tool

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.*
import java.util.UUID


class MyImageTool {
    companion object {
        lateinit var context: Context
        fun buildImageBodyPart(fileName: String, bitmap: Bitmap):  MultipartBody.Part {
            val leftImageFile = convertBitmapToFile(fileName, bitmap)
            val reqFile = RequestBody.create("image/*".toMediaTypeOrNull(),    leftImageFile)
            return MultipartBody.Part.createFormData("file", fileName, reqFile)
        }
        fun convertBitmapToFile(fileName: String, bitmap: Bitmap): File {
            //create a file to write bitmap data
            val file = File(context.cacheDir, fileName)
            file.createNewFile()

            //Convert bitmap to byte array
            val bos = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 100 /*ignored for PNG*/, bos)
            val bitMapData = bos.toByteArray()

            //write the bytes in file
            var fos: FileOutputStream? = null
            try {
                fos = FileOutputStream(file)
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            }
            try {
                fos?.write(bitMapData)
                fos?.flush()
                fos?.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return file
        }

        fun decodeSampledBitmapFromFile(
            path: String?,
            reqWidth: Int,
            reqHeight: Int
        ): Bitmap? { // BEST QUALITY MATCH

            //First decode with inJustDecodeBounds=true to check dimensions
            val options = BitmapFactory.Options()
            options.inJustDecodeBounds = true
            BitmapFactory.decodeFile(path, options)

            // Calculate inSampleSize, Raw height and width of image
            val height = options.outHeight
            val width = options.outWidth
            options.inPreferredConfig = Bitmap.Config.RGB_565
            var inSampleSize = 1
            if (height > reqHeight) {
                inSampleSize = Math.round(height.toFloat() / reqHeight.toFloat())
            }
            val expectedWidth = width / inSampleSize
            if (expectedWidth > reqWidth) {
                //if(Math.round((float)width / (float)reqWidth) > inSampleSize) // If bigger SampSize..
                inSampleSize = Math.round(width.toFloat() / reqWidth.toFloat())
            }
            options.inSampleSize = inSampleSize

            // Decode bitmap with inSampleSize set
            options.inJustDecodeBounds = false
            return BitmapFactory.decodeFile(path, options)
        }
    }
}