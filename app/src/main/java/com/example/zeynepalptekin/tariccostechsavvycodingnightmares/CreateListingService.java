package com.example.zeynepalptekin.tariccostechsavvycodingnightmares;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CreateListingService extends AppCompatActivity {
    public static final int PICK_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_listing_service);

        Button backToMain = findViewById(R.id.backToMain7);
        backToMain.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                backToMain();
            }
        });

        Button addImage = findViewById(R.id.addImageButton1);
        addImage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                backToMain();
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

//        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {
//
//            Uri uri = data.getData();
//
//            try {
//                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
//                // Log.d(TAG, String.valueOf(bitmap));
//
//                ImageView imageView = (ImageView) findViewById(R.id.imageView);
//                imageView.setImageBitmap(bitmap);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    Account a;
    //TODO: this is just a placeholder variable. Not linked to anything
    public Listing createServiceListing(Account owner, String description, double cost){
        Listing serviceL = new Listing(owner, description, cost);
        String str;
        EditText text;

        owner = FirstScreen.Accounts.get(a.getEmail());

        text = findViewById(R.id.titleText1);
        String title = serviceL.getTitle();
        TextView titleLabel = (TextView)findViewById(R.id.titleText1);
        titleLabel.setText(title);

        text = findViewById(R.id.priceText1);
        str = text.getText().toString();
        serviceL.setCost(Double.parseDouble(str));

        text = findViewById(R.id.descriptionText2);
        str = text.getText().toString();
        serviceL.setDescription(str);

        return serviceL;
    }

    public void backToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void addImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
    }
}