package ca.qc.cstj.s05localdatasource.core

import android.widget.ImageView

fun ImageView.loadFromResource(imageName: String) {
    val imageId = this.resources.getIdentifier(imageName, "drawable", context.packageName)

    this.setImageResource(imageId)
}