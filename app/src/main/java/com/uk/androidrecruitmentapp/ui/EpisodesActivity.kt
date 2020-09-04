package com.uk.androidrecruitmentapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
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
        viewModel.getAllEpisodes()
        viewModel.getAllCharacters()
        viewModel.getAllLocations()
        viewModel.data.observe(this, Observer { episodes ->
            Log.d("TAG", "${episodes.results}")
        })
        viewModel.data2.observe(this, Observer { characters ->
            Log.d("TAG", "${characters.results}")
        })
        viewModel.data3.observe(this, Observer { location ->
            Log.d("TAG", "${location.results}")
        })

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