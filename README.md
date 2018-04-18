
# ViewPagerDSL
DSL for ViewPager and FragmentPagerAdapter in Kotlin

[![](https://jitpack.io/v/mhashim6/ViewPagerDSL.svg)](https://jitpack.io/#mhashim6/ViewPagerDSL)
## Usage:
```kotlin
viewPager.apply {
	fragmentPagerAdapter(pageCount = 3, fragmentManager = supportFragmentManager) {
		createItems { position ->
			when (position) {
				0 -> InputFragment()
				1 -> OutputFragment()
				2 -> AboutFragment()
				else -> throw Exception("¯\\_(ツ)_/¯")
			}
		}
	}
	onPageSelected { position ->
		//nice moves goes here.
	}
	clipToPadding = false
	offscreenPageLimit = 2
}
```
## Dependency:
Add it in your root build.gradle at the end of repositories:

```groovy
allprojects {
    repositories {
    ...
    maven { url 'https://jitpack.io' }
    }
}
```
Add the dependency:
```groovy
dependencies {
	compile 'com.github.mhashim6:ViewPagerDSL:1.0.0'
}
```