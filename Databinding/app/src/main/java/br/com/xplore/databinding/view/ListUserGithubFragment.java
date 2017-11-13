package br.com.xplore.databinding.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.xplore.databinding.R;
import br.com.xplore.databinding.adapter.AdapterUserGithub;
import br.com.xplore.databinding.adapter.holder.ViewHolderUsergithub;
import br.com.xplore.databinding.databinding.FragmentListUserGithubBinding;
import br.com.xplore.databinding.model.User;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListUserGithubFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListUserGithubFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListUserGithubFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public ListUserGithubFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ListUserGithubFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListUserGithubFragment newInstance() {
        ListUserGithubFragment fragment = new ListUserGithubFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_user_github, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.list_user_github);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        List<User> users = null;


        RecyclerView.Adapter<ViewHolderUsergithub> adapter = new AdapterUserGithub(users);

        FragmentListUserGithubBinding fragmentListBinding = DataBindingUtil.inflate(getLayoutInflater()
                ,  R.layout.fragment_list_user_github, container, false);


        RecyclerView.ViewHolder viewHolder = new ViewHolderUsergithub(fragmentListBinding);

        recyclerView.setAdapter(adapter);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {}
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
