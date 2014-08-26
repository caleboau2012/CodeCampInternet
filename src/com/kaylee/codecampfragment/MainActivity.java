package com.kaylee.codecampfragment;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.codecamp.libs.RestClient;
import com.codecamp.libs.RestClient.RequestMethod;

import android.support.v7.app.ActionBarActivity;
//import com.codecamp.*;

import android.support.v4.app.Fragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
			.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		ArrayList<String> data;
		ArrayAdapter<String> adapter;

		public PlaceholderFragment() {
			data = new ArrayList<>();
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);

			ListView list = (ListView) rootView.findViewById(R.id.list);
			adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data);

			list.setAdapter(adapter); 

			new DamiAsyncTask().execute();

			return rootView;
		}
		public class DamiAsyncTask extends AsyncTask<Void, Void, String[]>{

			
			private RestClient dami;
			private String text;
			private ArrayList<String> dataS;

			ProgressDialog pDiag;

			@Override
			protected void onPreExecute() {
				// TODO Auto-generated method stub
				super.onPreExecute();
				pDiag = new ProgressDialog(getActivity());
				pDiag.setMessage("Loading..");
				pDiag.show();
				dataS = new ArrayList<>();
			}

			
			
			@Override
			protected String[] doInBackground(Void... params) {
				// TODO Auto-generated method stub

				dami = new RestClient("http://code.caleb.com.ng/kopawee/news/");
				try{
					dami.Execute(RequestMethod.GET);

					text = dami.getResponse();
					
					JSONObject mainObject = new JSONObject(text);
					mainObject.get("response");
					JSONArray dataObject = mainObject.getJSONArray("data");

					for (int i =0; i< dataObject.length() ; i ++){
						dataS.add(new NewsItem((JSONObject)dataObject.get(i)).getTitle());
					}

				}
				catch(Exception ex){
					response = "shing";
				}


				return null;
			}
			
			@Override
			protected void onPostExecute(String[] result) {
				// TODO Auto-generated method stub
				super.onPostExecute(result);
				//adapter.addAll(dataS);
				data.addAll(dataS);
				adapter.notifyDataSetChanged();
				pDiag.dismiss();
				
			}
		}
	}


}
