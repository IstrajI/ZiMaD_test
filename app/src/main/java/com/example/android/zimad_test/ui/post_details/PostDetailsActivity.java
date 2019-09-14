package com.example.android.zimad_test.ui.post_details;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android.zimad_test.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostDetailsActivity extends AppCompatActivity {
    @BindView(R.id.image)
    ImageView imageImageView;
    @BindView(R.id.number)
    TextView numberTextView;
    @BindView(R.id.text)
    TextView textTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        final Intent intent = getIntent();

        Picasso.get().load(intent.getStringExtra(IMAGE_URL_KEY)).into(imageImageView);
        numberTextView.setText(String.valueOf(intent.getIntExtra(NUMBER_KEY, 0)));
        textTextView.setText(intent.getStringExtra(TEXT_KEY));
    }

    private static final String IMAGE_URL_KEY = "IMAGE_URL_KEY";
    private static final String NUMBER_KEY = "NUMBER_KEY";
    private static final String TEXT_KEY = "TEXT_KEY";

    public static void startDetailsFragmentInstance(final Activity sourceActivity, final String imageUrl, final int number, final String text) {
        final Intent intent = new Intent(sourceActivity, PostDetailsActivity.class);

        intent.putExtra(IMAGE_URL_KEY, imageUrl);
        intent.putExtra(NUMBER_KEY, number);
        intent.putExtra(TEXT_KEY, text);
        sourceActivity.startActivity(intent);
    }
}
