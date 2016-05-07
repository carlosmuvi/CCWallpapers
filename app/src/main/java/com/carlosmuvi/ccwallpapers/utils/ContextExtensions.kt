import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast

inline fun <reified T : Activity> Activity.navigate(id: String, sharedView: View? = null,
    transitionName: String? = null) {
    val intent = Intent(this, T::class.java)
    intent.putExtra("id", id)

    var options: ActivityOptionsCompat? = null

    if (sharedView != null && transitionName != null) {
        options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, sharedView, transitionName)
    }

    ActivityCompat.startActivity(this, intent, options?.toBundle())
}

fun Activity.getNavigationId(): String {
    val intent = intent
    return intent.getStringExtra("id")
}

fun Context.getDimen(dimenRes: Int): Int {
    return resources.getDimensionPixelSize(dimenRes)
}

fun Context.getAttrId(themeRes: Int, attrRes: Int): Int {
    val a = theme.obtainStyledAttributes(themeRes, intArrayOf(attrRes));
    val attributeResourceId = a.getResourceId(0, 0);
    a.recycle()
    return attributeResourceId
}

fun Context.alert(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun RecyclerView.onScroll(callback: () -> Unit) {
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
            callback.invoke()
        }

    })
}

