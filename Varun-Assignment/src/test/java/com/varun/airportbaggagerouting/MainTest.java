package com.varun.airportbaggagerouting;

import com.varun.airportbaggagerouting.Main;
import junit.framework.Test;
import junit.framework.TestCase;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

public class MainTest extends TestCase {

    public void testMain(){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Main.main(new String [] {"airport-baggage/src/test/java/InputTest.txt"});
        String output=baos.toString();
        assertEquals("0001 Concourse_A_Ticketing A5 A1 : 11\n" +
                "0002 A5 A1 A2 A3 A4 : 9\n" +
                "0003 A2 A1 : 1\n" +
                "0004 A8 A9 A10 A5 : 6\n" +
                "0005 A7 A8 A9 A10 A5 BaggageClaim : 12\n",output);
    }
}
