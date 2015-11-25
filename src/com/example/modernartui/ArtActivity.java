package com.example.modernartui;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

class AlertDialogFragment extends DialogFragment {

	public static AlertDialogFragment newInstance() {
		return new AlertDialogFragment();
	}

	// Build AlertDialog using AlertDialog.Builder
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		return new AlertDialog.Builder(getActivity())
		.setMessage(getResources().getString(R.string.message))

		// User cannot dismiss dialog by hitting back button
		.setCancelable(false)

		// Set up No Button
		.setNegativeButton(getResources().getString(R.string.visit_moma),
				new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog,
					int id) {
				String url = "http://www.moma.org";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
		})

		// Set up Yes Button
		.setPositiveButton(getResources().getString(R.string.not_now),
				new DialogInterface.OnClickListener() {
			public void onClick(
					final DialogInterface dialog, int id) {
				dialog.dismiss();
			}
		}).create();
	}
}

public class ArtActivity extends Activity {
	private SeekBar seekBar;
	private TextView textView1, textView2, textView3, textView5;
	private static final int MORE_INFO_ID = 0;
	private DialogFragment mDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_art);
		seekBar = (SeekBar) findViewById(R.id.seekBar1);
		textView1 = (TextView) findViewById(R.id.textView1);
		textView2 = (TextView) findViewById(R.id.textView2);
		textView3 = (TextView) findViewById(R.id.textView3);
		textView5 = (TextView) findViewById(R.id.textView5);

		seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			int progress = 0;

			@Override
			public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
				progress = progresValue;
				switch(progress) {
				case 0:
					textView1.setBackgroundColor(Color.parseColor("#3762d2"));
					textView2.setBackgroundColor(Color.parseColor("#ee9fe9"));
					textView3.setBackgroundColor(Color.parseColor("#fff68f"));
					textView5.setBackgroundColor(Color.parseColor("#a0db8e"));
					break;
				case 10:
					textView1.setBackgroundColor(Color.parseColor("#97afd4"));
					textView2.setBackgroundColor(Color.parseColor("#f47598"));
					textView3.setBackgroundColor(Color.parseColor("#ffed70"));
					textView5.setBackgroundColor(Color.parseColor("#b5e6c0"));
					break;
				case 20:
					textView1.setBackgroundColor(Color.parseColor("#afd5e1"));
					textView2.setBackgroundColor(Color.parseColor("#f875c2"));
					textView3.setBackgroundColor(Color.parseColor("#ccff00"));
					textView5.setBackgroundColor(Color.parseColor("#9ee874"));
					break;
				case 30:
					textView1.setBackgroundColor(Color.parseColor("#cbf3dd"));
					textView2.setBackgroundColor(Color.parseColor("#ff7373"));
					textView3.setBackgroundColor(Color.parseColor("#9ee874"));
					textView5.setBackgroundColor(Color.parseColor("#1c998e"));
					break;
				case 40:
					textView1.setBackgroundColor(Color.parseColor("#ccfefd"));
					textView2.setBackgroundColor(Color.parseColor("#a14c49"));
					textView3.setBackgroundColor(Color.parseColor("#36fc87"));
					textView5.setBackgroundColor(Color.parseColor("#93b50c"));
					break;
				case 50:
					textView1.setBackgroundColor(Color.parseColor("#1eeecf"));
					textView2.setBackgroundColor(Color.parseColor("#a17849"));
					textView3.setBackgroundColor(Color.parseColor("#10ce59"));
					textView5.setBackgroundColor(Color.parseColor("#fff68f"));
					break;
				case 60:
					textView1.setBackgroundColor(Color.parseColor("#36fc87"));
					textView2.setBackgroundColor(Color.parseColor("#794044"));
					textView3.setBackgroundColor(Color.parseColor("#a0db8e"));
					textView5.setBackgroundColor(Color.parseColor("#ffed70"));
					break;
				case 70:
					textView1.setBackgroundColor(Color.parseColor("#10ce59"));
					textView2.setBackgroundColor(Color.parseColor("#a1499e"));
					textView3.setBackgroundColor(Color.parseColor("#b5e6c0"));
					textView5.setBackgroundColor(Color.parseColor("#9ee874"));
					break;
				case 80:
					textView1.setBackgroundColor(Color.parseColor("#cbf3dd"));
					textView2.setBackgroundColor(Color.parseColor("#7849a1"));
					textView3.setBackgroundColor(Color.parseColor("#b1c3f9"));
					textView5.setBackgroundColor(Color.parseColor("#10ce59"));
					break;
				case 90:
					textView1.setBackgroundColor(Color.parseColor("#ccff00"));
					textView2.setBackgroundColor(Color.parseColor("#3762d2"));
					textView3.setBackgroundColor(Color.parseColor("#b1c3f9"));
					textView5.setBackgroundColor(Color.parseColor("#36fc87"));
					break;
				case 100:
					textView1.setBackgroundColor(Color.parseColor("#000000"));
					textView2.setBackgroundColor(Color.parseColor("#0365b8"));
					textView3.setBackgroundColor(Color.parseColor("#ede5f3"));
					textView5.setBackgroundColor(Color.parseColor("#1eeecf"));
				}
				
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.art, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.more_info) {
			showDialogFragment(MORE_INFO_ID);
			return true;
		} else {
			return super.onOptionsItemSelected(item);
		}
	}

	private void showDialogFragment(int id) {
		// TODO Auto-generated method stub
		if(id == MORE_INFO_ID) {
			mDialog = AlertDialogFragment.newInstance();
			mDialog.show(getFragmentManager(), "Alert");
		}
	}
}
