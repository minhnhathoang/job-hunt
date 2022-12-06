package com.nhathm.jobhunt.common

import android.app.Activity
import com.nhathm.jobhunt.App

val Activity.customApplication: App
get() = application as App