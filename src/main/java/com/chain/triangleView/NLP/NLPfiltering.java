package com.chain.triangleView.NLP;

import com.google.cloud.language.v1.*;
import java.util.List;

public class NLPfiltering {

	public static Sentiment get_sentiment(String text){

		Sentiment sentiment = NLAnalyze.getInstance().analyzeSentiment(text);

		return sentiment;
	}

	public static List<Token> get_syntax(String text) {
		List<Token> tokenList = NLAnalyze.getInstance().analyzeSyntax(text);

//		System.out.println("2. ========================= 문장 명사 추출 결과 =========================");
//		for (Token token : tokenList) {
//
//			if(token.getPartOfSpeech().getTagValue() == 6){
//
//				System.out.printf("\tText: %s\n", token.getText().getContent());
//				System.out.printf("\tBeginOffset: %d\n", token.getText().getBeginOffset());
//				//	        System.out.println("\n-------------------\n");
//				//	        System.out.printf("Lemma: %s\n", token.getLemma());
//				System.out.println("\n-------------------\n");
//				System.out.printf("PartOfSpeechTag: %s\n", token.getPartOfSpeech().getTag());
//				//	        System.out.printf("\tAspect: %s\n", token.getPartOfSpeech().getAspect());
//				//	        System.out.printf("\tCase: %s\n", token.getPartOfSpeech().getCase());
//				//	        System.out.printf("\tForm: %s\n", token.getPartOfSpeech().getForm());
//				//	        System.out.printf("\tGender: %s\n", token.getPartOfSpeech().getGender());
//				//	        System.out.printf("\tMood: %s\n", token.getPartOfSpeech().getMood());
//				//	        System.out.printf("\tNumber: %s\n", token.getPartOfSpeech().getNumber());
//				//	        System.out.printf("\tPerson: %s\n", token.getPartOfSpeech().getPerson());
//				//	        System.out.printf("\tProper: %s\n", token.getPartOfSpeech().getProper());
//				//	        System.out.printf("\tReciprocity: %s\n", token.getPartOfSpeech().getReciprocity());
//				//	        System.out.printf("\tTense: %s\n", token.getPartOfSpeech().getTense());
//				//	        System.out.printf("\tVoice: %s\n", token.getPartOfSpeech().getVoice());
//				System.out.println("\n-------------------\n");
//				//	        System.out.println("DependencyEdge");
//				//	        System.out.printf("\tHeadTokenIndex: %d\n", token.getDependencyEdge().getHeadTokenIndex());
//				//	        System.out.printf("\tLabel: %s\n\n", token.getDependencyEdge().getLabel());
//			}
//		}
		
		return tokenList;
	}
}
