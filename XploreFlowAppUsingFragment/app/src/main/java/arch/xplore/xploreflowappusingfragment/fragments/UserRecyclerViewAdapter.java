package arch.xplore.xploreflowappusingfragment.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import arch.xplore.xploreflowappusingfragment.R;
import arch.xplore.xploreflowappusingfragment.fragments.ListUserFragment.OnListFragmentInteractionListener;
import arch.xplore.xploreflowappusingfragment.models.User;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link User} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class UserRecyclerViewAdapter extends RecyclerView.Adapter<UserRecyclerViewAdapter.ViewHolder> {

    private final List<User> users;
    private final OnListFragmentInteractionListener mListener;

    public UserRecyclerViewAdapter(List<User> items, OnListFragmentInteractionListener listener) {
        users = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_viewholder_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        User user= users.get(position);
        mListener.onListFragmentInteraction(user);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View view) {
            super(view);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
