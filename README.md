
# ViewPagerDSL
Kotlin DSL for ViewPager and FragmentPagerAdapter

[![](https://jitpack.io/v/mhashim6/ViewPagerDSL.svg)](https://jitpack.io/#mhashim6/ViewPagerDSL)
## Usage:
```kotlin
viewPager.apply {

    fragmentPagerAdapter(pageCount = 3, fragmentManager = supportFragmentManager) {
    
        pages { position ->
            when (position) {
                0 -> InputFragment()
                1 -> OutputFragment()
                2 -> AboutFragment()
                else -> throw Exception("¯\\_(ツ)_/¯")
            }
        }
        
        titles { position ->
            when (position) {
                0 -> "Entries"
                1 -> "Results"
                2 -> "About Us"
                else -> "¯\\_(ツ)_/¯"
        }
    }
    
    onPageSelected { position ->
        //nice moves go here.
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
    implementation 'com.github.mhashim6:ViewPagerDSL:1.0.0'
}
```