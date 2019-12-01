import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        String test = "Hamlet is a play.";
        String actual = hamletParser.changeHamletToLeon(test);
        String expected = "Leon is a play.";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        String test = "There once was a boy named Horatio hey hey!";
        String actual = hamletParser.changeHoratioToTariq(test);
        String expected = "There once was a boy named Tariq hey hey!";
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testFindHoratio() {
        String test = hamletText;
        Pattern pattern = Pattern.compile("Horatio");
        Matcher matcher = pattern.matcher(test);
        Assert.assertTrue(matcher.find());
    }

    @Test
    public void testFindHamlet() {
        String test = hamletText;
        Pattern pattern = Pattern.compile("Hamlet");
        Matcher matcher = pattern.matcher(test);
        Assert.assertTrue(matcher.find());
    }
}