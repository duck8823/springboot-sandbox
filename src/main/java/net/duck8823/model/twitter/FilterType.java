package net.duck8823.model.twitter;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import twitter4j.Status;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by maeda on 2016/01/11.
 */
public enum FilterType {

	TEXT{
		@Override
		boolean filter(Status status, String keyword){
			Pattern pattern = Pattern.compile(StringEscapeUtils.escapeJava(keyword));
			Matcher matcher = pattern.matcher(status.getText());
			return matcher.find();
		}
	},
	SCREEN_NAME{
		@Override
		boolean filter(Status status, String keyword){
			Pattern pattern = Pattern.compile("^" + StringEscapeUtils.escapeJava(keyword) + "$");
			Matcher matcher = pattern.matcher(status.getText());
			return matcher.matches();
		}
	},
	;

	abstract boolean filter(Status status, String keyword);

}