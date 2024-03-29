package com.the3rdwheel.breeze.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.the3rdwheel.breeze.BreezeApp
import com.the3rdwheel.breeze.adapters.PostAdapter
import com.the3rdwheel.breeze.databinding.PostsFragmentBinding
import com.the3rdwheel.breeze.network.NetworkAssistance
import com.the3rdwheel.breeze.network.NetworkState
import com.the3rdwheel.breeze.reddit.api.RedditApi
import com.the3rdwheel.breeze.viewmodel.CommunicationViewModel
import com.the3rdwheel.breeze.viewmodel.PostViewModel
import javax.inject.Inject

const val topPosition = 0

class PostsFragment : Fragment(), NetworkAssistance {

    @Inject
    lateinit var redditApi: RedditApi

    private var hasPost = false
    private var _binding: PostsFragmentBinding? = null
    private val binding: PostsFragmentBinding get() = _binding!!

    private lateinit var postViewModel: PostViewModel
    private lateinit var mAdapter: PostAdapter
    private val sharedViewModel: CommunicationViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PostsFragmentBinding.inflate(inflater, container, false)

        (requireActivity().application as BreezeApp).getAppComponent().inject(this)
        mAdapter = PostAdapter(this, requireContext())
        binding.postSwipeRefresh.setOnRefreshListener(this::refresh)

        postViewModel =
            ViewModelProvider(this, PostViewModel.Factory(redditApi)).get(PostViewModel::class.java)
        binding.postRecyclerview.apply {
            adapter = mAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        sharedViewModel.getPostFragmentReselected().observe(viewLifecycleOwner, Observer {
            if (it) {
                binding.postRecyclerview.scrollToPosition(topPosition)
            }
        })
    }


    private fun observeViewModel() {

        postViewModel.getPosts().observe(viewLifecycleOwner, Observer {
            mAdapter.submitList(it)

        })

        postViewModel.initialLoadData.observe(viewLifecycleOwner, Observer {
            when (it) {
                NetworkState.SUCCESS -> {
                    binding.postSwipeRefresh.isRefreshing = false
                    binding.redditNotAvailable.visibility =
                        View.GONE //added don't know if adding this will remove has posts
                }
                NetworkState.FAILED -> {
                    binding.postSwipeRefresh.isRefreshing = false
                    binding.redditNotAvailable.setOnClickListener { refresh() }
                    showError()
                }
                else -> {
                    binding.postSwipeRefresh.isRefreshing = true
                    binding.redditNotAvailable.visibility =
                        View.GONE //added don't know if adding this will remove has posts
                }
            }
        })


//        postViewModel.hasPostLiveData.observe(viewLifecycleOwner, Observer {
//            this.hasPost = it
//            binding.postSwipeRefresh.isRefreshing = false
//            if (it) {
//                binding.redditNotAvailable.visibility = View.GONE
//            } else {
//                binding.redditNotAvailable.setOnClickListener { }
//                // showError() idk maybe no needed
//            }
//        })

        postViewModel.networkState.observe(viewLifecycleOwner, Observer {
            mAdapter.updateNetworkState(it)
        })
    }

    private fun showError() {
        binding.postSwipeRefresh.isRefreshing = false
        binding.redditNotAvailable.visibility = View.VISIBLE
    }


    private fun refresh() {
        mAdapter.removeFooter()
        binding.redditNotAvailable.visibility = View.GONE
        hasPost = false
        postViewModel.refresh()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun retryLoadingMore() {
        postViewModel.retryLoadingPosts()
    }


}


