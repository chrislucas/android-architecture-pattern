package arch.xplore.roompersistencelib.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;
import java.util.List;

import arch.xplore.roompersistencelib.R;
import arch.xplore.roompersistencelib.models.User;
import arch.xplore.roompersistencelib.utils.MyDatabaseBuilder;
import arch.xplore.roompersistencelib.viewholders.ViewHolderUser;
import arch.xplore.roompersistencelib.viewholders.recycleviewadapter.RecycleViewAdapterUser;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListUsers.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListUsers#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListUsers extends Fragment {

    private OnFragmentInteractionListener mListener;
    private MyDatabaseBuilder myDatabaseBuilder;
    private RecyclerView recyclerViewUsers;

    public ListUsers() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment ListUsers.
     */
    // TODO: Rename and change types and number of parameters
    public static ListUsers newInstance() {
        return new ListUsers();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_list_users, container, false);
        recyclerViewUsers = layout.findViewById(R.id.list_user);
        Context context = getActivity().getApplicationContext();
        if(context != null) {
            WeakReference<Context> weakReference = new WeakReference<Context>(context);
            myDatabaseBuilder = MyDatabaseBuilder.getInstance(weakReference);
            List<User> users = myDatabaseBuilder.getDatabaseApp().userDao().getAll();
            RecyclerView.Adapter<ViewHolderUser> adapter = new RecycleViewAdapterUser(users);
            recyclerViewUsers.setLayoutManager(new LinearLayoutManager(context));
            recyclerViewUsers.setAdapter(adapter);
        }
        return layout;
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
        }
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
