package de.deliveryhero.mailordercoffeeshop

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.deliveryhero.mailordercoffeeshop.order.beveragesmenu.MenuFragment
import de.deliveryhero.mailordercoffeeshop.data.beverage.BeverageMenuItem
import de.deliveryhero.mailordercoffeeshop.order.customorder.CustomOrderFragment
import de.deliveryhero.mailordercoffeeshop.onboarding.OnboardingActivity
import de.deliveryhero.mailordercoffeeshop.order.HeaderFragment
import de.deliveryhero.mailordercoffeeshop.orderoverview.OrderOverviewActivity

class MainActivity : AppCompatActivity(), HeaderFragment.OnHeaderSelected, MenuFragment.OnListFragmentInteractionListener {
    override fun onListFragmentInteraction(beverageMenuItem: BeverageMenuItem) {
        val intent = Intent(this, OrderOverviewActivity::class.java)
        intent.putExtra(BeverageMenuItem.PARCEL_NAME, beverageMenuItem)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        // launch the onboarding screen if it is the first launch of the app
        if (isFirstLaunch()) {
            startActivity(Intent(this, OnboardingActivity::class.java))
            finish()
        }

        if (savedInstanceState == null) {
            setUpHeaderFragment()
            setUpCustomOrderFragment()
        }
    }

    private fun isFirstLaunch(): Boolean {
        return SharedPreferencesUtil.isFirstLaunch(applicationContext)
    }

    private fun setUpCustomOrderFragment() {
        var customOrderFragment = supportFragmentManager.findFragmentByTag(CustomOrderFragment.FRAGMENT_TAG)
        if (customOrderFragment == null) {
            customOrderFragment = CustomOrderFragment.newInstance()
        }
        supportFragmentManager.beginTransaction()
                .replace(R.id.order_fragment_container, customOrderFragment, CustomOrderFragment.FRAGMENT_TAG)
                .commit()
    }

    private fun setUpHeaderFragment() {
        var headerFragment = supportFragmentManager.findFragmentByTag(HeaderFragment.FRAGMENT_TAG)
        if (headerFragment == null) {
            headerFragment = HeaderFragment.newInstance()
        }
        supportFragmentManager.beginTransaction()
                .replace(R.id.header_fragment_container, headerFragment, HeaderFragment.FRAGMENT_TAG)
                .commit()
    }

    override fun onMenuSelected() {
        de.deliveryhero.mailordercoffeeshop.Utils.hideKeyboard(this)
        var menuFragment = supportFragmentManager.findFragmentByTag(MenuFragment.FRAGMENT_TAG) as? MenuFragment
        if (menuFragment == null) {
            menuFragment = MenuFragment.newInstance()
        }
        if (!menuFragment.isAdded) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.order_fragment_container, menuFragment, MenuFragment.FRAGMENT_TAG)
                    .addToBackStack(null)
                    .commit()
        }
    }

    override fun onCustomOrderSelected() {
        de.deliveryhero.mailordercoffeeshop.Utils.hideKeyboard(this)
        var customOrderFragment = supportFragmentManager.findFragmentByTag(CustomOrderFragment.FRAGMENT_TAG) as? CustomOrderFragment
        if (customOrderFragment == null) {
            customOrderFragment = CustomOrderFragment.newInstance()
        }
        if (!customOrderFragment.isAdded) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.order_fragment_container, customOrderFragment, CustomOrderFragment.FRAGMENT_TAG)
                    .addToBackStack(null)
                    .commit()
        }
    }
}
