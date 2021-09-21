package br.com.emdev.shoppinglist.extensions

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

fun <T : ViewDataBinding> ViewGroup.bind(@LayoutRes layoutRes: Int): T {
    return DataBindingUtil.inflate(
        LayoutInflater.from(this.context),
        layoutRes, this, false
    )
}

fun <T : ViewDataBinding> Fragment.bind(@LayoutRes layoutRes: Int): T {
    return DataBindingUtil.inflate(
        LayoutInflater.from(this.requireContext()),
        layoutRes, null, false
    )
}

fun <T : ViewDataBinding> Activity.contentView(@LayoutRes layoutRes: Int): T {
    return DataBindingUtil.setContentView(this, layoutRes)
}