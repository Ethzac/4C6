package ca.qc.cstj.s05localdatasource.core

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

fun ImageView.loadFromResource(imageName: String) {
    val imageId = this.resources.getIdentifier(imageName, "drawable", context.packageName)

    this.setImageResource(imageId)
}

fun <VH: RecyclerView.ViewHolder> RecyclerView.Adapter<VH>.notifyAllItemChanged() {
    notifyItemRangeChanged(0, itemCount)
}