import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;

public class StringReassemblyTest {

    @Test
    public void combination_Buck() {
        String str1 = "Bucks -- Beat";
        String str2 = "Beat Mich";
        int overlap = StringReassembly.overlap(str1, str2);
        String combination = StringReassembly.combination(str1, str2, overlap);

        assertEquals("Bucks -- Beat Mich", combination);
    }

    @Test
    public void combination_Michigan() {
        String str1 = "Beat Mich";
        String str2 = "Michigan~";
        int overlap = StringReassembly.overlap(str1, str2);
        String combination = StringReassembly.combination(str1, str2, overlap);

        assertEquals("Beat Michigan~", combination);
    }

    @Test
    public void addToSetAvoidingSubstrings_hasSubString() {
        Set<String> strSet = new Set1L<String>();
        Set<String> strSetCheck = new Set1L<String>();
        String str1 = "Michigan~";
        String str2 = "o Bucks -- B";
        String subStr = "ichigan~";

        strSet.add(str1);
        strSet.add(str2);
        strSetCheck.add(str1);
        strSetCheck.add(str2);

        StringReassembly.addToSetAvoidingSubstrings(strSet, subStr);

        assertEquals(strSetCheck, strSet);

    }

    @Test
    public void addToSetAvoidingSubstrings_noSubString() {
        Set<String> strSet = new Set1L<String>();
        Set<String> strSetCheck = new Set1L<String>();
        String str1 = "Michigan~";
        String str2 = "o Bucks -- B";
        String subStr = "Beat Mich";

        strSet.add(str1);
        strSet.add(str2);
        strSetCheck.add(str1);
        strSetCheck.add(str2);
        strSetCheck.add(subStr);

        StringReassembly.addToSetAvoidingSubstrings(strSet, subStr);

        assertEquals(strSetCheck, strSet);

    }

    @Test
    public void linesFromInput_1() {
        Set<String> linesFromInput = new Set1L<String>();
        Set<String> linesFromInputCkeck = new Set1L<String>();
        SimpleReader input = new SimpleReader1L("cheer-8-2.txt");
        String str1 = "Bucks -- Beat";
        String str2 = "Go Bucks";
        String str3 = "o Bucks -- B";
        String str44 = "Beat Mich";
        String str4 = "ichigan~";
        String str5 = "Bucks";
        String str6 = "Michigan~";
        linesFromInputCkeck.add(str1);
        linesFromInputCkeck.add(str2);
        linesFromInputCkeck.add(str3);
        linesFromInputCkeck.add(str44);

        //linesFromInputCkeck.add(str4);
        //linesFromInputCkeck.add(str5);
        linesFromInputCkeck.add(str6);
        linesFromInput = StringReassembly.linesFromInput(input);

        assertEquals(linesFromInputCkeck, linesFromInput);
    }

}
