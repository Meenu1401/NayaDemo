import android.content.Context
import android.text.TextUtils
import android.view.View
import android.webkit.URLUtil
import android.widget.AdapterView
import androidx.lifecycle.ViewModel


/**
 * @author Ankit Jindal
 */
class TrendingListViewModel : ViewModel(), AdapterView.OnItemClickListener {

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }

    private var mContext: Context? = null


    override fun onCleared() {
        super.onCleared()
        mContext = null
    }
}