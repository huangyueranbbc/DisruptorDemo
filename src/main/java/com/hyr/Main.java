package com.hyr;

/*******************************************************************************
 * @date 2018-12-24 下午 3:58
 * @author: <a href=mailto:>黄跃然</a>
 * @Description:
 ******************************************************************************/
public class Main {

    public static void main(String[] args) {
        if (args == null || args.length != 2) {
            printUsage();
            return;
        }
        if ("1".equals(args[0])) {
            com.hyr.disruptor.Main.main(new String[]{args[1]});
        } else if ("2".equals(args[0])) {
            com.hyr.blockqueue.Main.main(new String[]{args[1]});
        } else {
            printUsage();
        }
    }

    private static void printUsage() {
        System.out.println("Usage: java -jar DisruptorDemo.jar TYPE{1|2} <CONSUMER THREAD NUM>");
    }

}
