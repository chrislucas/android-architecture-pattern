package br.com.xplore.databinding.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import br.com.xplore.databinding.R;


/**
 * Essa classe não tem nada a ver com o estudo nesse projeto. So estou fazendo um teste para
 * chamar a aplicação do telefone
 *
 */

public class CallPhone extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_phone);
    }

    public void openPhone(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        startActivity(intent);
    }

    public void makeCall(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:551146470409"));
        startActivity(intent);
    }
}
