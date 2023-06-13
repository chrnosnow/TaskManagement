package org.example.working;

import java.util.Random;

public class DoSomeWork {
    public static String work() {
        String[] options = {
                "Armed with a cup of black tea and a chocolate cookie, you get to work vigorously and continue doing " +
                        "so for a few hours.",
                "You are not feeling so great right now, so you reluctantly start working. After a few minutes, you " +
                        "get distracted by pictures of cute animals and your mood improves slightly. You get some " +
                        "more work done.",
                "After a productive conversation with a colleague, you feel really motivated and get the work done " +
                        "for today.",
                "Today’s weather is moody and so are you. You hope some music will lift your spirit and put " +
                        "headphones on. While scowling at the monitor, you get a little bit of work done.",
                "You have a difficult task to do and decide to ask for some help. The other colleagues are busy also," +
                        " but one of them said they will have some time tomorrow to discuss. With this task on hold, " +
                        "you were able to work on another task.",
                "The task you are working on is rather frustrating. You prepare a cup of hot green tea. After a few " +
                        "sips, you manage to relax a bit and start working again."
        };

        return options[new Random().nextInt(options.length)];
    }
}
