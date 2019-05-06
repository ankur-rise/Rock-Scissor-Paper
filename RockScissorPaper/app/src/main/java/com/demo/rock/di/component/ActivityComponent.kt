package com.demo.rock.di.component

import com.demo.rock.di.scopes.ActivityScope
import com.demo.rock.ui.view.GameActivity
import com.demo.rock.ui.view.MainActivity
import com.demo.rock.ui.view.ResultActivity
import dagger.Component

@ActivityScope @Component interface ActivityComponent {
    fun inject(activity:MainActivity)
    fun inject(activity:GameActivity)
    fun inject(activity: ResultActivity)
}
