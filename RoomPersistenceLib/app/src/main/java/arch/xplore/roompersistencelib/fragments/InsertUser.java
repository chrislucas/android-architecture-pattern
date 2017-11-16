package arch.xplore.roompersistencelib.fragments;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.Locale;

import arch.xplore.roompersistencelib.R;
import arch.xplore.roompersistencelib.daos.UserDao;
import arch.xplore.roompersistencelib.db.DatabaseApp;
import arch.xplore.roompersistencelib.enums.TypeUser;
import arch.xplore.roompersistencelib.models.User;
import arch.xplore.roompersistencelib.utils.MyDatabaseBuilder;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InsertUser.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link InsertUser#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InsertUser extends Fragment {
    private OnFragmentInteractionListener mListener;
    private MyDatabaseBuilder myDatabaseBuilder;
    private EditText userName, userRegister;
    private TypeUser typeUser = TypeUser.TECHNICIAN;


    public InsertUser() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment InsertUser.
     */
    // TODO: Rename and change types and number of parameters
    public static InsertUser newInstance() {
        return new InsertUser();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_insert_user, container, false);
        /**
         * Para esse exemplo nao vou usar databinding e pronto !!! Estou estudando Room Persistence Library
         * nao me julguem ><
         * */
        userName        = layout.findViewById(R.id.input_user_name);
        userRegister    = layout.findViewById(R.id.input_user_register);
        Spinner spinnerTypeUser = layout.findViewById(R.id.spinner_type_user);
        spinnerTypeUser.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                typeUser = TypeUser.getType(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button save = layout.findViewById(R.id.button_save_user);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUser(v);
            }
        });
        Context context = getActivity().getApplicationContext();
        if(context != null) {
            WeakReference<Context> weakReference = new WeakReference<Context>(getContext());
            myDatabaseBuilder = MyDatabaseBuilder.getInstance(weakReference);
        }
        return layout;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public void onButtonPressed() {
        if (mListener != null) {
            mListener.onFragmentInteraction();
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
        void onFragmentInteraction();
    }


    public void saveUser(View view) {
        Toast.makeText(getContext(), "User saved", Toast.LENGTH_LONG).show();
        DatabaseApp databaseApp = myDatabaseBuilder.getDatabaseApp();
        String strUserName      = userName.getText().toString();
        String strUserRegister  = userRegister.getText().toString();
        User user = new User();
        user.setName(strUserName);
        user.setRegister(strUserRegister);
        user.setTypeUser(typeUser);
        user.setToken("asd65465a4seqsdasd654a6s5433248");
        long id = databaseApp.userDao().insert(user);
        Toast.makeText(getContext()
                , String.format(Locale.getDefault(), "Usuário %d inserido", id)
                , Toast.LENGTH_LONG).show();
    }
}
