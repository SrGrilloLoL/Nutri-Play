package com.example.inicio.api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    private String regex;
    private String value;
    private Pattern pattern;
    private Matcher matcher;

    public Regex() {
    }

    public Regex(String regex, String value) {
        this.regex = regex;
        this.value = value;
        this.pattern = Pattern.compile(regex);
        this.matcher = pattern.matcher(value);
    }

    public boolean match() {
        return this.matcher.find();
    }

    public String getMatches() {
        return this.matcher.group();
    }

    public String getRegex() {
        return this.regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
        this.pattern = Pattern.compile(regex);
        if (this.value != null) {
            this.matcher = pattern.matcher(value);
        }
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
        if (this.regex != null) {
            this.pattern = Pattern.compile(regex);
            this.matcher = pattern.matcher(value);
        }
    }

}
