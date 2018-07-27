package bipin.com.android.arch.ui.main


import android.os.Bundle
import bipin.com.android.arch.R
import bipin.com.android.arch.base.BaseActivity

/**
 * Created by Bipin Vayalu on 25/07/18.
 */


class MainActivity : BaseActivity(){


    override fun layoutId() = R.layout.activity_main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addFragment(supportFragmentManager, MainFragment())

    }
}
