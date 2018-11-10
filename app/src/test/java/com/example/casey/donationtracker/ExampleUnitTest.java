package com.example.casey.donationtracker;

import com.example.casey.donationtracker.Model.Model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
//@RunWith(AndroidJUnit4.class)
public class OkubayloginTest {
    private String user = "okubay";
    private String pword = "heidy123";

    private Model testModel;

    @Before
    public void setUp() {
        testModel = new Model();
    }
    @Test
    public void alogin() {
        boolean t = testModel.login(user,pword);
        boolean expected = true;
        assertEquals(expected,t);
    }
    @Test
    public void blogin() {
        boolean f = testModel.login("",pword);
        boolean expected = false;
        assertEquals(expected,f);
    }
    @Test
    public void clogin() {
        boolean a = testModel.login(user,"");
        boolean expected = false;
        assertEquals(expected,a);
    }
    @Test
    public void dlogin() {
        boolean b = testModel.login("okybay",pword);
        boolean expected = false;
        assertEquals(expected,b);
    }
    @Test
    public void elogin() {
        boolean c = testModel.login(user,"heidy12");
        boolean expected = false;
        assertEquals(expected,c);
    }
    @Test
    public void flogin() {
        boolean d = testModel.login("","");
        boolean expected = true;
        assertEquals(expected,d);
    }
}