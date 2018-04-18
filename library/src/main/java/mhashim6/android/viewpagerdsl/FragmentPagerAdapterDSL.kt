package mhashim6.android.viewpagerdsl

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager

/**
 * Created by mhashim6 on 18/04/2018.
 */
class FragmentPagerAdapterDSL(var pageCount: Int = 0, fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

	private lateinit var _onCreateItem: (position: Int) -> Fragment

	fun createItems(action: (position: Int) -> Fragment) {
		_onCreateItem = action
	}

	override fun getItem(position: Int) = _onCreateItem.invoke(position)
	override fun getCount() = pageCount
}

//Extensions

inline fun ViewPager.fragmentPagerAdapter(pageCount: Int, fragmentManager: FragmentManager, block: FragmentPagerAdapterDSL.() -> Unit) {
	adapter = FragmentPagerAdapterDSL(pageCount, fragmentManager).apply(block)
}

fun ViewPager.onPageSelected(action: (position: Int) -> Unit) {
	addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
		override fun onPageScrollStateChanged(state: Int) {
		}

		override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
		}

		override fun onPageSelected(position: Int) {
			action.invoke(position)
		}
	})
}