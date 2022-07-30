# InertOrientation
Get Android phone orientation when activity is locked with portrait or landscape

[![](https://www.jitpack.io/v/dqh147258/InertOrientation.svg)](https://www.jitpack.io/#dqh147258/InertOrientation)


## How to use
you can simply use it such as:

```kotlin
class MainActivity : AppCompatActivity() {


    private val listener = SmartInertOrientationListener(this) {
        Log.d("Debug", "current orientation: $it")
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
```


The orientation result value is:
- 0 -> 0° (default portrait)
- 1 -> 90° (right landscape)
- 2 -> 180° (up portrait)
- 3 -> 270° (left landscape)

## Add dependencies

Add it in your root build.gradle at the end of repositories:
```groovy
	allprojects {
		repositories {
			//...
			maven { url 'https://www.jitpack.io' }
		}
	}
```
Add the dependency
```groovy
dependencies {
	        implementation 'com.github.dqh147258:InertOrientation:1.0.+'
	}
```