package de.deliveryhero.mailordercoffeeshop.order.beveragesmenu

import de.deliveryhero.mailordercoffeeshop.R

fun getCupVolumeDrawableResource(volume: Int): Int {
    when (volume) {
        in 0..60 -> return R.drawable.ic_cup_low_volume
        in 61..180 -> return R.drawable.ic_cup_medium_volume
        else -> return R.drawable.ic_cup_full_volume
    }
}
