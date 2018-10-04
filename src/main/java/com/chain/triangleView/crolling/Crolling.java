package com.chain.triangleView.crolling;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Crolling {

	public ArrayList<Status> crolling_twitter(String str) {
		ArrayList<Status> tweets = new ArrayList<Status>();
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setOAuthConsumerKey("N1xG5BztGMWnx25x6R6nZF2HY");
		cb.setOAuthConsumerSecret("z6Mzy2D9r62r6puqAjhBWxhZNQHjHb0PNsUNUE8Zul9otZXke3");
		cb.setOAuthAccessToken("2975562769-YCZebNCoTyxWTHoxxlYh2pXbWDOiLsu8zV7DFU1");
		cb.setOAuthAccessTokenSecret("yGCuxO4W114wynPjkwwKoJwJtC9C43nbQfYQUbzpFudvy");

		Twitter twitter = new TwitterFactory(cb.build()).getInstance();
		int wantedTweets = 10;
		int remainingTweets = wantedTweets;
		Query query = new Query(str);

		try{ 

			while(remainingTweets > 0){

				remainingTweets = wantedTweets - tweets.size();
				if(remainingTweets > 100){
					query.count(100);
				}
				else{
					query.count(remainingTweets); 
				}

				QueryResult result = twitter.search(query);
				tweets.addAll(result.getTweets());
				Status s = tweets.get(tweets.size()-1);
				long firstQueryID = s.getId();
				query.setMaxId(firstQueryID);
				remainingTweets = wantedTweets - tweets.size();
			}
		}
		catch(TwitterException te){

			System.exit(-1);
		}catch(ArrayIndexOutOfBoundsException e) {
			
			tweets = null;
		}
		return tweets;
	}
}