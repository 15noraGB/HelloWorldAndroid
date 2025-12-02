package noragarcia.helloworld

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShopItem(
    val name: String,
    var quantity: Int = 0 // cantidad inicial 0
) : Parcelable
