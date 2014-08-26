
package com.kaylee.codecampfragment;

import org.json.JSONObject;

/**
 * @author Akapo Damilola F. [ helios66, fdamilola ]
 *
 * 
 */

public class NewsItem {
	/*
	 * "title": "Israel deploys troops in Gaza border",
            "link": "http://www.punchng.com/news/israel-deploys-troops-in-gaza-border/",
            "desc": "Israel&#8217;s army said on Thursday it has moved a small number of reinforcements towards the border with Gaza, following an uptick in rocket fire from the Palestinian territory. The deployment also comes amid rising tension in Israel and the Palestinian territories after a Palestinian boy was kidnapped and killed, apparently in revenge for the murder...&nbsp;[Read More...]",
            "content": "Israel&#8217;s army said on Thursday it has moved a small number of reinforcements towards the border with Gaza, following an uptick in rocket fire from the Palestinian territory.\nThe deployment also comes amid rising tension in Israel and the Palestinian territories after a Palestinian boy was kidnapped and killed, apparently in revenge for the murder of three Israeli teens in the West Bank.\n&#8220;We are moving and we have moved forces in order to serve defence activities and forward preparation, but we have no interest in escalation,&#8221; army spokesman Lieutenant Colonel Peter Lerner told journalists.\nThe reinforcements were reserve officers at &#8220;headquarter level, not in the field,&#8221; Lerner said, and were purely a defensive measure.\n&#8220;We have no interest in deepening the conflict with Gaza,&#8221; he said.\nMore than 30 rockets were fired on Wednesday and Thursday from Gaza, which is controlled by Islamist movement Hamas, the army said.\nLerner said Hamas itself fired some of the rockets.\nIsrael responded with air strikes, wounding 11 Palestinians in the Strip.\nSome rockets landed in southern Israel, causing damage to buildings but no casualties.\nHamas warned Israel it would &#8220;pay the price&#8221; for the abduction and killing of 16-year-old Mohammed Abu Khder in east Jerusalem on Wednesday.\nThe murder triggered an outpouring of rage in Shuafat, where Abu Khder&#8217;s family lives.\nClashes erupted between stone-throwing Palestinians and Israeli riot police, raging from dawn on Wednesday until the early hours on Thursday, also spreading to many other areas in east Jerusalem.\nAbu Khder&#8217;s killing is believed to be a revenge attack for the kidnap and murder of Israeli teenagers Naftali Frenkel, Gilad Shaer and Eyal Yifrach in the West Bank in June.\nIsrael blamed Hamas for abducting and killing the three Israelis and waged a crushing arrest campaign against the movement&#8217;s West Bank network, which resulted in the deaths of several Palestinians.\n",
            "date": "Thu, 03 Jul 2014 20:19:24 +0000"
	 */
	
	private String title, link, desc, content, date;
	
	public NewsItem(JSONObject json){
		try{
			this.title = json.getString("title");
			this.link = json.getString("link");
			this.desc = json.getString("content");
			this.content = json.getString("content");
			this.date = json.getString("date");
		}catch(Exception m){
			m.printStackTrace();
		}
	}
	
	public String[] getAll(){
		String[] data = new String[5];
		data[0] = this.title;
		data[1] = this.desc;
		data[2] = this.content;
		data[3] = this.date;
		data[4] = this.link;
		
		return data;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}

