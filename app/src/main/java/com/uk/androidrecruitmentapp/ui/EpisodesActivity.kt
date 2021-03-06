package com.uk.androidrecruitmentapp.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.uk.androidrecruitmentapp.R
import com.uk.androidrecruitmentapp.vm.EpisodesViewModel
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.main_activity.list
import javax.inject.Inject

class EpisodesActivity : DaggerAppCompatActivity() {

   // @Inject
  //  lateinit var service: ApiService

    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory

    private val viewModel: EpisodesViewModel by viewModels { vmFactory }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
      //  ARApplication.apiComponent.inject(this)

      //  initAdapter()
      //  fetchEpisodeFromRemote()
    }

    private fun fetchEpisodeFromRemote() {
//        service.getAllEpisodes()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({
//                    list.adapter = EpisodeAdapter(it)
//                    (list.adapter as EpisodeAdapter).notifyDataSetChanged()
//                }, {})
    }

    private fun initAdapter() {
        list.layoutManager = LinearLayoutManager(this)
    }
}