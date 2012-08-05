package net.morodomi.lecture4;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * Activity for Lecture 4
 * In this lecture, you will know abstract of Intent
 * @author Masahiro Morodomi <morodomi at gmail.com>
 */
public class IntentActivity extends Activity implements OnClickListener {
	// URL schemes

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// set OnClickListeners
		findViewById(R.id.sms).setOnClickListener(this);
		findViewById(R.id.tel).setOnClickListener(this);
		findViewById(R.id.http).setOnClickListener(this);
		findViewById(R.id.https).setOnClickListener(this);
	}

	/** Called when views are clicked */
	@Override
	public void onClick(View v) {
		// start activity
		Intent intent = null;
		switch (v.getId()) {
		// sms
		case R.id.sms:
			intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:09011112222"));
			break;
		// telephone
		case R.id.tel:
			intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:09011112222"));
			break;
		// browser
		case R.id.http:
			intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.yahoo.co.jp"));
			break;
		// browser(https)
		case R.id.https:
			intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.jp"));
			break;
		default:
			break;
		}
		if(intent != null) {
			startActivity(intent);
		}
	}
}