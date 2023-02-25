package com.itx.wvsecurit.ui.view

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.WindowManager.LayoutParams
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.itx.wvsecurit.data.constants.Constants
import com.itx.wvsecurit.data.database.SegNewsRepository
import com.itx.wvsecurit.data.database.entities.SegNewsEntity
import com.itx.wvsecurit.data.network.FileDownloadApiClient
import com.itx.wvsecurit.data.network.SegNewsApiClient
import com.itx.wvsecurit.databinding.ActivityNewsBinding
import com.itx.wvsecurit.tool.AdapterTabPager
import com.itx.wvsecurit.tool.MyDialog
import com.itx.wvsecurit.tool.NewsFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_news.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.awaitResponse
import java.io.ByteArrayOutputStream
import javax.inject.Inject
import kotlin.properties.Delegates


@AndroidEntryPoint
class NewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsBinding

    @Inject lateinit var segNewsRepository: SegNewsRepository
    @Inject lateinit var provideSegNewsApiClient: SegNewsApiClient

    @Inject lateinit var myDialog: MyDialog
    @Inject lateinit var provideFileDownloadApiClient: FileDownloadApiClient

    private var seg_news_type_id by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Toast.makeText(applicationContext, intent.getIntExtra("seg_news_type_id",1).toString() , Toast.LENGTH_LONG).show()
        seg_news_type_id = intent.getIntExtra("seg_news_type_id", 1)

        fillTabs()
    }

    fun generateImageView(id: Int, url: String): ImageView{

        var wv1 = ImageView(this)
        wv1.id = id


        GlobalScope.launch {
            withContext(Dispatchers.IO){
                withContext(Dispatchers.Main){
                    myDialog.show()
                    var response = provideFileDownloadApiClient.get(url.substring(url.lastIndexOf("/")+1)).awaitResponse()
                    val bmp = BitmapFactory.decodeStream(response.body()!!.byteStream())

                    val bos = ByteArrayOutputStream()
                    bmp.compress(Bitmap.CompressFormat.PNG, 10, bos)
                    val bitmapdata = bos.toByteArray()
                    val bitmap = BitmapFactory.decodeByteArray(bitmapdata, 0, bitmapdata.size)

                    wv1.setImageBitmap(bitmap)
                    wv1.scaleType = ImageView.ScaleType.FIT_XY
                    myDialog.dismiss()
                }
            }
        }


        val params = ConstraintLayout.LayoutParams(0,0)
        params.startToStart = binding.viewPager.id
        params.endToEnd = binding.viewPager.id
        params.topToTop = binding.viewPager.id
        params.bottomToBottom = binding.viewPager.id
        params.topMargin = 20
        params.leftMargin = 10
        params.rightMargin = 10
        params.bottomMargin = 10
        params.width = LayoutParams.MATCH_PARENT
        params.height = LayoutParams.MATCH_PARENT

        wv1.layoutParams = params

        return wv1
    }

    fun generateWebViewVideo(id: Int, url: String): VideoView{
        val mediaController = MediaController(this)
        var wv1 = VideoView(this)
        wv1.id = id
        wv1.setMediaController(mediaController)
        wv1.setVideoURI(Uri.parse(url));
        wv1.setZOrderOnTop(true);
        wv1.setOnPreparedListener(MediaPlayer.OnPreparedListener {

        })
        wv1.start()


        val params = ConstraintLayout.LayoutParams(0,0)
        params.startToStart = binding.viewPager.id
        params.endToEnd = binding.viewPager.id
        params.topToTop = binding.viewPager.id
        params.bottomToBottom = binding.viewPager.id
        params.topMargin = 20
        params.leftMargin = 10
        params.rightMargin = 10
        params.bottomMargin = 10
        params.width = LayoutParams.MATCH_PARENT
        params.height = LayoutParams.MATCH_PARENT

        wv1.layoutParams = params

        return wv1
    }

    fun generateWebView(id: Int, url: String): WebView{

        var wv1 = WebView(this)
        wv1.settings.javaScriptEnabled = true
        wv1.settings.setSupportZoom(true)
        wv1.id = id
        wv1.webViewClient = WebViewClient()
        wv1.settings.javaScriptCanOpenWindowsAutomatically = true
        wv1.settings.loadsImagesAutomatically = true
        wv1.settings.loadWithOverviewMode = true
        wv1.settings.useWideViewPort = true
        wv1.settings.domStorageEnabled = true
        wv1.settings.builtInZoomControls = true
        wv1.settings.mediaPlaybackRequiresUserGesture = false
        wv1.settings.loadsImagesAutomatically = true
        wv1.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY

        var userAgent = wv1.settings.userAgentString

        try {
            var androidString = wv1.settings.userAgentString.substring(
                userAgent.indexOf("("),
                userAgent.indexOf(")") + 1
            )
            userAgent = wv1.settings.userAgentString.replace(androidString, "X11; Linux x86_64")
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

        wv1.settings.userAgentString = userAgent
        //wv1.settings.userAgentString = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36"
        //wv1.loadUrl("https://drive.google.com/viewerng/viewer?embedded=true&url=$url")
        //wv1.loadUrl(url)
        wv1.loadUrl("file:///android_asset/pdfviewer.html?$url")


        val params = ConstraintLayout.LayoutParams(0,0)
        params.startToStart = binding.viewPager.id
        params.endToEnd = binding.viewPager.id
        params.topToTop = binding.viewPager.id
        params.bottomToBottom = binding.viewPager.id
        params.topMargin = 20
        params.leftMargin = 10
        params.rightMargin = 10
        params.bottomMargin = 10
        params.width = LayoutParams.MATCH_PARENT
        params.height = LayoutParams.MATCH_PARENT

        wv1.layoutParams = params

        return wv1
    }

    fun fillTabs(){
        var me = this
        GlobalScope.launch {
            withContext(Dispatchers.IO){
                withContext(Dispatchers.Main){
                    myDialog.show()
                    var data = provideSegNewsApiClient.post(SegNewsEntity(null,"S",null, Id_news_type = seg_news_type_id)).awaitResponse()

                    val adapter = AdapterTabPager(me)

                    var id = 1000
                    for(r in data.body()!!.data){
                        var ext = r.image1!!.substring(r.image1.lastIndexOf(".")+1)
                        if(ext.lowercase().equals("mp4")) {
                            adapter.addFragment(
                                NewsFragment(
                                    generateWebViewVideo(
                                        id,
                                        Constants.UPLOADS_URL + "${r.image1}"
                                    )
                                ), r.description!!
                            )
                        }else if (ext.lowercase().equals("pdf")) {
                            adapter.addFragment(
                                NewsFragment(
                                    generateWebView(
                                        id,
                                        Constants.UPLOADS_URL + "${r.image1}"
                                    )
                                ), r.description!!
                            )
                        }else{
                            adapter.addFragment(
                                NewsFragment(
                                    generateImageView(
                                        id,
                                        Constants.UPLOADS_URL + "${r.image1}"
                                    )
                                ), r.description!!
                            )
                        }
                        id++
                    }
                    //adapter.addFragment(NewsFragment(generateWebView(1000, Constants.SITE_URL + "Uploads/1675467892226-12152-29838a43f9dbb9f7.png")), "Category")
                    //adapter.addFragment(NewsFragment(generateWebView(1001, Constants.SITE_URL + "Uploads/1675467911551-12152-8397ccdb86ce2dd6.png")), "Brand")

                    binding.viewPager.adapter = adapter
                    binding.viewPager.currentItem = 0
                    TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
                        tab.text = adapter.getTabTitle(position)
                    }.attach()
                    myDialog.dismiss()
                }
            }
        }

    }
}