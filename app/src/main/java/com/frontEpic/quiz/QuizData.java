package com.frontEpic.quiz;

public class QuizData {
    private static Object[][] dataArray = {
        {"The Aragorn's sword was called Ethereum.", false},
        {"Gandalf had a long beard.", true},
            {"Bilbo gave his ring to Frodo.", true},
            {"Saruman saved Gandalf from Balrog.", false},
            {"Sam died trying to kill an orc in Mordor.", false},
            {"Moria was an underground dwarves kingdom.", true},
            {"Sauron conquered Minas Tirith and killed Denethor.", false},
            {"The Helm's Deep was the Rohan's stronghold.", true}
    };

    public static Object[][] getDataArray() {
        return dataArray;
    }
}
