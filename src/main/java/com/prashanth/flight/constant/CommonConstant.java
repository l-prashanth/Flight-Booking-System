package com.prashanth.flight.constant;

import com.prashanth.flight.model.Flight;
import javafx.scene.control.TableColumn;

import java.util.HashSet;
import java.util.Set;

public class CommonConstant {

    public static  final String FONT_PATH = "C:\\MyFiles\\Learnings\\SpringBoot\\1\\flight\\src\\main\\resources\\times.ttf";
    public static  final String INDIGO = "INDIGO";
    public static  final String SPICEJET = "SPICEJET";
    public static  final String AIR_INDIA = "AIR INDIA";
    public static  final String AKASA_AIR = "AKASA AIR";
    public static  final String BANGALORE = "BANGALORE";
    public static  final String HYDERABAD = "HYDERABAD";
    public static  final String MUMBAI = "MUMBAI";
    public static  final String DELHI = "DELHI";
    public static  final String CHENNAI = "CHENNAI";
    public static  final String ECONOMY = "ECONOMY";
    public static  final String ECONOMY_PRO = "ECONOMY PRO";
    public static  final String BUSINESS = "BUSINESS";
    public static  final String FIRST_CLASS = "FIRST CLASS";
    public static final String[] ORIGINS = {DELHI, MUMBAI, HYDERABAD, BANGALORE, CHENNAI};
    public static final String[] FLIGHT_TYPES = {ECONOMY, ECONOMY_PRO, BUSINESS, FIRST_CLASS};
    public static final String[] AIRLINES = {INDIGO, SPICEJET, AIR_INDIA, AKASA_AIR};
    public static final Set<String> USED_COMBINATIONS = new HashSet<>();
    public static  int uniqueIdCounter = 1;




}
