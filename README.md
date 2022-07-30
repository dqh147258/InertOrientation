# InertOrientation
get Android phone orientation when activity is portrait or landscape

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
- 0 -> 0°
- 1 -> 90°
- 2 -> 180°
- 3 -> 270°